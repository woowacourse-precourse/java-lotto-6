package lotto.domain.dto;

public class LottoPrizeDto {
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

    public void countFirst() {
        first++;
    }

    public void countSecond() {
        second++;
    }

    public void countThird() {
        third++;
    }

    public void countFourth() {
        fourth++;
    }

    public void countFifth() {
        fifth++;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

}
