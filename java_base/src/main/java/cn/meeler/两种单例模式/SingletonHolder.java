package cn.meeler.两种单例模式;

public class SingletonHolder {
    private static class Holder {
        private static SingletonHolder instance = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return Holder.instance;
    }


    public static void main(String[] args) {
        SingletonHolder instance = SingletonHolder.getInstance();
        SingletonHolder instance1 = SingletonHolder.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}
