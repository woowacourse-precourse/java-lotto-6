package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int numberOfTicketsToPurchase = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < numberOfTicketsToPurchase; i++) {
            Lotto ticket = new Lotto(RandomNumberGenerator.generateRandomNumbers());
            purchasedLottos.add(ticket);
        }
        return purchasedLottos;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}