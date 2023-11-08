package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class WinningLottoTest {
    private static final List<Integer> LOTTO_NUMBERS = List.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45);
    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        lotto = mock(Lotto.class);
    }

    @DisplayName("당첨 로또 객체 생성")
    @Test
    void validationTest_성공() {
        when(lotto.contains(anyInt())).thenReturn(false);

        for(int bonusNumber : LOTTO_NUMBERS) {
            assertThatCode(() -> new WinningLotto(lotto, bonusNumber)).doesNotThrowAnyException();
            verify(lotto, times(1)).contains(bonusNumber);
        }
    }

    @DisplayName("보너스 번호가 1부터 45사이의 숫자가 아니면 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void validationTest_보너스_유효하지않은숫자(int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 에러 발생")
    @Test
    void validationTest_보너스_당첨번호와중복() {
        when(lotto.contains(anyInt())).thenReturn(true);

        for(int bonusNumber : LOTTO_NUMBERS) {
            assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
            verify(lotto, times(1)).contains(bonusNumber);
        }
    }

    @DisplayName("당첨 번호가 저장된 로또 객체 반환")
    @Test
    void getLotto() {
        int bonusNumber = 3;
        when(lotto.contains(anyInt())).thenReturn(false);
        winningLotto = new WinningLotto(lotto, bonusNumber);

        assertThat(winningLotto.getLotto()).isEqualTo(lotto);
        verify(lotto, times(1)).contains(bonusNumber);
    }

    @DisplayName("보너스 번호 반환")
    @Test
    void getBonusNumber() {
        int bonusNumber = 3;
        when(lotto.contains(anyInt())).thenReturn(false);
        winningLotto = new WinningLotto(lotto, bonusNumber);

        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
        verify(lotto, times(1)).contains(bonusNumber);
    }
}