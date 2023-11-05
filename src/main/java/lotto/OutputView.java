package lotto;

import java.util.List;

public class OutputView {

    public static void printBuyTickets(int tickets) {
        System.out.println(tickets + OutputConstants.TOTAL_LOTTO_TICKETS.getMessage());
    }

    public static void printLottoNumbers(Cpu cpuLottos, int tickets) {
        List<Lotto> LottoNumbers = cpuLottos.getSixLottoNumbers();

        for (int index = 0; index < tickets; index++) {
            System.out.println(LottoNumbers
                    .get(index)
                    .getNumbers());
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
            System.out.println(outputConstants.getMessage() + lottoResult.get(index) + "개");
        }
    }

    public static void printTotalProfit(String profit) {
        String resultString = String.format(OutputConstants.TOTAL_LOTTO_PROFIT.getMessage(), profit);
        System.out.println(resultString);
    }
}
