package lotto.controller;

import lotto.LottoUtil;
import lotto.constant.LottoMatch;
import lotto.domain.dto.LottoAnswer;
import lotto.domain.dto.LottoNumbers;

public class LottoController {
    public static LottoMatch calculateLottoMatch(
            LottoAnswer answerLotto,
            LottoNumbers checkLotto
    ) {
        int matchCount = LottoUtil.getMatchingNumberCount(answerLotto.numbers(), checkLotto.numbers());
        boolean containsBonus = checkLotto.numbers().contains(answerLotto.bonus());

        return LottoMatch.getLottoMatchByCount(matchCount, containsBonus);
    }
}
