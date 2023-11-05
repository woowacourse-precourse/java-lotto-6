package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    @DisplayName("당첨 번호가 숫자가 아니므로 예외가 발생한다.")
    void validateNumberFormat() throws Exception {
        //given
        String input = "1,2,3,4j,5,6";
        //when
        //then
        assertThatThrownBy(() -> new Winning(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아니므로 예외가 발생한다.")
    void validateSize() throws Exception {
        //given
        String input1 = "1,2,3,4";
        String input2 = "1,2,3,4,5,6,7";
        //when
        //then
        assertAll(
                () -> assertThatThrownBy(() -> new Winning(input1))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Winning(input2))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 존재하므로 예외가 발생한다.")
    void validateDuplicate() throws Exception {
        //given
        String input = "1,2,3,4,4,5";
        //when
        //then
        assertThatThrownBy(() -> new Winning(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 1이상 45이하가 아니므로 예외가 발생한다.")
    void validateRange() throws Exception {
        //given
        String input1 = "1,2,3,4,5,48";
        String input2 = "0,1,2,3,4,41";
        //when
        //then
        assertAll(
                () -> assertThatThrownBy(() -> new Winning(input1))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Winning(input2))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}