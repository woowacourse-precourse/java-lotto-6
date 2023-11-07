package lotto.controller;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.Referee;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {
    @DisplayName("로또 결과를 출력한다.")
    @Test
    void getLottoResult() {
        final List<Lotto> lottos = LottoManager.createLottos(3000);
        final WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);

        Referee referee = new Referee();
        LottoController lottoController = new LottoController(referee);
        lottoController.getLottoResult(lottos, winningLotto);

        assertThat(output()).contains("당첨 통계");
    }

    @Override
    protected void runMain() {
    }
}