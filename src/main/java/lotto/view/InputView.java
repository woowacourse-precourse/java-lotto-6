package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Player;

import java.util.Arrays;

public class InputView {
    public static final String SPLIT_DELIMETER = ",";

    public static Player inputCash() {
        int cash = Integer.parseInt(Console.readLine());
        Player player = new Player(cash);
        return player;
    }

    public static Lotto inputLotto() {
        String input = Console.readLine();
        String[] splitedInput = input.split(SPLIT_DELIMETER);
        Lotto lotto = new Lotto(Arrays.stream(splitedInput).map(Integer::valueOf).toList());
        return lotto;
    }

    public static Bonus inputBonus() {
        String input = Console.readLine();
        Bonus bonus = new Bonus(Integer.parseInt(input));

        return bonus;
    }
}
