package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.error.InvalidPurchaseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String LOTTO_NUMS_DELIMITER = ",";

    public Money readPurchaceMoney() {
        try {
            System.out.println(LottoMessage.PURCHASE_MONEY_INPUT);
            final String input = Console.readLine();
            Integer inputNum = Integer.parseInt(input);
            return new Money(inputNum);
        } catch (Exception e) {
            System.out.println(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해주세요.");
        }
    }

    public List<Integer> readWinLottoNumbers() {
        System.out.println(LottoMessage.WIN_LOTTO_NUMBERS_INPUT);
        String input = getInput();
        List<String> stringNumbers = split(input);

        List<Integer> numbers = new ArrayList<>();

        for (String stringNumber : stringNumbers) {
            String trimmedNumber = trimInputValue(stringNumber);
            Integer lottoNumber = Integer.parseInt(trimmedNumber);

            numbers.add(lottoNumber);
        }

        return numbers;
    }

    public Integer readWinLottoBonusNumber() {
        System.out.println(LottoMessage.BONUS_NUMBER_INPUT);
        String input = getInput();

        Integer bonusNumber = Integer.parseInt(input);
        return bonusNumber;
    }

    private String getInput() {
        String input = Console.readLine();
        return input;
    }

    private List<String> split(String input) {
        return Arrays.stream(input.split(LOTTO_NUMS_DELIMITER)).toList();
    }

    private String trimInputValue(String inputValue) {
        return inputValue.trim();
    }
}
