package lotto.output;

import lotto.domain.LottoCalculater;
import lotto.domain.LottoResult;

import java.util.Arrays;

public class LottoStatistics {

    private static final String HEADLINE = "당첨 통계" + '\n' + "---";
    private static final String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String BOUNUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public static void printStatistics(LottoCalculater lottoCalculater) {
        System.out.println(HEADLINE);
        Arrays.stream(LottoResult.values())
                .filter(lottoResult -> !lottoResult.equals(LottoResult.EMPTY))
                .forEach(lottoResult -> System.out.println(getPrintResultPrize(lottoResult, lottoCalculater)));
    }

    private static String getPrintResultPrize(LottoResult lottoResult, LottoCalculater lottoCalculater) {
        if (lottoResult == LottoResult.FIVEANDBONUS) {
            return String.format(BOUNUS_RESULT_MESSAGE
                    , lottoResult.getMatchLottoNumber()
                    , String.format("%,d", lottoResult.getMoney())
                    , lottoCalculater.getLottoResultCount(lottoResult));
        }

        return String.format(RESULT_MESSAGE
                , lottoResult.getMatchLottoNumber()
                , String.format("%,d", lottoResult.getMoney())
                , lottoCalculater.getLottoResultCount(lottoResult));
    }
}
