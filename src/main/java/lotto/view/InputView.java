package lotto.view;

import static lotto.constants.Phrase.INPUT_LOTTO_BONUS;
import static lotto.constants.Phrase.INPUT_LOTTO_MONEY;
import static lotto.constants.Phrase.INPUT_LOTTO_PRIZE;

import java.util.List;
import lotto.utils.Reader;

public class InputView {
    public static int getLottoMoney() {
        System.out.println(INPUT_LOTTO_MONEY.getPhrase());
        return Reader.parseNumberInteger();
    }

    public static List<Integer> getLottoPrize() {
        System.out.println(INPUT_LOTTO_PRIZE.getPhrase());
        return Reader.parseNumbersInteger();
    }

    public static int getLottoBonus() {
        System.out.println(INPUT_LOTTO_BONUS.getPhrase());
        return Reader.parseNumberInteger();
    }
}
