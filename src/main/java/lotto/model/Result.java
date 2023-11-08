package lotto.model;

public class Result {
    int first;
    int second;
    int third;
    int fourth;
    int fifth;

    public Result(int first, int second, int third, int fourth, int fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public void addFirst() {
        this.first += 1;
    }

    public void addSecond() {
        this.second += 1;
    }

    public void addThird() {
        this.third += 1;
    }

    public void addFourth() {
        this.fourth += 1;
    }

    public void addFifth() {
        this.fifth += 1;
    }
}
