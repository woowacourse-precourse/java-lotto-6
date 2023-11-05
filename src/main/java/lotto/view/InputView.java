package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_NUMBER_ERROR_MESSAGE = "구매 금액에 숫자를 입력해야 합니다.";
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호에 숫자를 입력해야 합니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 번호에 숫자를 입력해야 합니다.";
    private static final String DELIMITER_WRONG_MESSAGE = "로또 번호 구분자로 콤마(,) 를 사용해 주세요";
    private static final String DELIMITER_FOR_LOTTO_NUMBER = ",";

    public int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
        String input = Console.readLine();
        return convertInputWithNumberValidation(input, PURCHASE_NUMBER_ERROR_MESSAGE);
    }

    private static int convertInputWithNumberValidation(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public List<Integer> inputWinLottoNumber() {
        System.out.println(INPUT_WIN_LOTTO_NUMBER_MESSAGE);
        String input = Console.readLine();
        try {
            checkLottoNumberDelimiter(input);
            String[] split = input.split(DELIMITER_FOR_LOTTO_NUMBER);
            return Arrays.stream(split)
                    .map(this::removeSpace)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    private String removeSpace(String number) {
        return number.replaceAll(" ", "");
    }

    private void checkLottoNumberDelimiter(String input) {
        if (input.contains(DELIMITER_FOR_LOTTO_NUMBER)) {
            return;
        }
        throw new IllegalArgumentException(DELIMITER_WRONG_MESSAGE);
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_WIN_LOTTO_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        return convertInputWithNumberValidation(input, BONUS_NUMBER_ERROR_MESSAGE);
    }
}
