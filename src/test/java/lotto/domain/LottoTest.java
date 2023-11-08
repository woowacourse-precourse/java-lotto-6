package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    private static final Lotto LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private WinningNumber winningNumber;

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

    @ParameterizedTest
    @CsvSource({"5,6,7,8,9,10,11,SIXTH", "4,5,6,7,8,9,11,FIFTH", "3,4,5,6,7,8,11,FOURTH",
            "2,3,4,5,6,7,11,THIRD", "2,3,4,5,6,7,1,SECOND", "1,2,3,4,5,6,11,FIRST"})
    void compareTo_메서드로_로또_번호와_당첨_번호를_비교하여_당첨_등수를_반환(int number1, int number2, int number3, int number4,
                                                     int number5, int number6, int bonusNumber, String expected) {
        winningNumber = new WinningNumber(List.of(number1, number2, number3, number4, number5, number6), bonusNumber);

        PrizeCategory actual = LOTTO.compareTo(winningNumber);

        assertThat(actual).isEqualTo(PrizeCategory.valueOf(expected));
    }

}