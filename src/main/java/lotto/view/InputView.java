package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;

import static lotto.enums.ErrorMessage.*;

public class InputView {

    private static final String NUMBER_DELIMITER = ",";
    private InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public int readPurchaseAccount() {
        while (true) {
            try {
                int purchaseAccount = Integer.parseInt(readLine().trim());
                AccountValidator(purchaseAccount);
                return purchaseAccount;
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_ERROR.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        String numbers = readLine();
        List<Integer> winningNumbers = Arrays.stream(numbers.split(NUMBER_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        //TODO 검증 + input의 책임에 대해 다시 한번 생각해보기.
        return winningNumbers;
    }

    public int readBonusNumber() {
        int bonusNumber = Integer.parseInt(readLine());
        //TODO 검증
        return bonusNumber;
    }

    public void AccountValidator(int purchaseAccount) {
        inputValidator.validateNegativeNum(purchaseAccount);
        inputValidator.validateLessAccount(purchaseAccount);
        inputValidator.validatePurchaseAccountUnit(purchaseAccount);
    }
}
