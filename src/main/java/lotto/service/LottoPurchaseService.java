package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.model.lotto.Lotto;
import lotto.model.purchase.LottoPurchase;
import lotto.model.purchase.LottoPurchaseAmount;
import lotto.service.generator.LottoNumberGenerator;

public class LottoPurchaseService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoPurchaseService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoPurchase purchase(LottoPurchaseAmountDto lottoPurchaseAmountDto) {
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.from(lottoPurchaseAmountDto.toInt());
        int lottoCount = lottoPurchaseAmount.calculatePurchaseLottoCount();
        List<Lotto> lottos = createLottos(lottoCount);
        return new LottoPurchase(lottoPurchaseAmount, lottos);
    }

    private List<Lotto> createLottos(int size) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> lottoNumbers = lottoNumberGenerator.generate();
            purchasedLottos.add(new Lotto(lottoNumbers));
        }
        return purchasedLottos;
    }
}
