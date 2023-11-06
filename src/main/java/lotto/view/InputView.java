package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public BigInteger inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return getBigInteger(input);
    }

    private BigInteger getBigInteger(String input) {
        try {
            return new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(this::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseInt(input);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
