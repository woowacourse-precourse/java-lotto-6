package lotto.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.generator.NumberGenerator;
import lotto.money.LottoMoney;

public class LottoService {

    private final NumberGenerator numberGenerator;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> makeLottoPaper(LottoMoney lottoMoney) {
        return Stream.generate(numberGenerator::generate)
                .limit(lottoMoney.getLottoCount())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
