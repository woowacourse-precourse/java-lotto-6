package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.generator.LottoNumbersGenerator;
import lotto.domain.generator.LottoRandomNumbersGenerator;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

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
        if (purchaseAmount % LottoConstant.LOTTO_PRICE != 0) {
            throw new InvalidInputException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
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
