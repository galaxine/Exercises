package clicker.applicationLogic;

public class PersonalCalculator implements Calculator {
    private int count;

    public PersonalCalculator (int count) {
        this.count = count;
    }
    public PersonalCalculator() {}

    @Override
    public int giveValue() {
        return count;
    }

    @Override
    public void increase() {
        count++;
    }
}
