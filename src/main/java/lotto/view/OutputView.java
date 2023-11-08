package lotto.view;

import static lotto.view.LottoConsole.*;
import static lotto.view.LottoConstants.*;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class OutputView {

    public void printNumberOfLottos(int numberOfLottos) {
        String message = String.format(MSG_PURCHASE_COUNT_PROMPT, numberOfLottos);
        print(message);
    }

    public void printLottos(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> print(formatLotto(lotto)));
    }

    private String formatLotto(Lotto lotto) {
        String lottoNumbersString = lotto.getNumbers().stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(LottoConstants.MSG_LOTTO_DELIMITER));

        return LottoConstants.MSG_LOTTO_PREFIX + lottoNumbersString + LottoConstants.MSG_LOTTO_SUFFIX;
    }
}
