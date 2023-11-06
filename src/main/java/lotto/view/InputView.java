package lotto.view;


import static lotto.validator.MoneyValidator.validateMoneyFormat;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE = "구입금액을 입력해 주세요";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";
    private static final String SPLIT_CONDITION = ",";

    public int purchaseAmount() {
        int purchaseAmount;

        while (true) {
            try {
                System.out.println(INPUT_PURCHASE);
                String input = Console.readLine();

                validateMoneyFormat(input);

                System.out.println();
                purchaseAmount = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    public List<Integer> getWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        String lottoNumbers = Console.readLine();
        System.out.println();
        String[] numbers = splitNumbers(lottoNumbers);
        return saveLotto(numbers);
    }

    public int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        System.out.println();
        return Integer.parseInt(bonusNumber);
    }

    private List<Integer> saveLotto(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] splitNumbers(String input) {
        return input.split(SPLIT_CONDITION);
    }
}
