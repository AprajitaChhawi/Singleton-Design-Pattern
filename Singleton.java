public class Singleton {
    private static Singleton instance;

    // 3. Use this while using 3
    private static Singleton instance2 = new Singleton();

    //4. Use this while using 4
    //Using volatile mean that value of the variable is always read from the main memory,
    // not from the thread's local cache, and that any write to a volatile variable
    // mis immediately visible to all other threads.
    private volatile static Singleton instance3;

    public Singleton() {
    }

    //if two threads use it at the same time , there might be problems
    /*
    * 1. Resolve it using synchronized method
    * 2. Eat 5 star and do nothing
    * 3. Create a eager instance rather than a lazy instance
    * 4. Double-Check locking (synchronize only the first time while creating an instance
    * */
    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }

    //1. Resolve it using synchronized method -> only time synchronized is used is when creating the obj
    // the first time the if is called, after the object is created , synchronized is an overhead .
    public static synchronized Singleton getInstance2(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }

    //3. Create a eager instance rather than a lazy instance
    public static Singleton getInstance3(){
        return instance2;
    }

    //4. Double-Check locking (synchronize only the first time while creating an instance
    public static Singleton getInstance4(){
        if(instance3==null){
            synchronized (Singleton.class){
                if (instance3==null){
                    instance3= new Singleton();
                }
            }
        }
        return instance3;
    }



}
