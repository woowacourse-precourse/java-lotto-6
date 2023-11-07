package lotto.service;

import lotto.domain.Lotto;
import lotto.util.RandomNumberGenerator;
import lotto.domain.Buyer;
import lotto.util.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PurchaseService {
    List<List<Integer>> lottos = new ArrayList<>();
    private final static int CURRENCY_AMOUNT_UNIT = 1000;
    Buyer buyer = new Buyer();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void purchaseLotto(String money) {
        buyer.setPurchaseAmount(Integer.parseInt(money));
        buyer.setTicketQuantity(buyer.getPurchaseAmount() / CURRENCY_AMOUNT_UNIT);
        generateLotto(buyer.getTicketQuantity());
        buyer.setLottos(lottos);
    }
    public void generateLotto(int ticketQuantity) {
        for (int i = 0; i < ticketQuantity; i++) {
            Lotto lotto = new Lotto(randomNumberGenerator.getRandomNumber());
            lottos.add(lotto.getLotto());
        }
    }
}
