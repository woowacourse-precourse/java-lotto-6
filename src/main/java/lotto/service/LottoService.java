package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.PurchaseAmount;
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

        IntStream.range(0, purchaseAmount.getQuantity())
                .forEach(idx -> lottoTickets.add(buySingleLotto()));

        this.purchasedTickets = lottoTickets;
        return Collections.unmodifiableList(lottoTickets);
    }

    private Lotto buySingleLotto() {
        return new Lotto(generator.generateLotto());
    }

    public WinningLotto getWinningLotto(Lotto lotto, LottoNumber lottoNumber) {
        return WinningLotto.of(lotto, lottoNumber);
    }

    public WinningResult getLottoResult(WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        purchasedTickets.forEach(purchasedTicket -> {
            int matchedCount = calculateMatched(purchasedTicket, winningLotto);
            boolean isBonus = isBonus(purchasedTicket, winningLotto);
            winningResult.updateResult(matchedCount, isBonus);
        });

        this.winningResult = winningResult;
        return winningResult;
    }

    private int calculateMatched(Lotto purchasedTicket, WinningLotto winningLotto) {
        return purchasedTicket.countDuplicatedNumber(winningLotto.getWinning());
    }

    private boolean isBonus(Lotto purchasedTicket, WinningLotto winningLotto) {
        LottoNumber bonusNumber = winningLotto.getBonus();
        return purchasedTicket.hasCertainNumber(bonusNumber);
    }

    public double calculateProfit() {
        int totalPrize = winningResult.getTotalPrize();
        return (double) totalPrize / (double) purchaseAmount.getPaidMoney() * 100;
    }
}
