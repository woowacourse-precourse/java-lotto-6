package lotto.output;


import lotto.domain.LottoCalculater;

public class LottoRateOfReturn {

    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printRateOfReturn(LottoCalculater lottoCalculater) {
        System.out.println(getPrintRate(lottoCalculater));
    }

    private static String getPrintRate(LottoCalculater lottoCalculater) {
        return String.format(RATE_OF_RETURN_MESSAGE
                , lottoCalculater.calculateRate());
    }

}
