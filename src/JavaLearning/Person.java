package JavaLearning;

// 抽象 类 (包含 至少一个 抽象 方法）
public abstract class Person {
    public static int count = 0;      // DB / Properties control file （ User/password )

    public Person() {
        count++;
        System.out.println("count = " + count);
    }

    public void run() {
        System.out.println("Running now ......");
    }

    public static void setNumber(int value) {
        count = value;
    }


    // 抽象 方法 - 定义 规范
    public abstract void sit(int input);

    // 抽象 方法 - 定义 规范
    public abstract void sit2(int input);
}
