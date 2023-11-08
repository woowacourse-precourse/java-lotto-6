package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto(NumberGenerator.formatNumbers("1,2,3,4,5,6"));
    }

    @CsvSource({"-1", "0", "46", "1000"})
    @ParameterizedTest
    void 보너스번호_범위_밖_예외처리(String input) {
        assertThatThrownBy(() -> new WinningLotto(lotto, Integer.parseInt(input))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @CsvSource({"1", "2", "3", "4", "5", "6"})
    @ParameterizedTest
    void 보너스번호_중복_예외처리(String input) {
        assertThatThrownBy(() -> new WinningLotto(lotto, Integer.parseInt(input))).isInstanceOf(
                IllegalArgumentException.class);
    }
}