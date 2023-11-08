package lotto.publisher.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lotto.input.provider.NumberProvider;
import lotto.input.validator.Validator;
import lotto.lotto.Lotto;
import lotto.publisher.Publisher;

public class LottoPublisher implements Publisher {
    private final NumberProvider provider;
    private final Validator validator;

    public LottoPublisher(
            NumberProvider provider,
            Validator validator
    ) {
        this.provider = provider;
        this.validator = validator;
    }

    @Override
    public List<Lotto> publish(int number) throws IOException {
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0 ; i < number ; i++ ) {
            List<Integer> multiple = provider.getMultiple(number);
            validator.validate(multiple);
            lottoes.add(new Lotto(multiple));
        }
        return lottoes;
    }
}
