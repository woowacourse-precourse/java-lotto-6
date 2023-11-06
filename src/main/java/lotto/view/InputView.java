package lotto.view;

import static lotto.constants.Phrase.INPUT_LOTTO_BONUS;
import static lotto.constants.Phrase.INPUT_LOTTO_MONEY;
import static lotto.constants.Phrase.INPUT_LOTTO_WINNING;

import java.util.List;
import lotto.utils.Reader;

public class InputView {
    public static int getPlayerLottoMoney() {
        System.out.println(INPUT_LOTTO_MONEY.getPhrase());
        return Reader.parseNumberInteger();
    }

    public static List<Integer> getLottoWinnning() {
        System.out.println(INPUT_LOTTO_WINNING.getPhrase());
        return Reader.parseNumbersInteger();
    }

    public static int getLottoBonus() {
        System.out.println(INPUT_LOTTO_BONUS.getPhrase());
        return Reader.parseNumberInteger();
    }
}
