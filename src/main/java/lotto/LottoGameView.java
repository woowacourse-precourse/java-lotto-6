package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoGameView {

    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_GUIDE);
        String input = Console.readLine();
        validatePurchaseAmount(input);
        return Integer.parseInt(input) / 1000;
    }

    private void validatePurchaseAmount(String input) {
        String trimmed = input.trim();
        InputValidator.validateBlank(trimmed);
        InputValidator.validateNumbers(trimmed);
        InputValidator.validateIsMultipleOf1000(trimmed);
    }

    public void printLotteryAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.", amount);
        System.out.println();
    }

    public void printLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
}
