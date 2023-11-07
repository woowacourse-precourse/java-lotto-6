package lotto.views;

import lotto.constants.StringConstants;
import lotto.domain.LottoWinning;
import lotto.io.Input;

public class LottoWinningInputView implements View<LottoWinning> {
    @Override
    public LottoWinning render() {
        System.out.println(StringConstants.INPUT_WINNING_MESSAGE);
        var winnings = Input.readLineAsIntegerList(",");

        System.out.println(StringConstants.INPUT_BONUS_MESSAGE);
        var bonus = Input.readLineAsInt();

        return new LottoWinning(winnings, bonus);
    }
}
