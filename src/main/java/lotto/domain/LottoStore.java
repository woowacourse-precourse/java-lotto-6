package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.generator.LottoNumbersGenerator;
import lotto.domain.generator.LottoRandomNumbersGenerator;
import lotto.exception.ErrorMessage;
import lotto.validator.NumberValidator;

public class LottoStore {
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoStore(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public LottoStore() {
        this(new LottoRandomNumbersGenerator());
    }

    public List<Lotto> buyLottos(int purchaseAmount) {
        validateMultipleOfLottoPrice(purchaseAmount);
        int lottoCount = purchaseAmount / LottoConstant.LOTTO_PRICE;
        return generateLottos(lottoCount);
    }

    private void validateMultipleOfLottoPrice(int purchaseAmount) {
        NumberValidator.of(purchaseAmount).shouldBeMultipleOf(
                LottoConstant.LOTTO_PRICE,
                ErrorMessage.INVALID_PURCHASE_AMOUNT
        );
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = lottoNumbersGenerator.generate();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
