package lotto.input.view.output;

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
        printPhrasedLotto(lottoNumber);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printPhrasedLotto(Integer count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
