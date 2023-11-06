package lotto;

import static lotto.Utils.getSortedList;

import java.util.List;
import lotto.Constants.OutputConstants;

public class OutputView {

    private OutputView() {

    }

    public static void printBuyTickets(int tickets) {
        String resultString = String.format(OutputConstants.TOTAL_LOTTO_TICKETS.getMessage(), tickets);
        System.out.println(resultString);
    }

    public static void printLottoNumbers(Cpu cpuLottos, int tickets) {
        List<Lotto> LottoNumbers = cpuLottos.getSixLottoNumbers();

        for (int index = 0; index < tickets; index++) {
            System.out.println(getSortedList(LottoNumbers
                    .get(index)
                    .getNumbers()));
        }
    }

    public static void printResultMessage() {
        System.out.println(OutputConstants.LOTTO_RESULT.getMessage());
    }

    public static void printContourLine() {
        System.out.println(OutputConstants.CONTOUR.getMessage());
    }

    public static void printLottoResult(List<Integer> lottoResult) {
        OutputConstants[] stringArray = OutputConstants.values();
        for (int index = 0; index < lottoResult.size(); index++) {
            OutputConstants outputConstants = stringArray[index];
            String resultString = String.format(outputConstants.getMessage(), lottoResult.get(index));
            System.out.println(resultString);
        }
    }

    public static void printTotalProfit(String profit) {
        String resultString = String.format(OutputConstants.TOTAL_LOTTO_PROFIT.getMessage(), profit);
        System.out.println(resultString);
    }
}