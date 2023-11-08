package lotto.model;

import java.text.NumberFormat;
import java.util.Map;

public enum LottoResult {

    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int prizeMoney;

    LottoResult(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = winningMoney;
    }

    public static LottoResult calculate(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }
        if (countOfMatch == 5) {
            return THIRD;
        }
        if (countOfMatch == 4) {
            return FOURTH;
        }
        if (countOfMatch == 3) {
            return FIFTH;
        }
        if (countOfMatch == 6) {
            return FIRST;
        }
        return NONE;
    }

    public static String makeResult(Map<LottoResult, Integer> statistics) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        StringBuilder sb = new StringBuilder();
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult == NONE) {
                continue;
            }
            sb.append(appendLottoResult(lottoResult, statistics.getOrDefault(lottoResult, 0)));
            if (lottoResult != FIRST) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static StringBuilder appendLottoResult(LottoResult lottoResult, int count) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append(lottoResult.countOfMatch).append("개 일치");
        if (lottoResult == SECOND) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(numberFormat.format(lottoResult.prizeMoney)).append("원) - ")
                .append(count).append("개");
        return sb;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
