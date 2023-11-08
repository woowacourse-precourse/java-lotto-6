package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.domain.Lotto;

public class LottoService {
    public List<Lotto> purchaseLottoTickets(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int numberOfLottoTickets = purchaseAmount / Constant.UNIT_OF_LOTTO_PURCHASE_AMOUNT.getValue();
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lottoTicket = new Lotto(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < Constant.MINMUM_LOTTO_PURCHASE_AMOUNT.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_UNDER_MINIMUM.getMessage());
        }
        if (purchaseAmount > Constant.MAXMUM_LOTTO_PURCHASE_AMOUNT.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_OVER_MAXIMUM.getMessage());
        }
        if (purchaseAmount % Constant.UNIT_OF_LOTTO_PURCHASE_AMOUNT.getValue() != 0) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_INVALID_UNIT.getMessage());
        }
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }
}