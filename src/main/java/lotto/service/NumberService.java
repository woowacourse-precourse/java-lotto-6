package lotto.service;

import lotto.GameUtils;
import lotto.domain.AllLottoNumbers;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.AllWinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class NumberService {
    private PurchaseAmount purchaseAmount;
    private AllLottoNumbers allLottoNumbers;
    private AllWinningNumbers allWinningNumbers;

    public NumberService() {
        allWinningNumbers = new AllWinningNumbers();
    }

    public int getPurchaseNumber() {
        return purchaseAmount.getPurchaseNumber();
    }

    public String getAllLottoNumbersInString() {
        return allLottoNumbers.toString();
    }

    public void initPurchaseAmount(String input) {
        this.purchaseAmount = new PurchaseAmount(input);
    }

    public void initAllLottoNumbers() {
        this.allLottoNumbers = new AllLottoNumbers(createLottos());
    }

    public void initWinningLotto(String input) {
        allWinningNumbers.initWinningLotto(input);
    }

    public void initBonusNumber(String input) {
        allWinningNumbers.initBonusNumber(input);
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseAmount.getPurchaseNumber(); count++) {
            lottos.add(GameUtils.createRandomLotto(Lotto.LOTTO_SIZE));
        }
        return lottos;
    }
}
