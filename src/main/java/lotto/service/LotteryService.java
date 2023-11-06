package lotto.service;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoPurchaseDto;
import lotto.dto.LottosDto;
import lotto.model.Lotto;
import lotto.model.LottoPurchaseAmount;
import lotto.model.LottoPurchaseQuantity;
import lotto.model.Lottos;

public class LotteryService implements Service {
    private LotteryService() {
    }

    public static LotteryService create() {
        return new LotteryService();
    }

    @Override
    public LottoPurchaseDto buyLottery(final String inputPurchaseAmount) {
        LottoPurchaseAmount amount = LottoPurchaseAmount.from(inputPurchaseAmount);
        LottoPurchaseQuantity quantity = amount.getLottoPurchaseQuantity();

        return getLottoPurchaseDto(amount, quantity);
    }

    private LottoPurchaseDto getLottoPurchaseDto(LottoPurchaseAmount amount, LottoPurchaseQuantity quantity) {
        return new LottoPurchaseDto(amount.getAmount(), quantity.quantity());
    }

    @Override
    public LottosDto generateLotto(int quantity) {
        return getLottosDto(
                Lottos.from(quantity)
        );
    }

    private LottosDto getLottosDto(Lottos lottos) {
        List<LottoDto> lottoDtos = lottos.getLotto()
                .stream()
                .map(this::getLottoDto)
                .toList();

        return new LottosDto(lottoDtos);
    }

    private LottoDto getLottoDto(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}
