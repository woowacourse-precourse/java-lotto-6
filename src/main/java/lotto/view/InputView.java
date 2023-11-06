package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidNumberFormatException;
import lotto.validation.ValidateBonusLottoNumberFormat;
import lotto.validation.ValidateLottoNumberFormat;
import lotto.validation.ValidateNumberFormat;
import lotto.validation.ValidateThousandWonFormat;

import java.util.List;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_WINNING_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void readInputMoneyMessage() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public void readInputWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void readInputBonusWinningNumberMessage() {
        System.out.println(INPUT_BONUS_WINNING_NUMBER_MESSAGE);
    }

    public int inputMoney() {
        String inputMoney;
        while (true) {
            inputMoney = Console.readLine();
            try {
                validateInputMoney(inputMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(inputMoney);
    }

    private void validateInputMoney(String inputMoney) {
        ValidateNumberFormat.validate(inputMoney);
        ValidateThousandWonFormat.validate(inputMoney);
    }

    public String[] inputWinningNumber() {
        String inputWinnigNumber;
        while (true) {
            inputWinnigNumber = Console.readLine();
            try {
                validateInputWinningNumber(inputWinnigNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inputWinnigNumber.split(",");
    }

    private void validateInputWinningNumber(String inputWinningNumber) {
        ValidateLottoNumberFormat.validate(inputWinningNumber);
    }

    public String inputBonusWinningNumber(String[] existingNumbers) {
        String inputBonusWinningNumber;
        while (true) {
            inputBonusWinningNumber = Console.readLine();
            try {
                validateInputBonusWinningNumber(inputBonusWinningNumber,existingNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inputBonusWinningNumber;
    }

    private void validateInputBonusWinningNumber(String inputBonusWinningNumber, String[] existingNumbers) {
        ValidateBonusLottoNumberFormat.validate(inputBonusWinningNumber, existingNumbers);
    }
}
