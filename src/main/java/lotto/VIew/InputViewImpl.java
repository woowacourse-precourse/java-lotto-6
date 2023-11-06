package lotto.VIew;

import static lotto.Message.InputVIewMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

    private InputViewImpl() {
    }

    public static InputViewImpl of() {
        return new InputViewImpl();
    }

    @Override
    public String inputMoney() {
        System.out.println(INPUT_PURCHASE_PROMPT.getMessage());
        return Console.readLine();
    }

    @Override
    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_PROMPT.getMessage());
        return Console.readLine();
    }

    @Override
    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_PROMPT.getMessage());
        String bonusNumber = Console.readLine();
        Console.close();
        return bonusNumber;
    }
}
