package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Domain.WinningLotto.WinningLotto;
import lotto.Exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("WinningLotto 객체 생성 테스트 - 정상 시나리오")
    @Test
    void normalTest() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "7";

        // when
        WinningLotto winningLotto = WinningLotto.of(inputWinningNumbers, inputBonusNumber);

        // then
        assertEquals(List.of(1,2,3,4,5,6), winningLotto.getLotto().getNumbers());
        assertEquals(7, winningLotto.getBonusNumber().getNumber());
    }

    @DisplayName("WinningLotto 객체 생성 테스트 - 보너스 번호가 당첨 번호에 포함되는 경우")
    @Test
    void BonusNumberInWinningNumbersTest() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "6";

        // when

        // then
        assertThrows(LottoException.class, () -> WinningLotto.of(inputWinningNumbers, inputBonusNumber));
    }

    @DisplayName("WinningLotto 객체 생성 테스트 - 로또 번호에 중복 되어 있는 경우")
    @Test
    void WinningNumbersDuplicateTest() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,5";
        String inputBonusNumber = "6";

        // when

        // then
        assertThrows(LottoException.class, () -> WinningLotto.of(inputWinningNumbers, inputBonusNumber));
    }
}