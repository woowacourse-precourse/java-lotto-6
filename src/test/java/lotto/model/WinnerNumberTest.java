package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.ValidateMessage.WINNER_NUMBER_IS_BETWEEN_1_TO_45;
import static lotto.constant.ValidateMessage.WINNER_NUMBER_IS_NOT_SIZE_EQUAL_TO_SIX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinnerNumberByOverSize() {
        assertThatThrownBy(() -> new WinnerNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinnerNumberByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new WinnerNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 5개 이하이면 예외가 발생한다.")
    @Test
    void createWinnerNumberByLowSize() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinnerNumber(List.of(1, 2, 3, 4, 5)));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_IS_NOT_SIZE_EQUAL_TO_SIX.message));
    }

    @DisplayName("당첨 번호는 중복된 숫자가 없어야 한다.")
    @Test
    void createWinnerNumberByFitSize() {
        //given
        WinnerNumber WinnerNumber = new WinnerNumber(List.of(1, 22, 13, 4, 5, 6));

        //then
        assertThat(WinnerNumber.getWinnerNumbers().size()).isEqualTo(6);
        assertThat(WinnerNumber.getWinnerNumbers()).containsExactly(1, 22, 13, 4, 5, 6);
    }

    @DisplayName("당첨 숫자는 1 ~ 45 사이 숫자여야 한다.")
    @Test
    void isBetween1And45Test() {
        //given
        List<Integer> isNotBetween1And45 = pickUniqueNumbersInRange(46, 100, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinnerNumber(isNotBetween1And45));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_IS_BETWEEN_1_TO_45.message));
    }
}