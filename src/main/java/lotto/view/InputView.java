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

    public int readPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(readLine().trim());
        accountValidator(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> readWinningNumbers() {
        String numbers = readLine().trim();
        inputValidator.validateEmptyValue(numbers);
        List<Integer> winningNumbers = Arrays.stream(numbers.split(NUMBER_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        return winningNumbers;
    }

    public int readBonusNumber() {
        int bonusNumber = Integer.parseInt(readLine());
        //TODO 검증
        return bonusNumber;
    }

    public void accountValidator(int purchaseAmount) throws IllegalArgumentException {
        //해당 내용을 LottoPurchaseManager로 옮기는게 나으려나...? ㅠㅠ
        inputValidator.validateNegativeNum(purchaseAmount);
        inputValidator.validateLessAccount(purchaseAmount);
        inputValidator.validatePurchaseAmountUnit(purchaseAmount);
    }

}
