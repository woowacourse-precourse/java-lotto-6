package lotto.publisher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoConfig;
import lotto.input.provider.NumberProvider;
import lotto.input.validator.Validator;
import lotto.lotto.AnswerLotto;
import lotto.lotto.Lotto;

public class AnswerLottoPublisher {
    private final NumberProvider provider;
    private final Validator validator;

    public AnswerLottoPublisher(
            NumberProvider provider,
            Validator validator
    ) {
        this.provider = provider;
        this.validator = validator;
    }

    public List<AnswerLotto> publish(int number) throws IOException {
        List<AnswerLotto> lottoes = new ArrayList<>();

        for (int i = 0 ; i < number; i++) {
            List<Integer> multiple = provider.getMultiple(LottoConfig.LOTTO_SLOT_NUMBER.getNum());
            validator.validate(multiple);
            Integer bonus = provider.getSingle();
            validator.validate(bonus);
            lottoes.add(new AnswerLotto(multiple, bonus));
        }
        return lottoes;
    }
}
