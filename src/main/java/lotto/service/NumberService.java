package lotto.service;

import lotto.domain.AllLottoNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class NumberService {
    private PurchaseAmount purchaseAmount;
    private AllLottoNumbers allLottoNumbers;
    private final LottoGenerator lottoGenerator;

    public NumberService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public int getPurchasedNumber() {
        return purchaseAmount.getPurchasedNumber();
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

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseAmount.getPurchasedNumber(); count++) {
            lottos.add(new Lotto(lottoGenerator.create(Lotto.LOTTO_SIZE)));
        }
        return lottos;
    }
}
