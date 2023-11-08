package lotto.View;

import static lotto.Utils.Utils.getSortedList;

import java.util.List;
import lotto.Constants.OutputConstants;
import lotto.Model.Cpu;
import lotto.Model.Lotto;

public class OutputView {

    public void printBuyTickets(int tickets) {
        String resultString = String.format(OutputConstants.TOTAL_LOTTO_TICKETS.getMessage(), tickets);
        System.out.println(resultString);
    }

    public void printLottoNumbers(Cpu cpuLottos, int tickets) {
        List<Lotto> LottoNumbers = cpuLottos.getSixLottoNumbers();

        for (int index = 0; index < tickets; index++) {
            System.out.println(getSortedList(LottoNumbers
                    .get(index)
                    .getNumbers()));
        }
    }

    public void printResultMessage() {
        System.out.println(OutputConstants.LOTTO_RESULT.getMessage());
    }

    public void printContourLine() {
        System.out.println(OutputConstants.CONTOUR.getMessage());
    }

    public void printLottoResult(List<Integer> lottoResult) {
        OutputConstants[] stringArray = OutputConstants.values();
        for (int index = 0; index < lottoResult.size(); index++) {
            OutputConstants outputConstants = stringArray[index];
            String resultString = String.format(outputConstants.getMessage(), lottoResult.get(index));
            System.out.println(resultString);
        }
    }

    public void printTotalProfit(String profit) {
        String resultString = String.format(OutputConstants.TOTAL_LOTTO_PROFIT.getMessage(), profit);
        System.out.println(resultString);
    }
}