public class NO2_Singleton {

    //饿汉 线程安全
    public static class Singleton1 {
        private static final Singleton1 instance = new Singleton1();
        private Singleton1() {}
        public static Singleton1 getInstance() {
            return instance;
        }
    }

    //懒汉 线程不安全
    public static class Singleton2 {
        private static Singleton2 instance = null;
        private Singleton2() {}
        public static Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }

    //懒汉 线程安全 多线程效率不高
    public static class Singleton3 {
        private static Singleton3 instance = null;
        private Singleton3() {}
        public static synchronized Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }
            return instance;
        }
    }

    //饿汉 线程安全
    public static class Singleton4 {
        private static Singleton4 instance = null;
        private Singleton4() {}
        static {
            instance = new Singleton4();
        }
        public static synchronized Singleton4 getInstance() {
            return instance;
        }
    }

    //静态内部类 线程安全 推荐
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 instance = new Singleton5();
        }
        private Singleton5() {}
        public static Singleton5 getInstance() {
            return SingletonHolder.instance;
        }
    }

    //静态内部类 双重校验锁 线程安全 推荐
    public static class Singleton6 {
        private volatile  static Singleton6 instance = null;
        private Singleton6() {}
        public static Singleton6 getInstance() {
            if (instance == null) {
                synchronized (Singleton6.class) {
                    if (instance == null) {
                        instance = new Singleton6();
                    }
                }
            }
            return instance;
        }
    }

    //枚举 线程安全 推荐
    public enum Singleton7 {
        instance;
    }

    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton6.getInstance() == Singleton6.getInstance());
        System.out.println(Singleton7.instance == Singleton7.instance);
    }
}
