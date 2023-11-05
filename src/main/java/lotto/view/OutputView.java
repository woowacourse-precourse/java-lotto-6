package lotto.view;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String ASK_FOR_MONEY = "구입금액을 입력해 주세요.";
    private static final String ASK_FOR_WINNING_NUMBERS = NEW_LINE + "당첨 번호를 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT = NEW_LINE + "%d개를 구매했습니다.";
    private static final String ASK_FOR_BONUS_NUMBER = NEW_LINE + "보너스 번호를 입력해 주세요.";

    public void askForMoney() {
        System.out.println(ASK_FOR_MONEY);
    }

    public void printLottoCount(int lottoCount) {
        System.out.printf((PURCHASED_LOTTO_COUNT) + "%n", lottoCount);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            printCommaBetweenNumbers(numbers, i);
        }
        System.out.println("]");
    }

    private void printCommaBetweenNumbers(List<Integer> numbers, int i) {
        if (i != numbers.size() - 1) {
            System.out.print(", ");
        }
    }

    public void askForWinningNumbers() {
        System.out.println(ASK_FOR_WINNING_NUMBERS);
    }

    public void askForBonusNumber() {
        System.out.println(ASK_FOR_BONUS_NUMBER);
    }

    public void printWinningStatistics() {
        System.out.println(NEW_LINE + "당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - 1개");
        System.out.println("4개 일치 (50,000원) - 0개");
        System.out.println("5개 일치 (1,500,000원) - 0개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        System.out.println("6개 일치 (2,000,000,000원) - 0개");
        System.out.println("총 수익률은 62.5%입니다.");
    }
}
