package lotto.view;

import java.util.Collection;
import java.util.List;
import lotto.Rank;
import lotto.service.ConsoleOutDTO;

public class OutputView {
    public void printNumberOfLotto(int numberOfLottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<List<Integer>> lottos) {
        lottos.forEach(x -> {
                    System.out.println("[" + String.join(",", x.toString()) + "]");
                });
    }

    public void printStatistic(List<Integer> fifthToFirst) {
        // Enum을 활용한 반복으로 출력하기
    }

    public void printProfitRate(double profitRate) {
        String profitRateToPrint = String.format("%.2f", profitRate);
        System.out.println("총 수익률은 " + profitRateToPrint + "입니다.");
    }

    public void printResult(ConsoleOutDTO consoleOutDTO) {
        printNumberOfLotto(consoleOutDTO.getTotalBought());
        printLottoNumbers(consoleOutDTO.getLottos());
        printStatistic(consoleOutDTO.getResult());
        printProfitRate(consoleOutDTO.getProfitRate());
    }
}
