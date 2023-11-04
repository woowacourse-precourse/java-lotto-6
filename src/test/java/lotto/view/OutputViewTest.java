package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class OutputViewTest {

    @DisplayName("구매 금액 입력에 따른 출력 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000})
    void responseLottosTest(int purchaseAmount){
        OutputView outputView = new OutputView();
        List<Lotto> lottos = LottoMachine.generateLottoByPurchaseAmount(purchaseAmount);
        outputView.responseLottos(lottos);
    }
}