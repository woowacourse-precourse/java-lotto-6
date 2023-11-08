package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class PurchaseService {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBER_PER_LOTTO = 6;

    public PurchaseService() {
    }

    public LottoTicket buyLottoTicket(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int lottoCount = calculateLottoCount(purchaseAmount);
        return makeLottoTicket(lottoCount);
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        int amount;

        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매 금액은 정수만 입력 가능합니다.");
        }

        if (amount < 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 크고 1,000원으로 나누어 떨어져야 합니다.");
        }
    }

    private int calculateLottoCount(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        return amount / LOTTO_PRICE;
    }

    private LottoTicket makeLottoTicket(int lottoEntryCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoEntryCount; i++) {
            List<Integer> randomNumbers = generateRandomLottoNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        return new LottoTicket(lottos);
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_PER_LOTTO)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
