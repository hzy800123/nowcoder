package JavaLearning;

public class StrangeStudent implements PersonInterface {

    private String name= "BankInterface";

    @Override
    public void getup(int input) {
        System.out.println("StrangeStudent is getup now...");
    }

    @Override
    public void sitdown(int input) {
        System.out.println("StrangeStudent is sitdown now...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
