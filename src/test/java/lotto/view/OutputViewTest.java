package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.Test;

import java.util.List;

class OutputViewTest {

    @Test
    void responseLottosTest(){
        OutputView outputView = new OutputView();
        List<Lotto> lottos = LottoMachine.generateLottoByPurchaseAmount(8000);
        outputView.responseLottos(lottos);
    }
}