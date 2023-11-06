package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해주세요.";
    private static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해주세요.";
    private static final String HASH = ",";

    public long getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
        long purchaseAmount = Long.parseLong(Console.readLine());
        System.out.println();
        return purchaseAmount;
    }

    public String getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT);
        return Console.readLine();
    }

    public int getBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT);
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> splitNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(HASH))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
