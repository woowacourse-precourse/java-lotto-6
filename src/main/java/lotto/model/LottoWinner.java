package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.util.Message;
import lotto.util.ValidationCheck;
import lotto.view.InputView;

public class LottoWinner {
    private Lotto winningNumber;
    private Integer bonusNumber;

    private Map<ScoreBoard, Integer> scoreResult;

    public void createWinnerLotto() {
        this.winningNumber = inputWinningNumber();
        this.bonusNumber = inputBonusNumber();
    }

    public Lotto inputWinningNumber() {
        String inputNumbers = InputView.showInputLottoNumberMessage();
        List<Integer> validatedCompleteNumbers = winningNumbersValidate(inputNumbers);
        return new Lotto(validatedCompleteNumbers);
    }

    public Integer inputBonusNumber() {
        String inputNumber = InputView.showInputBonusNumberMessage();

        ValidationCheck validationCheck = new ValidationCheck();
        // 1. 숫자 형식 여부 확인
        int bonusNumber = validationCheck.checkNumericValidate(inputNumber);

        // 2. 범위 확인
        validationCheck.checkNumRange(bonusNumber);

        // 3. 당첨 번호와 중복 여부 확인
        if (this.winningNumber.existNumber(bonusNumber)) {
            throw new IllegalArgumentException(Message.EXCPTION_ALREADY_EXIST);
        }
        return bonusNumber;
    }

    private List<Integer> winningNumbersValidate(String givenNumbers) {
        List<String> givenNumberStrings = Arrays.asList(givenNumbers.replaceAll(" ", "").split(","));

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

    public void matchWinnerLotto(Set<Lotto> lottos) {
        for (Lotto userLotto : lottos) {
            ScoreBoard result = userLotto.matchNumbers(this.winningNumber, this.bonusNumber);
            scoreResult.put(result, scoreResult.getOrDefault(result, 0) + 1);
        }
    }
}
