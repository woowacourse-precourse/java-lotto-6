package lotto.domain;

public class LottoResult {
    private int first_place = 0;
    private int second_place = 0;
    private int third_place = 0;
    private int forth_place = 0;
    private int fifth_place = 0;

    public LottoResult() {
    }

    public int getFirst_place() {
        return first_place;
    }

    public void addFirst_place() {
        first_place++;
    }

    public int getSecond_place() {
        return second_place;
    }

    public void addSecond_place() {
        second_place++;
    }

    public int getThird_place() {
        return third_place;
    }

    public void addThird_place() {
        third_place++;
    }

    public int getForth_place() {
        return forth_place;
    }

    public void addForth_place() {
        forth_place++;
    }

    public int getFifth_place() {
        return fifth_place;
    }

    public void addFifth_place() {
        fifth_place++;
    }
}
