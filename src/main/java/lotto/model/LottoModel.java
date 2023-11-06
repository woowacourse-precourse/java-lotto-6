package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.dto.LottoMatchCountDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoModel {
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 45;
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int LOTTO_AMOUNT = 1_000;
    private final static double PERCENTAGE = 100;
    private final static double ROUND_RANGE = 10.0;

    public List<Lotto> getRandomLottos(final int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = getRandomLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto getRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public List<LottoMatch> getLottoMatches(final List<Lotto> lottos, final List<Integer> winningNumbers, final int bonusNumber) {
        List<LottoMatch> lottoMatches = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoMatch lottoMatch = lotto.compareWinningNumbers(winningNumbers, bonusNumber);
            lottoMatches.add(lottoMatch);
        }
        return lottoMatches;
    }

    public LottoMatchCountDto getLottoMatchCount(final List<LottoMatch> lottoMatches) {
        LottoMatchCountDto lottoMatchCountDto = new LottoMatchCountDto();
        for (LottoMatch lottoMatch : lottoMatches) {
            lottoMatchCountDto.countLottoMatch(lottoMatch);
        }
        return lottoMatchCountDto;
    }

    public double calculateRevenue(final List<LottoMatch> lottoMatches, final int purchaseCount) {
        int amount = 0;
        for (LottoMatch lottoMatch : lottoMatches) {
            amount += lottoMatch.getAmount();
        }

        double purchaseAmount = LOTTO_AMOUNT * purchaseCount;
        double revenue = (amount / purchaseAmount) * PERCENTAGE;
        return Math.round(revenue * ROUND_RANGE) / ROUND_RANGE;
    }
}
