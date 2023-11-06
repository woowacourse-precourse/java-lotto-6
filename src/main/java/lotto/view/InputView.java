package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Player;

import java.util.Arrays;

public class InputView {
    public static final String SPLIT_DELIMETER = ",";
    public static final String REGEX = "[0-9]+";

    public static int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateCash(input);
        int cash = Integer.parseInt(input);
        return cash;
    }

    public static Lotto inputWinningLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splitedInput = input.split(SPLIT_DELIMETER);
        Lotto lotto = new Lotto(Arrays.stream(splitedInput).map(Integer::valueOf).toList());
        return lotto;
    }

    public static Bonus inputBonus(Lotto winningLotto) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        Bonus bonus = new Bonus(Integer.parseInt(input), winningLotto);

        return bonus;
    }

    private static void validateCash(String input) {
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
