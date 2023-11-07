package lotto.domain;

public class Rank {
    private final int fifth;
    private final int fourth;
    private final int third;
    private final int second;
    private final int first;

    public Rank(int fifth, int fourth, int third, int second, int first) {
        this.fifth = fifth;
        this.fourth = fourth;
        this.third = third;
        this.second = second;
        this.first = first;
    }

    public int getFifth() {
        return fifth;
    }

    public int getFourth() {
        return fourth;
    }

    public int getThird() {
        return third;
    }

    public int getSecond() {
        return second;
    }

    public int getFirst() {
        return first;
    }

    @Override
    public String toString() {
        return "{" + fifth +
                ", " + fourth +
                ", " + third +
                ", " + second +
                ", " + first +
                '}';
    }
}
