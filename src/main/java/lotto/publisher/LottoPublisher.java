package lotto.publisher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoConfig;
import lotto.input.provider.NumberProvider;
import lotto.input.validator.Validator;
import lotto.lotto.Lotto;

public class LottoPublisher {
    private final NumberProvider provider;
    private final Validator validator;

    public LottoPublisher(
            NumberProvider provider,
            Validator validator
    ) {
        this.provider = provider;
        this.validator = validator;
    }

    public List<Lotto> publish(int number) throws IOException {
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0 ; i < number ; i++ ) {
            List<Integer> multiple = provider.getMultiple(LottoConfig.LOTTO_SLOT_NUMBER.getNum());
            validator.validate(multiple);
            lottoes.add(new Lotto(multiple));
        }
        return lottoes;
    }
}
