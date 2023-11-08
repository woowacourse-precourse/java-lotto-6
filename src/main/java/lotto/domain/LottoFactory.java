package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private LottoNumbersGenerator lottoNumbersGenerator;

    public LottoFactory(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public List<Lotto> createLottos(int count) {
        List<Lotto> createdLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = lottoNumbersGenerator.generate();
            createdLottos.add(new Lotto(numbers));
        }

        return createdLottos;
    }
}
