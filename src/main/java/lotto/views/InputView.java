package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.valid.LottoWinningNumberValidator;
import lotto.valid.PurchaseMoneyValidator;

import java.util.List;

public class InputView {

    private static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
        String input = Console.readLine();

        while (!PurchaseMoneyValidator.validate(input)) {
            System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
            input = Console.readLine();
        }

        return Integer.parseInt(input);
    }

    public static List<Integer> inputLottoWinningNumber() {
        while (true) {
            System.out.println(INPUT_LOTTO_WINNING_NUMBER_MESSAGE);
            try {
                return LottoWinningNumberValidator.winningNumberValidator(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            try {
                return LottoWinningNumberValidator.bonusNumberValidator(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
