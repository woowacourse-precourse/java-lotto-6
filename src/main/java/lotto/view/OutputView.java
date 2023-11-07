package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;

import java.util.List;

import static lotto.domain.LottoNumbers.randomsLottos;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "개를 구매했습니다.";

    public static void printLottos(LottoAmount lottoAmount) {
        System.out.println(lottoAmount.getLottoCount() + OUTPUT_MESSAGE);

        List<Lotto> lottos = randomsLottos(lottoAmount);
        lottos.forEach(System.out::println);
    }

}
