package lotto.domain.computer;

import static lotto.constant.LottoNumber.FIFTH_PRIZE;
import static lotto.constant.LottoNumber.FIRST_PRIZE;
import static lotto.constant.LottoNumber.FORTH_PRIZE;
import static lotto.constant.LottoNumber.SECOND_PRIZE;
import static lotto.constant.LottoNumber.THIRD_PRIZE;

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

    private double getRateOfReturn() {
        return (double) (
                (first * FIRST_PRIZE.getNumber()) +
                (second * SECOND_PRIZE.getNumber()) +
                (third * THIRD_PRIZE.getNumber()) +
                (forth * FORTH_PRIZE.getNumber()) +
                (fifth * FIFTH_PRIZE.getNumber())) * 100 / money;
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원) - " + fifth + "개\n" +
                "4개 일치 (50,000원) - " + forth + "개\n" +
                "5개 일치 (1,500,000원) - " + third + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개\n" +
                "6개 일치 (2,000,000,000원) - " + first + "개\n" +
                "총 수익률은 " + getRateOfReturn() + "%입니다.\n";
    }
}
