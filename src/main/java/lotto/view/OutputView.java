package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;

import java.util.List;

import static lotto.domain.LottoNumbers.randomsLottos;
import static lotto.util.Message.*;

public class OutputView {

    public static void printLottos(LottoAmount lottoAmount) {
        System.out.println(lottoAmount.getLottoCount() + OUTPUT_MESSAGE);

        List<Lotto> lottos = randomsLottos(lottoAmount);
        lottos.forEach(System.out::println);
    }


}
