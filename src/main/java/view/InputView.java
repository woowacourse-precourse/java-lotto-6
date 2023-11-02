package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class InputView {
    private InputView() {
    }

    public static int money() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();

        return Integer.parseInt(money);
    }

    public static Lotto winningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInputNumbers = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(userInputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println();
        return new Lotto(winningNumbers);
    }

    public static int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        System.out.println();
        return Integer.parseInt(bonus);
    }
}
