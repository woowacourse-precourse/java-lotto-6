package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputVIew {
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String LOTTO_NUMBERS_PATTERN = "\\d+,\\d+,\\d+,\\d+,\\d+,\\d+";

    public static long getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Long.parseLong(input);
    }

    public static List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateLottoNumber(input);
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    public static int getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) throws IllegalArgumentException {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void validateLottoNumber(String input) throws IllegalArgumentException {
        if (!input.matches(LOTTO_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 형식과 맞지 않습니다.");
        }
    }
}
