package lotto.view;

import java.util.Arrays;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.PrizeResult;

public class OutputView {
    public static final String PURCHASE_MSG = "개를 구매했습니다.";
    private static final String OUTPUT_TOP_MESSAGE = "\n" + "당첨 통계" + "\n" + "---";
    private static final String OUTPUT_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";


    public void printLottoTicketCount(int TicketCount) {
        System.out.println("\n" + TicketCount + PURCHASE_MSG);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());

    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }


    public void printStatistics(PrizeResult prizeResult) {
        System.out.println(OUTPUT_TOP_MESSAGE);
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.EMPTY))
                .forEach(prize -> System.out.println(getPrintResultPrize(prize, prizeResult)));

    }

    private String getPrintResultPrize(Prize prize, PrizeResult prizeResult) {
        if (prize == Prize.SECOND) {
            return String.format(OUTPUT_SECOND_RESULT_MESSAGE
                    , prize.getMatchLottoNumber()
                    , String.format("%,d", prize.getMoney())
                    , prizeResult.getPrizeCount(prize));
        }

        return String.format(OUTPUT_RESULT_MESSAGE
                , prize.getMatchLottoNumber()
                , String.format("%,d", prize.getMoney())
                , prizeResult.getPrizeCount(prize));
    }
}
