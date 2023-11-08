package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Message;
import lotto.domain.Lotto;

public class LottoService {
    public List<Lotto> purchaseLottoTickets(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int numberOfLottoTickets = purchaseAmount / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lottoTicket = new Lotto(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1_000) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_UNDER_MINIMUM.toString());
        }
        if (purchaseAmount > 100_000) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_OVER_MAXIMUM.toString());
        }
        if (purchaseAmount % 1_000 != 0) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_INVALID_UNIT.toString());
        }
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }
}