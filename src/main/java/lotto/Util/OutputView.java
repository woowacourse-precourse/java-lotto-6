package lotto.Util;

import lotto.Domain.LottoTickets;
import lotto.Domain.Prize;
import lotto.Function.PrizeLottoCompare;
import lotto.Function.Rate;

import java.util.Arrays;

public class OutputView {
    private static final String NEWLINE = "---";
    private static final String OUTPUT_TOP_MESSAGE = "당첨 통계";
    private static final String OUTPUT_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    //생성된 로또 번호 출력
    public static void printLottoTickets(LottoTickets lottoTickets){
        lottoTickets.getLottoTickets().forEach(System.out::println);
        System.out.println();
    }
    //결과 값 출력
    public static void printLotto_Result(PrizeLottoCompare prizeLottoCompare, Rate rate) {
        System.out.println(OUTPUT_TOP_MESSAGE+ "\n"+ NEWLINE);
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.NOTHING))
                .forEach(prize -> System.out.println(getPrintResult(prize, prizeLottoCompare)));
        System.out.printf((OUTPUT_RATE_OF_RETURN) + "\n", rate.getRate());
    }

    private static String getPrintResult(Prize prize, PrizeLottoCompare prizeLottoCompare) {
        if (prize == Prize.SECOND) {
            return String.format(OUTPUT_SECOND_RESULT_MESSAGE
                    , prize.getMatchLotto()
                    , String.format("%,d", prize.getMoney())
                    , prizeLottoCompare.getPrizeCount(prize));
        }

        return String.format(OUTPUT_RESULT_MESSAGE
                , prize.getMatchLotto()
                , String.format("%,d", prize.getMoney())
                , prizeLottoCompare.getPrizeCount(prize));
    }

}
