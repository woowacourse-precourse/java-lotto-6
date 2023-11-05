package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Model.Lotto;
import lotto.View.inputView;
import lotto.View.outputView;

public class Controller {
    private static List<Lotto> generateLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = purchaseAmount / 1000;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Lotto.getLottoRandomNumber()));
        }
        return lottos;
    }


}
