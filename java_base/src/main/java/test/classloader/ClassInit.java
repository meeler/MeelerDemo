package test.classloader;

public class ClassInit {
    /**
     * 当都是静态变量时则会按照由上到下的顺序进行赋值
     */
    private static int x = 10;

    static {
        x = 100;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println(x);
        System.out.println("BootStrap" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("=======================================");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("ApplicationClassLoader" + ClassInit.class.getClassLoader());
        System.out.println(System.getProperty("java.class.path"));
        Class<ClassInit> classInitClass = ClassInit.class;
        ClassInit classInit = classInitClass.newInstance();

    }
}
