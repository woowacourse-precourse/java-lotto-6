package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;
import lotto.model.LottoRanking;

public class LottoResultStringBuilder {

    private static final String HIT_MESSAGE = "개 일치";
    private static final String AMOUNT_COUNT_MESSAGE = " (%s원) - %d개";
    private static final String BONUS_BALL_HIT_MESSAGE = ", 보너스 볼 일치";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###");

    public static String build(EnumMap<LottoRanking, Integer> lottoResult) {
        return Arrays.stream(LottoRanking.values())
            .filter(entry -> entry != LottoRanking.UNRANKED)
            .map(lottoRanking -> getString(lottoRanking, lottoResult.getOrDefault(lottoRanking, 0)))
            .collect(Collectors.joining("\n"));
    }

    private static String getString(LottoRanking lottoRanking, Integer count) {
        int hitCount = lottoRanking.getHitCount();
        String winningAmount = MONEY_FORMAT.format(lottoRanking.getWinningAmount());
        String message = hitCount + HIT_MESSAGE;
        if (lottoRanking == LottoRanking.SECOND) {
            message += BONUS_BALL_HIT_MESSAGE;
        }
        return message + AMOUNT_COUNT_MESSAGE.formatted(winningAmount, count);
    }
}
