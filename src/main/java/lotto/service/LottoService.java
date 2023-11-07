package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    // 구입 금액은 1000원으로 나누어떨어져야 한다.
    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 입력 받아야합니다.");
        }
    }

    public List<Lotto> buyLottoTickets(int purchaseAmount) {
        int numberOfLottoTicketsToBuy = calculateNumberOfLottoTicketsToBuy(purchaseAmount);
        return generateLottoTickets(numberOfLottoTicketsToBuy);
    }

    public int calculateNumberOfLottoTicketsToBuy(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> generateLottoTickets(int numberOfTickets) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            result.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return result;
    }
}
