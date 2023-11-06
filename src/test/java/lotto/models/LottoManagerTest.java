package lotto.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    @DisplayName("로또 생성")
    @Test
    void createLotto() {
        // given
        int lottoAmount = 5;

        // when
        LottoManager lottoManager = new LottoManager(lottoAmount);

        // then
        assertEquals(lottoAmount, lottoManager.getLottos().size());
    }

    @DisplayName("로또 결과 계산")
    @Test
    void calcLottoResult() {
        // given
        int lottoAmount = 5;
        LottoManager lottoManager = new LottoManager(lottoAmount);
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinNumber winNumber = new WinNumber(winLotto, bonusNumber);

        // when
        LottoResult lottoResult = lottoManager.calcLottoResult(winNumber);

        // then
        assertEquals(lottoAmount, lottoResult.getLottoAmount());
    }
}