package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setup(){
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("당첨 번호 발행")
    void createWinningNumber() {
        String winningNumber = "1,2,3,4,5,6";
        Lotto lotto = lottoService.createWinningNumber(winningNumber);
        assertEquals(lotto.getNumbers(),List.of(1,2,3,4,5,6));
    }
    @Test
    @DisplayName("중복된 번호 있을 시 예외 발생")
    void exceptionByDuplicateWinningNumber() {
        String winningNumber = "1,2,3,4,5,5";
        assertThatThrownBy(() -> lottoService.createWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호가 있습니다.");
    }
    @Test
    @DisplayName("1부터 45사이의 숫자가 아닐 시 예외 발생")
    void exceptionByOutOfRangeWinningNumber() {
        String winningNumber = "1,2,3,4,5,47";
        assertThatThrownBy(() -> lottoService.createWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    @Test
    @DisplayName("로또 번호가 6개가 아니라면 예외 발생")
    void exceptionBySizeNotSixWinningNumber() {
        String winningNumber = "1,2,3,4,5";
        assertThatThrownBy(() -> lottoService.createWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개를 입력해야 합니다.");
    }
}