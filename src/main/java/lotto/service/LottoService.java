package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.dto.WinningResult;

public class LottoService {
    private final NumberGenerator generator;
    private PurchaseAmount purchaseAmount;
    private List<Lotto> purchasedTickets;
    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private WinningResult winningResult;

    public LottoService(NumberGenerator generator) {
        this.generator = generator;
        purchasedTickets = new ArrayList<>();
    }

    public List<Lotto> buyMultipleLotto(String money) {
        List<Lotto> lottoTickets = new ArrayList<>();
        purchaseAmount = PurchaseAmount.from(money);

        for (int i = 0; i < purchaseAmount.getQuantity(); ++i) {
            lottoTickets.add(buySingleLotto());
        }
        this.purchasedTickets = lottoTickets;
        return Collections.unmodifiableList(lottoTickets);
    }

    private Lotto buySingleLotto() {
        return new Lotto(generator.generateLotto());
    }

    public void getWinningLotto(String winningNumber, String bonus) {
        winningLotto = new Lotto(winningNumber);
        bonusNumber = LottoNumber.from(bonus);
    }

    public WinningResult getLottoResult() {
        WinningResult winningResult = new WinningResult();
        for (Lotto purchasedTicket : purchasedTickets) {
            int matchedCount = getMatchedResult(purchasedTicket);
            boolean isBonus = isBonus(purchasedTicket);
            winningResult.updateResult(matchedCount, isBonus);
        }

        this.winningResult = winningResult;
        return winningResult;
    }

    private int getMatchedResult(Lotto purchasedTicket) {
        return Math.toIntExact(purchasedTicket.getNumbers()
                .stream()
                .filter(num -> winningLotto.getNumbers().contains(num))
                .count());
    }

    private boolean isBonus(Lotto purchasedTicket) {
        return purchasedTicket.getNumbers().contains(bonusNumber);
    }

    public double calculateProfit() {
        int totalPrize = winningResult.getTotalPrize();
        return Double.valueOf(totalPrize) / Double.valueOf(purchaseAmount.getPaidMoney()) * 100;
    }
}
