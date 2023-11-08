package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Domain.WinningLotto.WinningLotto;
import lotto.Exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private final String validInputWinningNumbers = "1,2,3,4,5,6";
    private final List<Integer> validWinningNumbers = List.of(1,2,3,4,5,6);
    private final String validInputBonusNumber = "7";
    private final int validBonusNumber = 7;
    private final String invalidInputWinningNumbers = "1,2,3,4,5,5";
    private final String invalidInputBonusNumber = "6";



    @DisplayName("WinningLotto 객체 생성 테스트 - 정상 시나리오")
    @Test
    void normalTest() {
        // given
        // when
        WinningLotto winningLotto = WinningLotto.of();
        winningLotto.setLotto(validInputWinningNumbers);
        winningLotto.setBonusNumber(validInputBonusNumber);

        // then
        assertEquals(validWinningNumbers, winningLotto.getLotto().getNumbers());
        assertEquals(validBonusNumber, winningLotto.getBonusNumber().getNumber());
    }

    @DisplayName("WinningLotto 객체 생성 테스트 - 보너스 번호가 당첨 번호에 포함되는 경우")
    @Test
    void BonusNumberInWinningNumbersTest() {
        // given
        WinningLotto winningLotto = WinningLotto.of();
        winningLotto.setLotto(validInputWinningNumbers);

        // when

        // then
        assertThrows(LottoException.class, () -> winningLotto.setBonusNumber(invalidInputBonusNumber));
    }

    @DisplayName("WinningLotto 객체 생성 테스트 - 로또 번호에 중복 되어 있는 경우")
    @Test
    void WinningNumbersDuplicateTest() {
        // given
        WinningLotto winningLotto = WinningLotto.of();

        // when

        // then
        assertThrows(LottoException.class, () -> winningLotto.setLotto(invalidInputWinningNumbers));
    }
}