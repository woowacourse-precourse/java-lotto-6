package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

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
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningLottoNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_LOTTO_NUMBER_MESSAGE);
                String winningLottoNumbers = Console.readLine();
                InputValidator.validateInputIsEmpty(winningLottoNumbers);
                return splitWinningLottoNumbers(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateUserInputMoney(String money) {
        InputValidator.validateInputIsEmpty(money);
        InputValidator.validateInputIsNumber(money);
        InputValidator.validateInputNumberIsNotDividedThousand(money);
    }

    private List<Integer> splitWinningLottoNumbers(String winningLottoNumbers) {
        List<Integer> inputWinningLottoNumbers = new ArrayList<>();
        for (String winningLottoNumber : winningLottoNumbers.split(",")) {
            validateWinningLottoNumber(winningLottoNumber);
            inputWinningLottoNumbers.add(Integer.parseInt(winningLottoNumber));
        }
        InputValidator.validateAmountOfWinningLottoNumber(inputWinningLottoNumbers);
        InputValidator.validateDuplicatedWinningLottoNumber(inputWinningLottoNumbers);
        return inputWinningLottoNumbers;
    }

    private static void validateWinningLottoNumber(String winningLottoNumber) {
        InputValidator.validateInputIsNumber(winningLottoNumber);
        InputValidator.validateLottoNumberIsNotInRightRange(winningLottoNumber);
    }
}
