package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.utilObject.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String GET_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String GET_WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String DELIMITER = ",";

    public Integer readMoney() {
        System.out.println(GET_PURCHASE_MONEY);
        String input = getInput();

        Number number = new Number(input);
        return number.getNumericValue();
    }

    public List<Integer> readWinLottoNumbers() {
        System.out.println(GET_WIN_NUMBERS);
        String input = getInput();
        List<String> stringNumbers = split(input);

        List<Integer> numbers = new ArrayList<>();

        for (String stringNumber : stringNumbers) {
            String trimmedNumber = trimInputValue(stringNumber);
            Number numericValue = new Number(trimmedNumber);

            numbers.add(numericValue.getNumericValue());
        }

        return numbers;
    }

    public Integer readWinLottoBonusNumber() {
        System.out.println(GET_BONUS_NUMBER);
        String input = getInput();

        Number number = new Number(input);
        return number.getNumericValue();
    }

    private String trimInputValue(String inputValue) {
        return inputValue.trim();
    }

    private List<String> split(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }

    private String getInput() {
        return Console.readLine();
    }

}
