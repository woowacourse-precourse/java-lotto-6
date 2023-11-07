package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;
    private static final int REMAINDER_ZERO = 0;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_NUMBERS_MINIMUM = 1;
    private static final int LOTTO_NUMBERS_MAXIMUM = 45;

    private final List<Lotto> lottoTickets;

    public LottoTickets(int purchaseAmount) {
        validateDivisibleByLottoPrice(purchaseAmount);
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        lottoTickets = new ArrayList<>();
        publishLottoTickets(lottoCount);
    }

    private void validateDivisibleByLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE > REMAINDER_ZERO) {
            ExceptionMessage.LOTTO_WRONG_PURCHASE_AMOUNT.throwIllegalArgumentException();
        }
    }

    private void publishLottoTickets(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(createLottoByRandomNumbers());
        }
    }

    private Lotto createLottoByRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBERS_MINIMUM, LOTTO_NUMBERS_MAXIMUM, LOTTO_NUMBERS_SIZE);
        return new Lotto(randomNumbers);
    }

    public List<LottoRankInfo> createLottoRankInfos(LottoWinningNumbers winningNumbers, LottoBonusNumber bonusNumber) {
        List<LottoRankInfo> rankInfos = new ArrayList<>();

        for (Lotto lotto : lottoTickets) {
            int matchingCount = lotto.countMatchingNumbers(winningNumbers);
            boolean matchingBonus = lotto.containsBonusNumber(bonusNumber);
            LottoRankInfo rankInfo = LottoRankInfo.getLottoRankInfo(matchingCount, matchingBonus);
            rankInfos.add(rankInfo);
        }
        return rankInfos;
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
