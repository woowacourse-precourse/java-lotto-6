package lotto.service;

import lotto.domain.AllLottoNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class NumberService {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    private PurchaseAmount purchaseAmount;
    private AllLottoNumbers allLottoNumbers;
    private final LottoGenerator lottoGenerator;

    public NumberService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void initPurchaseAmount(String input) {
        this.purchaseAmount = new PurchaseAmount(input);
    }

    public void initAllLottoNumbers() {
        this.allLottoNumbers = new AllLottoNumbers(createLottos());
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < getLottoQuantity(); count++) {
            lottos.add(new Lotto(lottoGenerator.create(LOTTO_SIZE)));
        }
        return lottos;
    }

    public int getLottoQuantity() {
        return purchaseAmount.getAmount() / LOTTO_PRICE;
    }
}
