package lotto;

import java.util.HashMap;
import java.util.List;

public class Output {
    private static final String NUMBER_OF_PURCHAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String RESULT_PRIZE_EXCEPT_SECOND = "%d개 일치 (%s원) - %d개\n";
    private static final String RESULT_SECOND_PRIZE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String RESULT_RETURN_RATE = "총 수익률은 .1f%입니다.";

    public void printNumberOfPurchase(int lottoTicket) {
        System.out.println();
        System.out.println(lottoTicket + NUMBER_OF_PURCHAGE);
    }

    public void printRandomLottoNumbers(HashMap<Integer, List<Integer>> randomLottoNumbers) {
        for (int key : randomLottoNumbers.keySet()) {
            System.out.println(randomLottoNumbers.get(key));
        }
    }

    public String printResultMessage() {
        return RESULT_MESSAGE;
    }

    public String printCompareLottoNumberResultExceptSecondPrize() {
        return RESULT_PRIZE_EXCEPT_SECOND;
    }

    public String printCompareLottoNumberResultSecondPrize() {
        return RESULT_SECOND_PRIZE;
    }
}
