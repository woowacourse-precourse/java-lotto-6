package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.exception.InputException;

public class InputView {

    public static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static InputException inputException = new InputException();

    public int inputAmount() {
        System.out.println(INPUT_AMOUNT);
        String amount = Console.readLine();
        inputException.validateInputNumber(amount);
        inputException.validateUnit(amount);
        return Integer.parseInt(amount);
    }

    public String inputWinningNumber() {
        System.out.println("\n"+INPUT_WINNING_NUMBER);
        String winningNumber = Console.readLine();
        inputException.validateInputWinningNumber(winningNumber);
        return winningNumber;
    }

    public int inputBonusNumber(Lotto winningNumber) {
        System.out.println("\n"+INPUT_BONUS_NUMBER);
        String bonus = Console.readLine();
        inputException.validateInputNumber(bonus);
        inputException.validateBonusRange(bonus);
        inputException.validateDuplicateBonus(bonus,winningNumber);
        return Integer.parseInt(bonus);
    }

}
