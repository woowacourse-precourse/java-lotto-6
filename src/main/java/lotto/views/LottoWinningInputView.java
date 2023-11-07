package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.StringConstants;
import lotto.domain.LottoWinning;
import lotto.utils.StringUtils;

public class LottoWinningInputView implements View<LottoWinning> {
    @Override
    public LottoWinning render() {
        System.out.println(StringConstants.INPUT_WINNING_MESSAGE);
        var rawWinnings = Console.readLine();
        var winnings = StringUtils.parseIntList(rawWinnings, ",");

        return new LottoWinning(winnings);
    }
}
