package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.List;

public class InputView {

    private static final String NOTICE_INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String NOTICE_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";
    private static final String FORMAT_OF_DIGIT = "[0-9]+";
    private static final String ERROR_NOT_DIVIDED_BY_LOTTO_PRICE = "[ERROR] 로또 구입 가격은 로또 하나의 가격인 1000원으로 나누어 떨어져야 합니다.";
    private static final String ERROR_MUST_BE_DIGITS = "[ERROR] 당첨 번호는 숫자이어야 합니다.";

    public void inputPurchasePrice() {
        System.out.println(NOTICE_INPUT_PURCHASE_PRICE);
        String input = Console.readLine();
        int purchasePrice = stringToInt(input);
        try {
            validateDividedByLottoPrice(purchasePrice);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            inputPurchasePrice();
        }
    }

    public void inputWinNumber() {
        System.out.println(NOTICE_INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        List<String> inputNumbers = List.of(input.split(DELIMITER));
        validateInputNumbersType(inputNumbers);
        List<Integer> winningNumbers = stringListToIntList(inputNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);
    }

    private List<Integer> stringListToIntList(List<String> before) {
        return before.stream()
                .map(this::stringToInt)
                .toList();
    }

    private void validateInputNumbersType(List<String> numbers) {
        for (String number : numbers) {
            if (isNotDigits(number)) {
                throw new IllegalArgumentException(ERROR_MUST_BE_DIGITS);
            }
        }
    }

    private boolean isNotDigits(String number) {
        return !number.matches(FORMAT_OF_DIGIT);
    }

    private void validateDividedByLottoPrice(int price) {
        if (isNotDividedByLottoPrice(price)) {
            throw new IllegalArgumentException(ERROR_NOT_DIVIDED_BY_LOTTO_PRICE);
        }
    }

    private boolean isNotDividedByLottoPrice(int price) {
        return price % ONE_LOTTO_PRICE != 0;
    }

    private int stringToInt(String before) {
        return Integer.parseInt(before);
    }
}
