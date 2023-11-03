package lotto.input.view;

import java.util.List;
import lotto.Lotto;

public class GeneratedLottoOutputView {
    private final List<Lotto> lottos;

    private final Integer lottoNumber;


    public GeneratedLottoOutputView(List<Lotto> lottos) {
        this.lottos = lottos;
        this.lottoNumber = lottos.size();
    }

    public void printGeneratedLottos() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
