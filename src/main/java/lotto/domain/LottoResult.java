package lotto.domain;

import static lotto.config.LottoConfig.FIFTH_PRIZE;
import static lotto.config.LottoConfig.FIRST_PRIZE;
import static lotto.config.LottoConfig.FOURTH_PRIZE;
import static lotto.config.LottoConfig.SECOND_PRIZE;
import static lotto.config.LottoConfig.THIRD_PRIZE;

import java.text.NumberFormat;

/**
 * 로또 결과를 관리하는 클래스
 */
public class LottoResult {
    private Integer first = 0;
    private Integer second = 0;
    private Integer third = 0;
    private Integer fourth = 0;
    private Integer fifth = 0;

    public void addFirst() {
        first++;
    }

    public void addSecond() {
        second++;
    }

    public void addThird() {
        third++;
    }

    public void addFourth() {
        fourth++;
    }

    public void addFifth() {
        fifth++;
    }

    public long getTotalPrize() {
        return (long) first * FIRST_PRIZE.getValue()
                + (long) second * SECOND_PRIZE.getValue()
                + (long) third * THIRD_PRIZE.getValue()
                + (long) fourth * FOURTH_PRIZE.getValue()
                + (long) fifth * FIFTH_PRIZE.getValue();
    }

    public void print() {
        String InfoString = "당첨 통계\n"
                + "---\n"
                + String.format("3개 일치 (%s원) - %d개\n", formatNumber(FIFTH_PRIZE.getValue()), fifth)
                + String.format("4개 일치 (%s원) - %d개\n", formatNumber(FOURTH_PRIZE.getValue()), fourth)
                + String.format("5개 일치 (%s원) - %d개\n", formatNumber(THIRD_PRIZE.getValue()), third)
                + String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", formatNumber(SECOND_PRIZE.getValue()), second)
                + String.format("6개 일치 (%s원) - %d개\n", formatNumber(FIRST_PRIZE.getValue()), first);

        System.out.print(InfoString);
    }

    private String formatNumber(long number) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(number);
    }
}
