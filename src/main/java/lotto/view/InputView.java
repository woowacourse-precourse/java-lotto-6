package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final String INPUT_MONEY_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";
    private final String INPUT_WINNING_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_LOTTO_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputMoneyAmount() {
        System.out.println(INPUT_MONEY_AMOUNT_MESSAGE);
        String userInputMoney = Console.readLine();
        validateUserInputMoney(userInputMoney);
        return userInputMoney;
    }

    private void validateUserInputMoney(String money) {
        InputValidator.validateInputIsEmpty(money);
        InputValidator.validateInputIsNumber(money);
    }

    public String inputWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER_MESSAGE);
        String winningLottoNumbers = Console.readLine();
        InputValidator.validateInputIsEmpty(winningLottoNumbers);
        return winningLottoNumbers;
    }

    public String inputBonusNumber(List<Integer> winningLotto) {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_LOTTO_NUMBER_MESSAGE);
                String bonusLottoNumber = Console.readLine();
                validateUserInputBonusLottoNumber(bonusLottoNumber, winningLotto);
                return bonusLottoNumber;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateUserInputBonusLottoNumber(String bonusLottoNumber, List<Integer> winningLotto) {
        InputValidator.validateInputIsEmpty(bonusLottoNumber);
        InputValidator.validateInputIsNumber(bonusLottoNumber);
        InputValidator.validateLottoNumberIsNotInRightRange(bonusLottoNumber);
        InputValidator.validateIsWinningLottoNumberContains(bonusLottoNumber, winningLotto);
    }
}
