package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Inputter {

    private static final int MONEY_UNIT = 1000;
    private static Inputter inputter;

    private Inputter() {}

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }

    public int purchase() {
        int won;

        System.out.println("구입금액을 입력해 주세요.");
        won = parseInt(Console.readLine());
        validatePurchase(won);
        return won;
    }

    public List<Integer> lottoNumbers() {
        return Arrays.stream(Console.readLine().split(","))
                .mapToInt(this::parseInt).boxed().collect(Collectors.toList());
    }

    private void validatePurchase(int won) {
        if (won % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] "+ MONEY_UNIT + "원 단위로 입력해주세요.");
        }
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요.");
        }
    }
}
