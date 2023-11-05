package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.util.Message;
import lotto.util.ValidationCheck;
import lotto.view.InputView;

public class LottoWinner {
    private Lotto winningNumber;
    private Integer bonusNumber;

    public void createWinnerLotto() {
        this.winningNumber = inputWinningNumber();
    }

    public Lotto inputWinningNumber() {
        String inputNumbers = InputView.showInputLottoNumberMessage();
        List<Integer> validatedCompleteNumbers = winningNumbersValidate(inputNumbers);
        return new Lotto(validatedCompleteNumbers);
    }

    private List<Integer> winningNumbersValidate(String givenNumbers) {
        List<String> givenNumberStrings = Arrays.asList(givenNumbers.split(","));

        // 1. 숫자 형식 검증
        List<Integer> checkedNumbers = new ArrayList<>();
        for (String number : givenNumberStrings) {
            try {
                int num = Integer.parseInt(number);
                checkedNumbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Message.EXCPTION_NOT_A_NUM);
            }
        }

        ValidationCheck validationCheck = new ValidationCheck();

        // 2. 숫자 개수 검증
        validationCheck.checkNumLength(checkedNumbers);

        // 3. 숫자 중복 여부 검증
        validationCheck.checkDuplicatedNum(checkedNumbers);

        // 4. 숫자 범위 유효성 검증
        for (int num : checkedNumbers) {
            validationCheck.checkNumRange(num);
        }

        return checkedNumbers;
    }
}
