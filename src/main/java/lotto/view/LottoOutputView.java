package lotto.view;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.global.LottoOutputMessage;

import java.util.List;

import static lotto.global.LottoOutputMessage.*;

public class LottoOutputView {

    public LottoOutputView() {
    }

    public void presentLottoList(final List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + PURCHASED_LOTTO_COUNT.getMessage());
        lottos.forEach(System.out::println);
    }

    public void presentLottoResult(final LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT.getMessage());
        System.out.println(lottoResult);
    }
}
