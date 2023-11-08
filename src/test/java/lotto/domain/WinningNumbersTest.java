package lotto.domain;

import static lotto.global.exception.ErrorMessage.DUPLICATED_NUMBER_ERROR;
import static lotto.global.exception.ErrorMessage.INVALID_LOTTO_SIZE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    @DisplayName("중복된 당첨 번호를 입력한 경우 오류를 반환한다.")
    void 중복된_당첨_번호_입력으로_오류_반환() {
        assertThatThrownBy(() -> WinningNumbers.from(Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(5)
        ))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 입력 개수과 초과한 경우 오류를 반환한다.")
    void 초과된_당첨_번호_입력으로_오류_반환() {
        assertThatThrownBy(() -> WinningNumbers.from(Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6),
                Number.valueOf(7)
        ))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_SIZE_ERROR.getMessage());
    }

    @Test
    @DisplayName("List<Number>가 특정 Number를 포함함을 검증한다.")
    void 내부_값이_같으면_contains가_true를_반환한다() {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from(Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6)
        )));

        // when
        boolean contains = winningNumbers.contains(Number.valueOf(2));

        // then
        assertThat(contains).isEqualTo(true);
    }

    @Test
    @DisplayName("List<Number>가 특정 Number의 포함하지 않음을 검증한다.")
    void 내부_값이_다르면_contains가_false를_반환한다() {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from(Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6)
        )));

        // when
        boolean contains = winningNumbers.contains(Number.valueOf(9));

        // then
        assertThat(contains).isEqualTo(false);
    }

    @Test
    @DisplayName("로또 번호가 3개 매칭되는 경우 3을 반환한다.")
    void 로또_번호_3개_매칭() {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from(Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(10),
                Number.valueOf(11),
                Number.valueOf(12)
        )));

        List<Number> numbers = List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6)
        );

        // then & when
        assertEquals(3, winningNumbers.countMatchedNumbers(numbers));
    }

    @Test
    @DisplayName("로또 번호가 6개 매칭되는 경우 6을 반환한다.")
    void 로또_번호_6개_매칭() {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from(Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6)
        )));

        List<Number> numbers = List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6)
        );

        // then & when
        assertEquals(6, winningNumbers.countMatchedNumbers(numbers));
    }

    @Test
    @DisplayName("로또 번호가 0개 매칭되는 경우 0을 반환한다.")
    void 로또_번호_0개_매칭() {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from(Lotto.from(List.of(
                Number.valueOf(7),
                Number.valueOf(8),
                Number.valueOf(9),
                Number.valueOf(10),
                Number.valueOf(11),
                Number.valueOf(12)
        )));

        List<Number> numbers = List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6)
        );

        // then & when
        assertEquals(0, winningNumbers.countMatchedNumbers(numbers));
    }
}
