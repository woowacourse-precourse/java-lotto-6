package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.EmptyInputException;
import lotto.exception.NotDividedThousandException;
import lotto.exception.NotNumberException;
import lotto.validator.InputValidator;

public class InputView {
    private final String INPUT_MONEY_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";
    private final String INPUT_WINNING_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public String inputMoneyAmount() {
        while (true) {
            try {
                System.out.println(INPUT_MONEY_AMOUNT_MESSAGE);
                String money = Console.readLine();
                validateUserInputMoney(money);
                return money;
            } catch (EmptyInputException e) {
                System.out.println(e.getMessage());
            } catch (NotNumberException e) {
                System.out.println(e.getMessage());
            } catch (NotDividedThousandException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputWinningLottoNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_LOTTO_NUMBER_MESSAGE);
                String winningLottoNumbers = Console.readLine();
                InputValidator.validateInputIsEmpty(winningLottoNumbers);
                return winningLottoNumbers;
            } catch (EmptyInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateUserInputMoney(String money) {
        InputValidator.validateInputIsEmpty(money);
        InputValidator.validateInputIsNumber(money);
        InputValidator.validateInputNumberIsNotDividedThousand(money);
    }
}
