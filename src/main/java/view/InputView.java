package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputView() {
    }

    public static String money() {
        System.out.println("구입금액을 입력해 주세요.");
        String lottoMoney = Console.readLine();
        return lottoMoney.trim();
    }

    public static Lotto winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInputNumbers = Console.readLine().replace(" ", "");

        List<Integer> winningNumbers = Arrays.stream(userInputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println();
        return new Lotto(winningNumbers);
    }

    public static String bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
