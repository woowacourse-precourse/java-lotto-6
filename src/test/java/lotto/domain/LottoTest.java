package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidSizeException;
import lotto.exception.NumberOutOfRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InvalidSizeException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(DuplicateNumberException.class);
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(NumberOutOfRangeException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -5)))
                .isInstanceOf(NumberOutOfRangeException.class);
    }
    @DisplayName("로또 생성에 성공한다.")
    @Test
    void createLottoSuccessfully() {
        Assertions.assertAll(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertAll(() -> new Lotto(List.of(7, 2, 1, 36, 41, 43)));
    }

}