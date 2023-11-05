package lotto.control;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    @DisplayName("로또를 생성한다.")
    @Test
    void createLotto() {
        LottoController lottoController = new LottoController();
        int purchaseAmount = 5;

        List<Lotto> lottos = lottoController.createLotto(purchaseAmount);

        assertThat(lottos.size()).isEqualTo(purchaseAmount);
    }
}