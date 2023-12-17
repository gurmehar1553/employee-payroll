package employee.javaFileIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchServiceDemo {
    private final WatchService watcher;
    private final Map<WatchKey,Path> dirWatchers;

    /**
     * Initialising watcher and dirWatchers
     * @param dir
     * @throws IOException
     */
    WatchServiceDemo(Path dir) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.dirWatchers = new HashMap<>();
        scanRegisterDir(dir);
    }

    /**
     * Scanning its subdirectories
     * @param start
     * @throws IOException
     */
    private void scanRegisterDir(final Path start) throws IOException {
        Files.walkFileTree(start, new SimpleFileVisitor<Path>(){
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                registerDir(dir);
                return FileVisitResult.CONTINUE;
            }
        });

    }

    /**
     * Registering directories and subdirectories
     * @param dir
     * @throws IOException
     */
    private void registerDir(Path dir) throws IOException {
        WatchKey key=dir.register(watcher,ENTRY_CREATE,ENTRY_DELETE,ENTRY_MODIFY);
        dirWatchers.put(key,dir);
    }

    /**
     * Process all events
     * for keys in watcher
     */
    @SuppressWarnings({"rawtypes","unchecked"})
    public void processEvents(){
        long count=1;
        while (true){
            WatchKey key;
            try {
                key=watcher.take();
                count++;
            }
            catch (InterruptedException x){
                System.out.println("count : "+count);
                return;
            }
            Path dir=dirWatchers.get(key);
            if(dir==null){
                continue;
            }
            for (WatchEvent<?> event:key.pollEvents()){
                WatchEvent.Kind kind=event.kind();
                Path name=((WatchEvent<Path>)event).context();
                Path child=dir.resolve(name);
                System.out.println(event.kind()+" "+child);//print out the event
                //if dir created then register it and it's sub directory
                if(kind==ENTRY_CREATE){
                    try {
                        if(Files.isDirectory(child)) scanRegisterDir(child);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (kind.equals(ENTRY_DELETE)) {
                    if (Files.isDirectory(child)) dirWatchers.remove(key);
                }
            }
            //reset key if dir is removed
            boolean valid=key.reset();
            if(!valid){
                dirWatchers.remove(key);
                if (dirWatchers.isEmpty()){
                    break;
                }
            }
        }
    }
}
