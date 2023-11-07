package lotto.model;

public class LottoResultCount {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public void incrementFirst() {
        first++;
    }

    public void incrementSecond() {
        second++;
    }

    public void incrementThird() {
        third++;
    }

    public void incrementFourth() {
        fourth++;
    }

    public void incrementFifth() {
        fifth++;
    }

    public LottoResult toLottoResult() {
        return new LottoResult(
                this.first,
                this.second,
                this.third,
                this.fourth,
                this.fifth);
    }
}
