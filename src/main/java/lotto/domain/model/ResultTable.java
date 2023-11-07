package lotto.domain.model;

import lotto.domain.StaticsEnum;

public class ResultTable {
    private int numberOfMatched;
    private long prize;
    private int count = 0; // 당첨된 로또의 개수
    private boolean isBonusMatched = false;

    public ResultTable(StaticsEnum staticsEnum) {
        this.prize = staticsEnum.getPrize();
        this.numberOfMatched = staticsEnum.getCount();

        if (staticsEnum == StaticsEnum.MATCHED_FIVE_WITH_BONUS) {
            this.isBonusMatched = true;
        }
    }

    @Override
    public String toString() {
        if (isBonusMatched) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", numberOfMatched,
                    String.format("%,d", prize), count);
        }
        return String.format("%d개 일치 (%s원) - %d개", numberOfMatched,
                String.format("%,d", prize), count);
    }

    public long getTotalPrize() {
        return prize * count;
    }

    public void incrementCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}



