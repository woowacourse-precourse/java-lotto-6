package lotto.computer.result;

public class Result {

    private int first;
    private int second;
    private int third;
    private int forth;
    private int fifth;

    private int money;

    public Result(int money) {
        this.money = money;
    }

    public void plusFirst() {
        first++;
    }

    public void plusSecond() {
        second++;
    }

    public void plusThird() {
        third++;
    }

    public void plusForth() {
        forth++;
    }

    public void plusFifth() {
        fifth++;
    }

    public double getRateOfReturn() {
        return (double) ((first * 2000000000) +
                (second * 30000000) +
                (third * 1500000) +
                (forth * 50000) +
                (fifth * 5000)) * 100 / money;
    }

    @Override
    public String toString() {
        return
                "3개 일치 (5,000원) - " + fifth + "개\n" +
                        "4개 일치 (50,000원) - " + forth + "개\n" +
                        "5개 일치 (1,500,000원) - " + third + "개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개\n" +
                        "6개 일치 (2,000,000,000원) - " + first + "개\n" +
                        "총 수익률은 " + getRateOfReturn() + "%입니다.\n";
    }
}
