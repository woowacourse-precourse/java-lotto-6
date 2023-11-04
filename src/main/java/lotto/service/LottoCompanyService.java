package lotto.service;

import static lotto.model.LottoConstant.FIFTH_PRIZE_MATCH;
import static lotto.model.LottoConstant.FIRST_PRIZE_MATCH;
import static lotto.model.LottoConstant.SECOND_PRIZE_MATCH;

import lotto.model.BonusNumber;
import lotto.model.GoalNumbers;
import lotto.model.Lotto;
import lotto.model.LottoCompany;
import lotto.model.Prize;
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
        for (int match = FIFTH_PRIZE_MATCH.getValue(); match <= FIRST_PRIZE_MATCH.getValue(); match++) {
            List<Lotto> matchLottos = lottoCompany.calculateLottosWithSizeExceptBonus(lottos, match);
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
        List<Lotto> secondPrizeLottos = lottoCompany.calculateLottosWithSizeIncludeBonus(lottos, SECOND_PRIZE_MATCH.getValue());
        Prize secondPrize = Prize.SECOND;

        return PrizeResult.of(secondPrize.getCondition(), secondPrize.getMoney(), secondPrizeLottos.size());
    }
}
