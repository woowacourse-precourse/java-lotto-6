package lotto.domain.model;

import static lotto.utils.LottoEnum.LOTTO_BONUS_NUMBER_COUNT;

public class ResultTable {
    private int numberOfMatched; // 매칭된 번호의 개수
    private long prize; // 당첨 금액
    private int count; // 당첨된 로또의 개수

    public ResultTable(int matchCount, long prize) {
        this.numberOfMatched = matchCount;
        this.prize = prize;
        this.count = 0;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%s원) - %d개", numberOfMatched,
                String.format("%,d", prize), count);
    }

    public String getFinalResult() {
        if (numberOfMatched == LOTTO_BONUS_NUMBER_COUNT.getValue()) {
            return String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개",
                    String.format("%,d", prize), count);
        }
        return toString();
    }

    public int getNumberOfMatched() {
        return numberOfMatched;
    }

    public long getTotalPrize() {
        return prize * count;
    }

    public void incrementCount() {
        this.count++;
    }
}



