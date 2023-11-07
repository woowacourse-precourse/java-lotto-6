package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.enums.LottoConstants;
import lotto.enums.LottoPrizeConstants;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.enums.LottoPrizeConstants.BONUS_PRIZE;
import static lotto.enums.LottoPrizeConstants.FIVE_MATCH_PRIZE;
import static lotto.enums.LottoPrizeConstants.FOUR_MATCH_PRIZE;
import static lotto.enums.LottoPrizeConstants.SIX_MATCH_PRIZE;
import static lotto.enums.LottoPrizeConstants.THREE_MATCH_PRIZE;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(int quantity) {
        lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(randomNumbers()));
        }
    }


    public static Lottos purchaseLottos(int quantity) {
        return new Lottos(quantity);
    }

    public Map<LottoPrizeConstants, Integer> checkLottos(List<Integer> winningNumbers, int bonusNumber) {
        List<LottoPrizeConstants> lottoPrizeConstants = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoPrizeConstants.add(lotto.checkPrize(winningNumbers, bonusNumber));
        }
        return countPrize(lottoPrizeConstants);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getQuantity() {
        return lottos.size();
    }

    public double getIncomeRate(Map<LottoPrizeConstants, Integer> matchedLottoCount) {
        final int percentage = 100;
        double income = (matchedLottoCount.get(THREE_MATCH_PRIZE) * THREE_MATCH_PRIZE.getPrizeMoney())
                + (matchedLottoCount.get(FOUR_MATCH_PRIZE) * FOUR_MATCH_PRIZE.getPrizeMoney())
                + (matchedLottoCount.get(FIVE_MATCH_PRIZE) * FIVE_MATCH_PRIZE.getPrizeMoney())
                + (matchedLottoCount.get(BONUS_PRIZE) * BONUS_PRIZE.getPrizeMoney())
                + (matchedLottoCount.get(SIX_MATCH_PRIZE) * SIX_MATCH_PRIZE.getPrizeMoney());
        double spendMoney = getQuantity() * LottoConstants.LOTTO_PRICE.getConstant();
        return (income / spendMoney) * percentage;
    }

    private List<Integer> randomNumbers() {
        List<Integer> numbers = pickUniqueNumbersInRange(
                LottoConstants.LOTTO_START_NUMBER.getConstant(),
                LottoConstants.LOTTO_END_NUMBER.getConstant(),
                LottoConstants.LOTTO_PER_NUMBERS.getConstant()
        );
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private Map<LottoPrizeConstants, Integer> countPrize(List<LottoPrizeConstants> lottoPrizes) {
        Map<LottoPrizeConstants, Integer> matchedLottoCount = new HashMap<>();
        matchedLottoCount.put(THREE_MATCH_PRIZE, Collections.frequency(lottoPrizes, THREE_MATCH_PRIZE));
        matchedLottoCount.put(FOUR_MATCH_PRIZE, Collections.frequency(lottoPrizes, FOUR_MATCH_PRIZE));
        matchedLottoCount.put(FIVE_MATCH_PRIZE, Collections.frequency(lottoPrizes, FIVE_MATCH_PRIZE));
        matchedLottoCount.put(BONUS_PRIZE, Collections.frequency(lottoPrizes, BONUS_PRIZE));
        matchedLottoCount.put(SIX_MATCH_PRIZE, Collections.frequency(lottoPrizes, SIX_MATCH_PRIZE));
        return matchedLottoCount;
    }
}
