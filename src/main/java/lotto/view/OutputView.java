package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String COUNT_LOTTO = "개를 구매했습니다.";
    private final String INPUT_LOTTO_NUMBERS = "\n" + "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = """

            보너스 번호를 입력해 주세요.""";
    private final String TOTAL = "\n당첨 통계\n" + "---";
    private final String ORIGINAL_RESULT = "%d개 일치 (%,d원) - %d개";
    private final String BONUS_RESULT = "%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private final String RATE = "총 수익률은 %,.1f%%입니다.";

    public void inputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void count(int lotto) {
        System.out.println("\n" + lotto + COUNT_LOTTO);
    }

    public void printTotalLotto(List<Lotto> totalLotto) {
        for (int lotto = 0; lotto < totalLotto.size(); lotto++) {
            System.out.println(totalLotto.get(lotto).toString());
        }
    }

    public void winningNumbers() {
        System.out.println(INPUT_LOTTO_NUMBERS);
    }

    public void startResult() {
        System.out.println(TOTAL);
    }

    public void printResult(int prize, int matchingNumbers, int third) {
        String result = String.format(ORIGINAL_RESULT, matchingNumbers, prize, third);
        System.out.println(result);
    }

    public void printRate(double rate) {
        String rateResult = String.format(RATE, rate);
        System.out.println(rateResult);
    }

    public void printBonus(int matchingNumbers, int third) {
        String result = String.format(BONUS_RESULT, matchingNumbers, third);
        System.out.println(result);
    }
}
