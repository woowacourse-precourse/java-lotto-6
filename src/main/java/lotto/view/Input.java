package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static String inputValue() {
        return Console.readLine();
    }

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purChaseAmount = inputValue();

        return Integer.parseInt(purChaseAmount);
    }

    public static List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = inputValue();
        System.out.println();

        return Stream.of(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = inputValue();
        System.out.println();

        return Integer.parseInt(bonusNumber);
    }
}
