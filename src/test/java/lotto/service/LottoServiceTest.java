package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void 로또_숫자_정상_생성() {
        List<Lotto> lotto = new ArrayList<>();

        lottoService.createLotto(3, lotto);

        assertThat(lotto.size()).isEqualTo(3);
    }

}