package lotto.view;

import static lotto.etc.Constant.BUY;
import lotto.model.Lottos;

public class LottoView {

    public void outputLottoList(Lottos lottos) {
        System.out.printf(BUY.toString(), lottos.lottoCount());
        System.out.println();
        lottos
                .getLottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

}
