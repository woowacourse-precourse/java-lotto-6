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

        List<Lotto> lottoTickets = new ArrayList<>();
        int numberOfLottoTickets = purchaseAmount / Constant.LOTTO_PRICE.getValue();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottoNumbers.sort(Comparator.naturalOrder());

            Lotto lottoTicket = new Lotto(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < Constant.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_UNDER_MINIMUM.getMessage());
        }
        if (purchaseAmount > Constant.MAXIMUM_PURCHASE_AMOUNT.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_OVER_MAXIMUM.getMessage());
        }
        if (purchaseAmount % Constant.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_INVALID_UNIT.getMessage());
        }
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                Constant.MINIMUM_LOTTO_NUMBER.getValue(),
                Constant.MAXIMUM_LOTTO_NUMBER.getValue(),
                Constant.SIZE_OF_LOTTO_NUMBERS.getValue());
        return new ArrayList<>(lottoNumbers);
    }
}
