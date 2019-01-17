package cn.meeler.两种单例模式;

public class SingletonEnum {

    private enum Holdder {
        INSTANCE;
        private SingletonEnum singletonEnum;
        Holdder() {
            this.singletonEnum = new SingletonEnum();
        }
        private SingletonEnum getSingleTon() {
            return singletonEnum;
        }
    }

    public static SingletonEnum getInstance() {
        return Holdder.INSTANCE.getSingleTon();
    }

}
