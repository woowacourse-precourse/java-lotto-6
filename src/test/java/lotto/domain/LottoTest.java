package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

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

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 null이면 예외가 발생한다.")
    @Test
    void createLottoByNull() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 크기가 상한을 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverMaxNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 크기가 하한을 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByUnderMinNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 null이 포함되면 예외가 발생한다.")
    @Test
    void createLottoByIncludeNull() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(null, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("보너스 번호가 중복되었으면 예외가 발생한다.")
    @Test
    void validateBonusBallByDuplicateNumber() {
        assertThatThrownBy(() -> lotto.validateBonusBall(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 크기가 상한을 벗어나면 예외가 발생한다.")
    @Test
    void validateBonusBallByOverMaxNumber() {
        assertThatThrownBy(() -> lotto.validateBonusBall(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 크기가 하한을 벗어나면 예외가 발생한다.")
    @Test
    void validateBonusBallByUnderMinNumber() {
        assertThatThrownBy(() -> lotto.validateBonusBall(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
