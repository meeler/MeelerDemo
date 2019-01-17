package test.classloader;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String replace = name.replace(".", "/");
        Path path = Paths.get("");
        return null;
    }
}
