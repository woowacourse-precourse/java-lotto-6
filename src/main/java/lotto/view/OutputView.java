package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningGrade;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printInputMoneyToBuyLottoMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printBoughtLottoCount(int numberOfLottoBought) {
        printNewLine();
        System.out.printf(String.format("%d개를 구매했습니다.", numberOfLottoBought));
    }

    public void printLottos(List<Lotto> lottos) {
        printNewLine();
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printInputWinningNumbersMessage() {
        printNewLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumberMessage() {
        printNewLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printWinningResultMessage() {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printWinningResult(Map<WinningGrade, Integer> winningResult) {
        winningResult.entrySet().stream()
                .filter(result -> result.getKey() != WinningGrade.DEFAULT)
                .forEach(result -> System.out.println(result.getKey().toString() + result.getValue() + "개"));
    }
