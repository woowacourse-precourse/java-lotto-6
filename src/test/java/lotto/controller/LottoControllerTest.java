package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoResultOutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;


class LottoControllerTest {

//    @Test
//    @DisplayName("사용자가 지불한 금액만큼 로또를 구매할 수 있다.")
//    public void buyLottos() {
//        // given
//        String amount = "10000";
//        int denomination = 1000;
//        LottoController lottoController = new LottoController(new LottoBuyOutputView(), new LottoResultOutputView());
//        System.setIn(new ByteArrayInputStream(amount.getBytes()));
//        // when
//        Lottos lottos = lottoController.buyLottos();
//        // then
//        List<Lotto> result = lottos.getLottos();
//        //size = amount / 10000
//        Assertions.assertThat(result).hasSize(10);
//    }

}