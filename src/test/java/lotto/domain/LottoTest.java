package lotto.domain;

import static lotto.error.ExceptionCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.error.ExceptionCode.INVALID_LOTTO_NUMBER;
import static lotto.error.ExceptionCode.INVALID_LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        // given & when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // given & when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createLottoByUnderOrOverNumber(final Integer number) {
        // given & when & then
        assertThatThrownBy(() -> new Lotto(List.of(number, 2, 3, 4, 5, 6)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("번호가 모두 일치하면 1등을 반환한다.")
    @Test
    void getFirstPrize() {
        // given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        final Prize prize = lotto.getPrize(winnerNumbers);

        // then
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @DisplayName("번호가 5개만 일치하고 보너스 번호가 일치하면 2등을 반환한다.")
    @Test
    void getSecondPrize() {
        // given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        final Prize prize = lotto.getPrize(winnerNumbers);

        // then
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @DisplayName("번호가 5개만 일치하면 3등을 반환한다.")
    @Test
    void getThirdPrize() {
        // given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 45);

        // when
        final Prize prize = lotto.getPrize(winnerNumbers);

        // then
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @DisplayName("번호가 4개만 일치하면 4등을 반환한다.")
    @Test
    void getFourthPrize() {
        // given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 45);

        // when
        final Prize prize = lotto.getPrize(winnerNumbers);

        // then
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @DisplayName("번호가 3개만 일치하면 5등을 반환한다.")
    @Test
    void getFifthPrize() {
        // given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 45);

        // when
        final Prize prize = lotto.getPrize(winnerNumbers);

        // then
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("번호가 2개 이하 일치하면 상이 없다.")
    @Test
    void getNonePrize() {
        // given
        final Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 45);

        // when
        final Prize prize = lotto.getPrize(winnerNumbers);

        // then
        assertThat(prize).isEqualTo(Prize.NONE);
    }

    @DisplayName("번호 문자열은 정렬된 상태로 출력된다.")
    @Test
    void getSortedNumberString() {
        // given
        final Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        final String expected = "1, 2, 3, 4, 5, 6";

        // when
        final String actual = lotto.getNumberString();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}