package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] number = Console.readLine().split(",");
        return Arrays.stream(number)
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
