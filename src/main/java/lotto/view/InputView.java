package lotto.view;


import static lotto.validator.MoneyValidator.validateMoneyFormat;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";
    private static final String DELIMITER = ",";

    public int getMoney() {
        int money;

        while (true) {
            try {
                String input = getInputMoneyMessage();

                validateMoneyFormat(input);

                System.out.println();
                money = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public List<Integer> getWinningLottoNumber() {
        String winningLottoNumber = getInputWinningNumber();
        System.out.println();
        return parseWinningLottoNumber(winningLottoNumber);
    }

    public int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        System.out.println();
        return Integer.parseInt(bonusNumber);
    }

    private String getInputMoneyMessage() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }

    private String getInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    private List<Integer> parseWinningLottoNumber(String input) {
        String[] numbers = splitNumbers(input);
        return saveLotto(numbers);
    }

    private List<Integer> saveLotto(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] splitNumbers(String input) {
        return input.split(DELIMITER);
    }
}
