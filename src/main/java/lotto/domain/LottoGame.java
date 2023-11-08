package lotto.domain;

import java.util.List;

public class LottoGame extends IndexModel {

    private final ThousandUnitMoney purchaseAmount;
    private final Lottos automaticLottos;
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;
    private final WinningResult winningResult;

    private LottoGame(ThousandUnitMoney purchaseAmount, Lottos automaticLottos, Lotto winningNumbers,
                      LottoNumber bonusNumber, WinningResult winningResult) {
        this.purchaseAmount = purchaseAmount;
        this.automaticLottos = automaticLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.winningResult = winningResult;
    }

    public static LottoGame create(ThousandUnitMoney purchaseAmount, Lottos automaticLottos,
                                   Lotto winningNumbers, LottoNumber bonusNumber,
                                   WinningResult winningResult) {

        return new LottoGame(purchaseAmount, automaticLottos, winningNumbers,
                bonusNumber, winningResult);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getAmount();
    }

    public List<List<Integer>> getPurchaseLottos() {
        return automaticLottos.getLottos();
    }
}
