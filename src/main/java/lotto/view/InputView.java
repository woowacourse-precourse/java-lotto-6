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
        try {
            int purchaseAccount = Integer.parseInt(readLine().trim());
            accountValidator(purchaseAccount);
            return purchaseAccount;
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_ERROR.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public List<Integer> readWinningNumbers() {

        try {
            String numbers = readLine().trim();
            inputValidator.validateEmptyValue(numbers);
            List<Integer> winningNumbers = Arrays.stream(numbers.split(NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            numbersValidator(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_ERROR.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return List.of(0);
    }

    public int readBonusNumber() {
        int bonusNumber = Integer.parseInt(readLine());
        //TODO 검증
        return bonusNumber;
    }

    public void accountValidator(int purchaseAccount) throws IllegalArgumentException {
        inputValidator.validateNegativeNum(purchaseAccount);
        inputValidator.validateLessAccount(purchaseAccount);
        inputValidator.validatePurchaseAccountUnit(purchaseAccount);
    }

    /**
     * 사용자에게 중복되지 않는 숫자 6개로 구성된 당첨 번호를 입력받는다. Exception 공백이 들어온 경우 예외처리한다. Exception ,를 제외한 문자가 들어온
     * 경우 예외처리한다. Exception ,으로 입력이 시작하거나 끝나는 경우 예외처리한다. Exception ,,가 두번 연속으로 사용된 경우 예외처리한다.
     * Exception 입력된 숫자 리스트에 중복이 포함된 경우 예외처리한다. Exception 입력된 숫자가 6개가 아니면 예외처리한다. Exception 입력된 숫자가
     * 1부터 45 사이의 값이 아니면 예외처리한다
     */
    public void numbersValidator(List<Integer> numbers) {

    }
}
