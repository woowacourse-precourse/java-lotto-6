package lotto.controller;

import lotto.LottoUtil;
import lotto.constant.LottoRank;
import lotto.domain.dto.LottoAnswer;
import lotto.domain.dto.LottoNumbers;

public class LottoController {
    public static LottoRank calculateLottoRank(
            LottoAnswer answerLotto,
            LottoNumbers checkLotto
    ) {
        int matchCount = LottoUtil.getMatchingNumberCount(answerLotto.numbers(), checkLotto.numbers());
        boolean hasBonus = checkLotto.numbers().contains(answerLotto.bonus());

        return LottoRank.getLottoMatchByCount(matchCount, hasBonus);
    }
}
