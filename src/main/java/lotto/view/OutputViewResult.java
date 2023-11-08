package lotto.view;

import lotto.domain.LottoMoney;

import java.util.Map;

public class OutputViewResult {
    private static final String WIN_STATICS_MESSAGE = "당첨 통계";
    private static final String TOTAL_RATE_IS_MESSAGE = "총 수익률은 ";
    private static final String TOTAL_RATE_IS_MESSAGE_FINISH = "%입니다.";
    private static final String LOTTO_RESULT_CASE_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String LOTTO_RESULT_CASE_BASIC_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String SEPARATE = "---";

    public static void printResultStart() {
        System.out.println(WIN_STATICS_MESSAGE);
        System.out.println(SEPARATE);
    }

    public static void printResultLotto(Map<LottoMoney, Integer> lottoResult) {
        lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoMoney.ZERO)
                .forEach(entry -> System.out.println(getPrintResultLotto(entry.getKey(), entry.getValue())));
    }

    private static String getPrintResultLotto(LottoMoney lottoMoney, int count) {
        if (lottoMoney == LottoMoney.SECOND) {
            return String.format(LOTTO_RESULT_CASE_SECOND_MESSAGE
                    , lottoMoney.getMatchCount()
                    , String.format("%,d", lottoMoney.getMoney())
                    , count);

        }
        return String.format(LOTTO_RESULT_CASE_BASIC_MESSAGE,
                lottoMoney.getMatchCount(),
                String.format("%,d", lottoMoney.getMoney()),
                count
        );
    }

    public static void printResultRate(Double rate) {
        System.out.println(TOTAL_RATE_IS_MESSAGE + rate + TOTAL_RATE_IS_MESSAGE_FINISH);
    }
}
