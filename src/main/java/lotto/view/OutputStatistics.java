package lotto.view;

import lotto.common.SystemMessage;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.Rate;

import java.util.Arrays;

public class OutputStatistics {

    public static void printStatistics(PrizeResult prizeResult, Rate rate){
        System.out.println(SystemMessage.OUTPUT_WIN_MESSAGE.getMessage());
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.NOTHING))
                .forEach(prize -> System.out.println(getPrintResultPrize(prize, prizeResult)));
        System.out.printf(SystemMessage.OUTPUT_RATE_OF_RETURN.getMessage()+"\n", rate.getRate());
    }

    private static String getPrintResultPrize(Prize prize, PrizeResult prizeResult){
        if(prize == Prize.SECOND){
            return String.format(SystemMessage.OUTPUT_SECOND_RESULT_MESSAGE.getMessage(),
                    prize.getMatchLottoNumber(),
                    String.format("%,d", prize.getMoney()),
                    prizeResult.getPrizeCount(prize));
        }

        return String.format(SystemMessage.OUTPUT_RESULT_MESSAGE.getMessage(),
                prize.getMatchLottoNumber(),
                String.format("%,d", prize.getMoney()),
                prizeResult.getPrizeCount(prize));
    }

}
