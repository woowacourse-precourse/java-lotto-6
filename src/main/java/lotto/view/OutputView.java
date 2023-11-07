package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.EnumMap;

public class OutputView {
    private static final String BUY_LOTTO_COUNT_INFO = "%d개를 구매했습니다.%n";
    private static final String START_PRIZE_INFO = "당첨 통계";
    private static final String NEW_LINE = "---";
    private static final String PRIZE_MESSAGE_INFO = "%d개 일치 (%s원) - %d개%n";
    private static final String SECOND_PRIZE_INFO = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    private static final String RATE_OF_RETURN_INFO = "총 수익률은 %s%%입니다.";
    public static void outputLottoCount(int lottoCount) {
        System.out.printf(BUY_LOTTO_COUNT_INFO, lottoCount);
    }

    public static void outputIssuedLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void outputWinningInfo(EnumMap<Prize, Integer> prizeMap) {
        System.out.println(START_PRIZE_INFO);
        System.out.println(NEW_LINE);
        for (Prize prize : prizeMap.keySet()) {
            String message = outPutWinningInfo(prize);
            System.out.printf(message, prize.getEqualNumCount(), prize.convertWinningAmount(), prizeMap.get(prize));
        }
    }

    private static String outPutWinningInfo(Prize prize) {
        if (prize == Prize.SECOND) {
            return SECOND_PRIZE_INFO;
        }
        return PRIZE_MESSAGE_INFO;
    }

    public static void outputRateOfReturn(String rateOfReuturn) {
        System.out.printf(RATE_OF_RETURN_INFO, rateOfReuturn);
    }
}
