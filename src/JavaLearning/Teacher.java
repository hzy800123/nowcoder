package JavaLearning;

public class Teacher extends Person{

    public Teacher() {
        count++;
        System.out.println("count = " + count);
    }

    @Override
    public void sit(int input) {
        System.out.println("Teacher is sitting ..." + input);
    }

    @Override
    public void sit2(int input) {
        System.out.println("Teacher is sitting 2 ..." + input);
    }
}
