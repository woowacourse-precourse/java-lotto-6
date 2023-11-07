package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.StringConstants;
import lotto.domain.LottoBonus;
import lotto.domain.LottoWinning;
import lotto.utils.StringUtils;

public class LottoBonusInputView implements View<LottoBonus> {
    private final LottoWinning winning;

    public LottoBonusInputView(LottoWinning winning) {
        this.winning = winning;
    }

    @Override
    public LottoBonus render() {
        System.out.println(StringConstants.INPUT_BONUS_MESSAGE);
        var rawBonus = Console.readLine();
        var bonus = StringUtils.parseInt(rawBonus);
        return new LottoBonus(this.winning, bonus);
    }
}
