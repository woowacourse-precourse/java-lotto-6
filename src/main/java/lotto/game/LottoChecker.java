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
    private static final int INITIAL_AMOUNT = 0;

    private final LottoDraw lottoDraw;
    private final List<Lotto> lottos;
    private int totalPrizeAmount = INITIAL_AMOUNT;
    List<LottoPrize> prizes = new ArrayList<>();

    public LottoChecker(LottoDraw lottoDraw, List<Lotto> userLottos) {
        this.lottoDraw = lottoDraw;
        this.lottos = userLottos;
    }

    public LottoResults createLottoResults(int purchaseAmount) {
        calculateResults();

        List<LottoResult> lottoResults = Arrays.stream(LottoPrize.values())
                .map(lottoPrize -> createLottoResult(lottoPrize, prizes))
                .toList();

        float returnRate = (float) totalPrizeAmount / purchaseAmount;

        return LottoResults.of(lottoResults, returnRate);
    }

    private LottoResult createLottoResult(LottoPrize lottoPrize, List<LottoPrize> prizes) {
        return LottoResult.of(lottoPrize, Collections.frequency(prizes, lottoPrize));
    }

    private void calculateResults() {
        for (Lotto lotto : lottos) {
            findMatchingPrize(lotto).ifPresent((p -> {
                prizes.add(p);
                totalPrizeAmount += p.getPrizeAmount();
            }));
        }
    }

    private Optional<LottoPrize> findMatchingPrize(Lotto lotto) {
        // 조건에 해당하는 prize 중 가장 큰 상금을 가진 prize로 확정
        return Arrays.stream(LottoPrize.values())
                .filter(p -> p.getMatchingNumbers() == lottoDraw.countMatchingNumbersWith(lotto))
                .filter(p -> lottoDraw.hasMatchingBonusNumberWith(lotto) || !p.getHasMatchingBonusNumber())
                .max(LottoPrize.lottoPrizeComparator);
    }
}