package lotto.util.message;

import lotto.domain.RankInfo;

import java.text.NumberFormat;
import java.util.Arrays;

public enum LottoRankingMessage {
    FIRST("6개 일치 %s - %s개", RankInfo.FIRST),
    SECOND("5개 일치, 보너스 볼 일치 %s - %s개", RankInfo.SECOND),
    THIRD("5개 일치 %s - %d개", RankInfo.THIRD),
    FOURTH("4개 일치 %s - %d개", RankInfo.FOURTH),
    FIFTH("3개 일치 %s - %d개", RankInfo.FIFTH);

    private final String message;
    private final RankInfo lottoRanking;

    LottoRankingMessage(String message, final RankInfo lottoRanking) {
        this.message = message;
        this.lottoRanking = lottoRanking;
    }

    public static String findLottoRankingMessage(final RankInfo lottoRanking, int numberOfWins) {
        return Arrays.stream(LottoRankingMessage.values())
                .filter(utils -> utils.lottoRanking == lottoRanking)
                .map(utils -> getFormat(lottoRanking, numberOfWins, utils))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }


    private static String getFormat(RankInfo lottoRanking, int numberOfWins, LottoRankingMessage utils) {
        String prizeFormat = NumberFormat.getInstance().format(lottoRanking.getPrizeMoney());
        return String.format(utils.message, prizeFormat, numberOfWins);
    }
}
