package lotto.domain;

public class Result {
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public void plusRank(int count, boolean bonus) {
        if (count == 6)
            first++;
        if (count == 5)
            checkBonus(bonus);
        if (count == 4)
            fourth++;
        if (count == 3)
            fifth++;
    }

    private void checkBonus(boolean bonus) {
        if (bonus) {
            second++;
            return;
        }
        third++;
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
