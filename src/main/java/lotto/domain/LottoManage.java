package lotto.domain;

public class LottoManage {
    private int fifth;
    private int fourth;
    private int third;
    private int second;
    private int first;

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

    public void addFifth() {
        this.fifth += 1;
    }

    public void addFourth() {
        this.fourth += 1;
    }

    public void addThird() {
        this.third += 1;
    }

    public void addSecond() {
        this.second += 1;
    }

    public void addFirst() {
        this.first += 1;
    }

}
