package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public LottoMachine() {}

    public int calculateNumberOfTickets(int paidAmount) {
        validatePurchaseAmount(paidAmount);
        return paidAmount / LOTTO_PRICE;
    }

    public List<Lotto> purchaseLottos(int cash) {
        int numberOfLottos = calculateNumberOfTickets(cash);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = RandMachine.generateRandomNumbers();
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("지불한 금액이 로또 가격보다 적습니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
