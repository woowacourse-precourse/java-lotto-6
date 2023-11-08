package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.view.message.OutputMessage;

import java.util.EnumMap;
import java.util.List;

public class OutputView {
    public static void outputLottoCount(int lottoCount) {
        System.out.printf(OutputMessage.BUY_LOTTO_COUNT_INFO.getMessage(), lottoCount);
    }

    public static void outputIssuedLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void outputWinningInfo(EnumMap<Prize, Integer> prizeMap) {
        System.out.println(OutputMessage.START_PRIZE_INFO.getMessage());
        System.out.println(OutputMessage.NEW_LINE.getMessage());
        for (Prize prize : prizeMap.keySet()) {
            if (prize == Prize.ZERO) {
                continue;
            }
            OutputMessage message = outPutWinningInfo(prize);
            System.out.printf(message.getMessage(), prize.getEqualNumCount(), prize.convertWinningAmount(), prizeMap.get(prize));
        }
    }

    private static OutputMessage outPutWinningInfo(Prize prize) {
        if (prize == Prize.SECOND) {
            return OutputMessage.SECOND_PRIZE_INFO;
        }
        return OutputMessage.PRIZE_MESSAGE_INFO;
    }

    public static void outputRateOfReturn(String rateOfReuturn) {
        System.out.printf(OutputMessage.RATE_OF_RETURN_INFO.getMessage(), rateOfReuturn);
    }
}
