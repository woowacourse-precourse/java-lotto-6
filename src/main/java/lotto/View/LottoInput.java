package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import System.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import lotto.Model.Util.RaffleUtil;
import lotto.Validate.ValidateInput;

public class LottoInput {

    private final ValidateInput validateInput;
    private final RaffleUtil raffleUtil;

    public LottoInput() {
        this.validateInput = new ValidateInput();
        this.raffleUtil = new RaffleUtil();
    }

    public String inputPurchaseAmount() {
        return inputTillValidate(
                Message.INPUT_PURCHASE_MONEY.getMessage(),
                validateInput::validatePurchaseAmountPattern,
                validateInput::validatePurchaseAmountUnit
        );
    }

    public List<Integer> inputWinningNumber() {
        List<Integer> winningNumberList = new ArrayList<>();
        inputTillValidate(
                Message.LINE_BREAK.getMessage() + Message.INPUT_WINNING_NUMBER.getMessage(),
                validateInput::validateWinningNumbersPattern,
                input -> {
                    winningNumberList.addAll(raffleUtil.parseWinningNumbers(input));
                    validateInput.validateWinningNumbersCheckInRange(winningNumberList);
                    validateInput.validateWinningNumbersHasDuplicate(winningNumberList);
                }
        );
        return winningNumberList;
    }

    public int inputBonusNumber(List<Integer> winningNumberList) {
        String message = Message.LINE_BREAK.getMessage() + Message.INPUT_BONUS_NUMBER.getMessage();

        return Integer.parseInt(
                inputTillValidate(message, validateInput::validateBonusNumberPattern,
                        bonusNumber -> validateInput.validateWinningNumbersIsDuplicateBonusNumber(
                                winningNumberList, bonusNumber)));
    }

    public String inputTillValidate(String message, Consumer<String>... validators) {
        boolean flag = true;
        String input = "";
        System.out.println(message);

        while (flag) {
            input = Console.readLine();
            try {
                validate(input, validators);
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(Message.INPUT_RETRY.getMessage());
            }
        }

        return input;
    }

    public void validate(String input, Consumer<String>... validators) {
        for (Consumer<String> validator : validators) {
            validator.accept(input);
        }
    }

}
