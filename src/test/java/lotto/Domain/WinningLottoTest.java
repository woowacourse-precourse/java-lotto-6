package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("WinningLotto 객체 생성 테스트")
    @Test
    void test() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "7";

        // when
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers, inputBonusNumber);

        // then
        assertEquals(List.of(1,2,3,4,5,6), winningLotto.getLotto().getNumbers());
        assertEquals(7, winningLotto.getBonusNumber().getBonusNumber());
    }
}