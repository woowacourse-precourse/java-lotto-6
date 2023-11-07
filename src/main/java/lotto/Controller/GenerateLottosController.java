package lotto.Controller;

import static lotto.View.OutputView.PrintLottos.printLottos;

import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.Lottos;

public class GenerateLottosController {

    private final Lottos lottos;

    public GenerateLottosController(int count) {
        lottos = new Lottos(count);

        printLottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

}
