package ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Input {
    private static final String priceMessage = "구입 금액을 입력해주세요";
    private static final String winningNumbersMessage = "당첨 번호를 입력해 주세요.";
    private static final String bonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public int getPrice() {
        System.out.println(priceMessage);
        return Integer.parseInt(Console.readLine());
    }

    public int[] getWinningNumbers() {
        System.out.println(winningNumbersMessage);
        return Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int getBonusNumber() {
        System.out.println(bonusNumberMessage);
        return Integer.parseInt(Console.readLine());
    }
}
