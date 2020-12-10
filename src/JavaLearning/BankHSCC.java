package JavaLearning;

public class BankHSCC implements BankInterface {
    @Override
    public void saveMoney(int input) {
        System.out.println("saveMoney here...");
    }

    @Override
    public void borrowMoney(int input) {
        System.out.println("borrowMoney here...");
    }

    @Override
    public void transferMoney(int input) {
        System.out.println("transferMoney here...");
    }
}
