package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {
    List<Lotto> lottos = List.of(new Lotto(List.of(1, 3, 5, 7, 9, 11)),
            new Lotto(List.of(2, 3, 5, 7, 9, 11)),
            new Lotto(List.of(2, 4, 6, 8, 10, 12)));

    WinningLotto winningLotto = new WinningLotto( List.of(1, 3, 5, 7, 9, 11), "2");
    private LottoService lottoService = new LottoService();

    @DisplayName("Lottos의 사이즈만큼 rate가 생기는지")
    @Test
    void lottosSize() {
        lottoService.execute(lottos, winningLotto);
        assertThat(lottoService.getRateSize()).isEqualTo(3);
    }
}