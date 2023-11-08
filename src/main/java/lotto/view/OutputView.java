package lotto.view;

import static lotto.constant.OutputMessage.LOTTO_FORMAT;
import static lotto.constant.OutputMessage.LOTTO_NUMBERS_SEPARATOR;
import static lotto.constant.OutputMessage.NUMBER_OF_LOTTO;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.Lottos;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottos(Lottos userLottos) {
        List<Lotto> lottos = userLottos.getLottos();
        System.out.println(String.format(NUMBER_OF_LOTTO, lottos.size()));
        lottos.stream().forEach(OutputView::printLottoNumbers);
    }

    private static void printLottoNumbers(Lotto lotto) {
        String numbers = lotto.getNumbers().stream()
                .sorted().map(LottoNumber::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_SEPARATOR));
        System.out.println(String.format(LOTTO_FORMAT, numbers));
    }
}
