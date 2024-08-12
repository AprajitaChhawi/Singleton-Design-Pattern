public class SingletonEnum {
    public static void main(String[] args) {
        SingletonEnum1 singleton = SingletonEnum1.UNIQUE_INSTANCE;
        singleton.showMessage();

        SingletonEnum1 singleton2 = SingletonEnum1.UNIQUE_INSTANCE;
        singleton2.showMessage();

        //even if we create one more instance , it will still point to same memory reference
        System.out.println(singleton==singleton2);

    }
}
