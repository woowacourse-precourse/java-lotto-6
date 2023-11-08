package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.services.LottoNumberGenerator;

public class LottoFactory {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoFactory(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = lottoNumberGenerator.generateNumbers();
        return new Lotto(numbers);
    }

    public List<Lotto> purchaseLottos(int numberOfLottos) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int count = 0; count < numberOfLottos; count++) {
            Lotto lotto = generateLotto();
            generatedLottos.add(lotto);
        }
        return generatedLottos;
    }
}
