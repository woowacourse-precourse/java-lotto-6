package lotto;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @DisplayName("로또가 정상 적으로 발급 됩니다.")
    @Test
    void createLotto(){
        assertDoesNotThrow(LottoGenerator::createLotto);
    }
    @DisplayName("[Error] 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[Error] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[Error] 로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,46})
    void createLottoByInvalidBoundNumber(int invalidLottoNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, invalidLottoNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}