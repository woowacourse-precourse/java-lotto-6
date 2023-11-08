package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumberTest {
    @DisplayName("로또 추첨 번호 객체 생성")
    @Test
    void createLottoWinningNumber() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> cloneNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        LottoWinningNumber winningNumber = LottoWinningNumber.builder()
                .commonNumbers(numbers).bonusNumber(bonusNumber)
                .build();

        //then
        assertThat(winningNumber.getCommonNumbers()).isEqualTo(cloneNumbers);
        assertThat(winningNumber.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("로또 추첨 번호 builder - 보너스 없을 경우")
    @Test
    void createLottoWinningNumberThatNoBonus() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when & then
        assertThatThrownBy(() -> {
            LottoWinningNumber.builder()
                    .commonNumbers(numbers)
                    .build();
        }).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("로또 추첨 번호 builder - 일반 숫자가 없을 경우")
    @Test
    void createLottoWinningNumberThatNoCommon() {
        //given
        int bonus = 7;

        //when & then
        assertThatThrownBy(() -> {
            LottoWinningNumber.builder()
                    .bonusNumber(bonus)
                    .build();
        }).isInstanceOf(IllegalStateException.class);
    }

}