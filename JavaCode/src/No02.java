/**
 * 实现Singleton模式
 * Created by quhan on 2017/3/2.
 */
public class No02 {

}

//饿汉模式 线程安全
class A {
    private A(){}
    private static final A a = new A();
    public static A getInstance() {
        return a;
    }
}


//懒汉模式 线程安全
class B {
    private B(){}
    private static B b = null;
    public static B getInstance(){
        if (b == null){
            synchronized(B.class) {
                if (b == null) {
                    b = new B();
                }
            }
        }
        return b;
    }
}