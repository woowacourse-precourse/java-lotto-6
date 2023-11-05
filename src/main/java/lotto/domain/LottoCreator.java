package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.common.consts.ErrorMessage;
import lotto.view.OutputView;

public class LottoCreator {
    private final NumberGenerator numberGenerator;

    public LottoCreator(NumberGenerator numberGenerator) {
        validate(numberGenerator);
        this.numberGenerator = numberGenerator;
    }

    private void validate(NumberGenerator numberGenerator) {
        if (numberGenerator == null) {
            OutputView.printError(ErrorMessage.NULL_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE);
        }
    }

    public Lottos createLottos(int lottoCount) {
        List<Lotto> lottos = Stream.generate(numberGenerator::generator)
                .limit(lottoCount)
                .map(Lotto::new)
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }


}
