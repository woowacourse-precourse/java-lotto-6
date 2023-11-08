package lotto.view;

import static lotto.validator.Validator.validateInteger;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.Validator;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "로또 구입 금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public int getPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return validateInteger(getUserInput());
    }

    public List<Integer> getLottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBERS);
        return Arrays.stream(getUserInput().split(DELIMITER))
                .map(Validator::validateInteger)
                .collect(Collectors.toList());
    }
    public int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return validateInteger(getUserInput());
    }
    private String getUserInput() {
        return Console.readLine();
    }
}
