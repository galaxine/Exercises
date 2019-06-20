package logic;

public class Calculator {
    private int sum;

    public Calculator(int n) {
        this.sum =n;
    }

    public Calculator() {
        this.sum =0;
    }

    public int incrementByN (int n) {
        this.sum = this.sum + n;
        return this.sum;
    }

    public int decrementByN (int n) {
        this.sum = this.sum-n;
        return this.sum;
    }

    public int resetSum() {
        this.sum = 0;
        return sum;
    }

    public int getSum() {
        return sum;
    }
}
