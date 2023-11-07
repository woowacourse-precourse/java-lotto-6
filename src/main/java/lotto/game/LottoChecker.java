package lotto.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lotto.constants.LottoPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.dto.LottoResult;
import lotto.dto.LottoResults;

public class LottoChecker {
    private final LottoDraw lottoDraw;
    private final List<Lotto> lottos;
    private int totalPrizeAmount = 0;

    List<LottoPrize> prizes = new ArrayList<>();


    public LottoChecker(LottoDraw lottoDraw, List<Lotto> userLottos) {
        this.lottoDraw = lottoDraw;
        this.lottos = userLottos;
    }

    public LottoResults createLottoResults(int purchaseAmount) {
        calculateResult();

        List<LottoResult> lottoResults = new ArrayList<>();

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoResults.add(LottoResult.of(lottoPrize, Collections.frequency(prizes, lottoPrize)));
        }

        float returnRate = (float) totalPrizeAmount / purchaseAmount;

        return new LottoResults(lottoResults, returnRate);
    }

    private void calculateResult() {
        for (Lotto lotto : lottos) {
            findMatchingPrize(lotto).ifPresent((p -> {
                prizes.add(p);
                totalPrizeAmount += p.getPrizeAmount();
            }));
        }
    }

    private Optional<LottoPrize> findMatchingPrize(Lotto lotto) {
        return Arrays.stream(LottoPrize.values())
                .filter(p -> p.getMatchingNumbers() == lottoDraw.countMatchingNumbersWith(lotto))
                .filter(p -> lottoDraw.hasMatchingBonusNumberWith(lotto) || !p.getHasMatchingBonusNumber())
                .max(LottoPrize.lottoPrizeComparator);
    }
}