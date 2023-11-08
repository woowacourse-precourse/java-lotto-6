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
    private final Generator generator;

    public LottoService(Generator generator) {
        this.generator = generator;
    }

    public List<Lotto> issueMultipleLotto(PurchaseAmount purchaseAmount) {
        List<Lotto> issuedLotto = new ArrayList<>();

        IntStream.range(0, purchaseAmount.getQuantity())
                .forEach(idx -> issuedLotto.add(issueSingleLotto()));

        return Collections.unmodifiableList(issuedLotto);
    }

    private Lotto issueSingleLotto() {
        return new Lotto(generator.generate());
    }

    public WinningLotto getWinningLotto(Lotto lotto, LottoNumber lottoNumber) {
        return WinningLotto.of(lotto, lottoNumber);
    }

    public WinningResult getWinningResult(List<Lotto> issuedLotto, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        issuedLotto.forEach(issued -> {
            int winningCount = calculateWinning(issued, winningLotto);
            boolean isBonus = isBonus(issued, winningLotto);
            winningResult.updateResult(winningCount, isBonus);
        });
        return winningResult;
    }

    private int calculateWinning(Lotto issuedLotto, WinningLotto winningLotto) {
        return issuedLotto.countDuplicatedNumber(winningLotto.getWinning());
    }

    private boolean isBonus(Lotto issuedLotto, WinningLotto winningLotto) {
        LottoNumber bonusNumber = winningLotto.getBonus();
        return issuedLotto.hasCertainNumber(bonusNumber);
    }

    public double calculateProfit(PurchaseAmount purchaseAmount, WinningResult winningResult) {
        int totalPrize = winningResult.getTotalPrize();
        return (double) totalPrize / (double) purchaseAmount.getPaidMoney() * 100;
    }
}
