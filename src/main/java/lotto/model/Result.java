package lotto.model;


import static lotto.util.NumberConstant.*;

public class Result {
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public void plusRank(int cnt, boolean bonus) {
        if (cnt == 6)
            first++;
        if (cnt == 5)
            checkBonus(bonus);
        if (cnt == 4)
            fourth++;
        if (cnt == 3)
            fifth++;
    }

    private void checkBonus(boolean bonus) {
        if (bonus) {
            second++;
            return;
        }
        third++;
    }

    public int getRevenue() {
        int revenue = 0;
        revenue += (
                FIRST.getValue() *first
                        + SECOND.getValue()*second
                        + THIRD.getValue()*third
                        + FOURTH.getValue()*fourth
                        + FIFTH.getValue()*fifth
        );
        return revenue;
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