package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Message;
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

        // 1. 숫자 개수 검증
        if (givenNumberStrings.size() != 6) {
            throw new IllegalArgumentException(Message.EXCPTION_NOT_A_SIX);
        }

        // 2. 숫자 형식 검증
        List<Integer> checkedNumbers = new ArrayList<>();
        for (String number : givenNumberStrings) {
            try {
                int num = Integer.parseInt(number);
                checkedNumbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Message.EXCPTION_NOT_A_NUM);
            }
        }

        // 3. 숫자 중복 여부 검증
        Set<Integer> uniqueNumbers = new HashSet<>(checkedNumbers);
        if (uniqueNumbers.size() != checkedNumbers.size()) {
            throw new IllegalArgumentException(Message.EXCPTION_DUPLICATED);
        }

        return checkedNumbers;
    }
}