package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.controller.dto.output.PurchasedLottosDto;
import lotto.model.Lotto;
import lotto.model.LottoPurchaseAmount;
import lotto.service.generator.LottoNumberGenerator;

public class LottoPurchaseService {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoPurchaseService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public PurchasedLottosDto purchase(LottoPurchaseAmountDto lottoPurchaseAmountDto) {
        int lottoCount = calculateLottoCount(lottoPurchaseAmountDto);
        return new PurchasedLottosDto(createLottos(lottoCount));
    }

    private int calculateLottoCount(LottoPurchaseAmountDto lottoPurchaseAmountDto) {
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.from(lottoPurchaseAmountDto.toInt());
        return lottoPurchaseAmount.calculateTotalLottos();
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
