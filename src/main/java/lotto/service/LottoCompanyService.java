package lotto.service;

import static lotto.constants.LottoRule.LOTTO_NUMBER_LENGTH;
import static lotto.constants.LottoRule.MINIMUM_MATCH_SIZE;

import lotto.model.BonusNumber;
import lotto.model.GoalNumbers;
import lotto.model.Lotto;
import lotto.model.LottoCompany;
import lotto.constants.Prize;
import lotto.model.dto.PrizeResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCompanyService {

    private final LottoCompany lottoCompany;
    private final List<Lotto> lottos;

    private LottoCompanyService(final LottoCompany lottoCompany, final List<Lotto> lottos) {
        this.lottoCompany = lottoCompany;
        this.lottos = lottos;
    }

    public static LottoCompanyService of(final GoalNumbers goalNumbers,
                                         final BonusNumber bonusNumber, final List<Lotto> lottos) {
        LottoCompany lottoCompany = LottoCompany.of(goalNumbers, bonusNumber);
        return new LottoCompanyService(lottoCompany, lottos);
    }

    public List<PrizeResult> evaluateLottos() {
        List<PrizeResult> results = new ArrayList<>();
        for (int match = MINIMUM_MATCH_SIZE.getValue(); match <= LOTTO_NUMBER_LENGTH.getValue(); match++) {
            List<Lotto> matchLottos = lottoCompany.collectLottosWithSizeExceptBonus(lottos, match);
            Prize prize = Prize.findByMatch(match);
            PrizeResult prizeResult = PrizeResult.of(prize.getCondition(), prize.getMoney(), matchLottos.size());
            results.add(prizeResult);
        }

        PrizeResult secondPrizeResult = evaluateLottosWithBonus();
        results.add(secondPrizeResult);

        Collections.sort(results);
        return results;
    }

    private PrizeResult evaluateLottosWithBonus() {
        Prize secondPrize = Prize.SECOND;
        int matchSize = secondPrize.getMatch();
        List<Lotto> secondPrizeLottos = lottoCompany.collectLottosWithSizeIncludeBonus(lottos, matchSize);

        return PrizeResult.of(secondPrize.getCondition(), secondPrize.getMoney(), secondPrizeLottos.size());
    }
}
