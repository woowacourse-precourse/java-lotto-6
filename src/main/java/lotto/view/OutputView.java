package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public void printLottoCount(int lottoAmount) {
        System.out.printf("%n%d개를 구매했습니다.%n", lottoAmount);
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printWinningResult(Map<WinningResult, Integer> results) {
        for (WinningResult winningResult : WinningResult.values()) {
            Integer count = results.getOrDefault(winningResult, 0);
            String message = String.format("%s - %d개", winningResult.getMessage(), count);
            System.out.println(message);
        }
    }

}
