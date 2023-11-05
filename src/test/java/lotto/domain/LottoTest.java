package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)));
    }
    @DisplayName("로또 생성에 성공한다.")
    @Test
    void createLottoSuccessfully() {
        Assertions.assertAll(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertAll(() -> new Lotto(List.of(7, 2, 1, 36, 41, 43)));
    }

    // TODO: 발행된 로또가 오름차순으로 정렬되어있는지 확인하는 방법이 있을까?
}