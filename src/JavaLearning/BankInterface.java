package JavaLearning;

public interface BankInterface {
    // public String name= "BankInterface";

    // 抽象 方法 - 定义 规范
    public abstract void saveMoney(int input);

    // 抽象 方法 - 定义 规范
    public abstract void borrowMoney(int input);

    // 抽象 方法 - 定义 规范
    public abstract void transferMoney(int input);

}
