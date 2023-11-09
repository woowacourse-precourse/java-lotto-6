package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private InputView() {
    }

    public static int enterLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine()
                .trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자이어야 합니다.");
        }
    }

    public static List<Integer> enterWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine()
                .trim();
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자이어야 합니다.");
        }
    }

    public static int enterBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine()
                .trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자이어야 합니다.");
        }
    }
}
