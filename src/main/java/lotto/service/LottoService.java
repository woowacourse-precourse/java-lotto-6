package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.dto.WinningLotto;
import lotto.dto.WinningResult;

public class LottoService {
    private final NumberGenerator generator;
    private PurchaseAmount purchaseAmount;
    private List<Lotto> purchasedTickets;
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

    public WinningLotto getWinningLotto(String winningNumber, String bonus) {
        return WinningLotto.of(winningNumber, bonus);
    }

    public WinningResult getLottoResult(WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        for (Lotto purchasedTicket : purchasedTickets) {
            int matchedCount = calculateMatched(purchasedTicket, winningLotto);
            boolean isBonus = isBonus(purchasedTicket, winningLotto);
            winningResult.updateResult(matchedCount, isBonus);
        }

        this.winningResult = winningResult;
        return winningResult;
    }

    private int calculateMatched(Lotto purchasedTicket, WinningLotto winningLotto) {
        return Math.toIntExact(purchasedTicket.getNumbers()
                .stream()
                .filter(winningLotto::hasTargetLottoNumber)
                .count());
    }

    private boolean isBonus(Lotto purchasedTicket, WinningLotto winningLotto) {
        LottoNumber bonusNumber = winningLotto.getBonusNumber();
        return purchasedTicket.getNumbers().contains(bonusNumber);
    }

    public double calculateProfit() {
        int totalPrize = winningResult.getTotalPrize();
        return Double.valueOf(totalPrize) / Double.valueOf(purchaseAmount.getPaidMoney()) * 100;
    }
}
