package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningTest {
    @Test
    @DisplayName("로또 당첨 번호와 보너스 번호가 중복일 경우 예외 발생 테스트")
    void duplicateLottoWinningNumbersAndBonusNumber(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        LottoWinning lottoWinning = new LottoWinning();

        assertThrows(IllegalArgumentException.class, () -> {
            lottoWinning.setWinningNumbers(lotto);
            lottoWinning.setBonusNumber(bonusNumber);
        });
    }
}