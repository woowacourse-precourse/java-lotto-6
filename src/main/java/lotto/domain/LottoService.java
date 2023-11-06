package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private final List<Lotto> lottoContainer;

    public LottoService(List<Lotto> lottoContainer) {
        this.lottoContainer = lottoContainer;
    }

    private List<Integer> generateLotto() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        return lottoNumberGenerator.generate();
    }

    public List<Integer> createLottoList() {
        List<Integer> generatedLotto = generateLotto();
        return generatedLotto.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
