package lotto.view;

import lotto.model.WinningCriteria;
import java.text.DecimalFormat;

public class RankMessages {
    static DecimalFormat decimalFormat = new DecimalFormat("#,###");
    public static final String FIRST_RANK_MESSAGE =
            String.format("%d개 일치 (%s원)",
                    WinningCriteria.FIRST.getMatchingNumberCount(),
                    decimalFormat.format(WinningCriteria.FIRST.getPrizeAmount())
            );
    public static final String SECOND_RANK_MESSAGE =
            String.format("%d개 일치, 보너스 볼 일치 (%s원)",
                    WinningCriteria.SECOND.getMatchingNumberCount(),
                    decimalFormat.format(WinningCriteria.SECOND.getPrizeAmount())
            );
    public static final String THIRD_RANK_MESSAGE =
            String.format("%d개 일치 (%s원)",
                    WinningCriteria.THIRD.getMatchingNumberCount(),
                    decimalFormat.format(WinningCriteria.THIRD.getPrizeAmount())
            );
    public static final String FOURTH_RANK_MESSAGE =
            String.format("%d개 일치 (%s원)",
                    WinningCriteria.FOURTH.getMatchingNumberCount(),
                    decimalFormat.format(WinningCriteria.FOURTH.getPrizeAmount())
            );
    public static final String FIFTH_RANK_MESSAGE =
            String.format("%d개 일치 (%s원)",
                    WinningCriteria.FIFTH.getMatchingNumberCount(),
                    decimalFormat.format(WinningCriteria.FIFTH.getPrizeAmount())
            );
}
