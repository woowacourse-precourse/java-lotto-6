package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class LottoTest {
    private static final int NUMBERS_SIZE = 6;
    private static final List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(NUMBERS);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1부터 45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto() {
        assertThatCode(() -> new Lotto(NUMBERS))
                .doesNotThrowAnyException();
    }

    @Test
    void getNumbersSize() {
        assertThat(Lotto.getNumbersSize()).isEqualTo(NUMBERS_SIZE);
    }

    @Test
    void getNumbers() {
        assertThat(lotto.getNumbers()).isEqualTo(NUMBERS);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,true", "5,true", "6,true",
            "-1,false", "0,false", "7,false", "8,false"})
    void contains(int number, boolean expected) {
        assertThat(lotto.contains(number)).isEqualTo(expected);
    }

    @Test
    void findCorrects() {
        int expectedCorrects = 2;

        Lotto winningLotto = mock(Lotto.class);
        when(winningLotto.contains(anyInt()))
                .thenReturn(true)
                .thenReturn(false)
                .thenReturn(true)
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(false);

        assertThat(lotto.findCorrects(winningLotto)).isEqualTo(expectedCorrects);
        verify(winningLotto, times(NUMBERS_SIZE)).contains(anyInt());
    }
}