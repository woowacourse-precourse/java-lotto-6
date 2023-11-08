package lotto.view.output;

import java.util.stream.Collectors;
import lotto.Properties;
import lotto.model.Lotto;
import lotto.view.Prompt;

public class LottoNumberOutputView extends OutputView {

    private final Lotto lotto;
    private final Prompt message = Prompt.FORMAT_LOTTO_NUMBERS;

    public LottoNumberOutputView(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void render() {
        String lottoNumbers = lotto.getNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(Properties.LOTTO_NUMBER_DELIMITER));
        message.println(lottoNumbers);
    }
}
