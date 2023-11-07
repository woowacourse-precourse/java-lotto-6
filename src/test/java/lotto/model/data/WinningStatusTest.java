package lotto.model.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatusTest {
    
    WinningStatus winningStatus;
    
    @BeforeEach
    void beforeEach() {
        winningStatus = new WinningStatus();
    }
    
    @Test
    @DisplayName("일치하는 숫자가 3개라면 5등 당첨 수가 증가한다.")
    void fifthPlace() {
        // given
        Integer firstPlace = winningStatus.countOfPlace(1);
        Integer secondPlace = winningStatus.countOfPlace(2);
        Integer thirdPlace = winningStatus.countOfPlace(3);
        Integer fourthPlace = winningStatus.countOfPlace(4);
        Integer fifthPlace = winningStatus.countOfPlace(5);

        // when
        winningStatus.winning(3, 0);

        // then
        assertThat(winningStatus.countOfPlace(5)).isEqualTo(fifthPlace + 1);
        assertThat(winningStatus.countOfPlace(4)).isEqualTo(fourthPlace);
        assertThat(winningStatus.countOfPlace(3)).isEqualTo(thirdPlace);
        assertThat(winningStatus.countOfPlace(2)).isEqualTo(secondPlace);
        assertThat(winningStatus.countOfPlace(1)).isEqualTo(firstPlace);
    }

    @Test
    @DisplayName("일치하는 숫자가 4개라면 4등 당첨 수가 증가한다.")
    void fourthPlace() {
        // given
        Integer firstPlace = winningStatus.countOfPlace(1);
        Integer secondPlace = winningStatus.countOfPlace(2);
        Integer thirdPlace = winningStatus.countOfPlace(3);
        Integer fourthPlace = winningStatus.countOfPlace(4);
        Integer fifthPlace = winningStatus.countOfPlace(5);

        // when
        winningStatus.winning(4, 0);

        // then
        assertThat(winningStatus.countOfPlace(5)).isEqualTo(fifthPlace);
        assertThat(winningStatus.countOfPlace(4)).isEqualTo(fourthPlace + 1);
        assertThat(winningStatus.countOfPlace(3)).isEqualTo(thirdPlace);
        assertThat(winningStatus.countOfPlace(2)).isEqualTo(secondPlace);
        assertThat(winningStatus.countOfPlace(1)).isEqualTo(firstPlace);
    }

    @Test
    @DisplayName("일치하는 숫자가 5개라면 3등 당첨 수가 증가한다.")
    void thirdPlace() {
        // given
        Integer firstPlace = winningStatus.countOfPlace(1);
        Integer secondPlace = winningStatus.countOfPlace(2);
        Integer thirdPlace = winningStatus.countOfPlace(3);
        Integer fourthPlace = winningStatus.countOfPlace(4);
        Integer fifthPlace = winningStatus.countOfPlace(5);

        // when
        winningStatus.winning(5, 0);

        // then
        assertThat(winningStatus.countOfPlace(5)).isEqualTo(fifthPlace);
        assertThat(winningStatus.countOfPlace(4)).isEqualTo(fourthPlace);
        assertThat(winningStatus.countOfPlace(3)).isEqualTo(thirdPlace + 1);
        assertThat(winningStatus.countOfPlace(2)).isEqualTo(secondPlace);
        assertThat(winningStatus.countOfPlace(1)).isEqualTo(firstPlace);
    }

    @Test
    @DisplayName("일치하는 숫자가 5개이고 보너스 볼이 일치하면 2등 당첨 수가 증가한다.")
    void secondPlace() {
        // given
        Integer firstPlace = winningStatus.countOfPlace(1);
        Integer secondPlace = winningStatus.countOfPlace(2);
        Integer thirdPlace = winningStatus.countOfPlace(3);
        Integer fourthPlace = winningStatus.countOfPlace(4);
        Integer fifthPlace = winningStatus.countOfPlace(5);

        // when
        winningStatus.winning(5, 1);

        // then
        assertThat(winningStatus.countOfPlace(5)).isEqualTo(fifthPlace);
        assertThat(winningStatus.countOfPlace(4)).isEqualTo(fourthPlace);
        assertThat(winningStatus.countOfPlace(3)).isEqualTo(thirdPlace);
        assertThat(winningStatus.countOfPlace(2)).isEqualTo(secondPlace + 1);
        assertThat(winningStatus.countOfPlace(1)).isEqualTo(firstPlace);
    }

    @Test
    @DisplayName("일치하는 숫자가 6개라면 1등 당첨 수가 증가한다.")
    void firstPlace() {
        // given
        Integer firstPlace = winningStatus.countOfPlace(1);
        Integer secondPlace = winningStatus.countOfPlace(2);
        Integer thirdPlace = winningStatus.countOfPlace(3);
        Integer fourthPlace = winningStatus.countOfPlace(4);
        Integer fifthPlace = winningStatus.countOfPlace(5);

        // when
        winningStatus.winning(6, 0);

        // then
        assertThat(winningStatus.countOfPlace(5)).isEqualTo(fifthPlace);
        assertThat(winningStatus.countOfPlace(4)).isEqualTo(fourthPlace);
        assertThat(winningStatus.countOfPlace(3)).isEqualTo(thirdPlace);
        assertThat(winningStatus.countOfPlace(2)).isEqualTo(secondPlace);
        assertThat(winningStatus.countOfPlace(1)).isEqualTo(firstPlace + 1);
    }

    @Test
    @DisplayName("일치하는 숫자가 3개 미만이라면 당첨 수가 증가하지 않는다.")
    void failToPrize() {
        // given
        Integer firstPlace = winningStatus.countOfPlace(1);
        Integer secondPlace = winningStatus.countOfPlace(2);
        Integer thirdPlace = winningStatus.countOfPlace(3);
        Integer fourthPlace = winningStatus.countOfPlace(4);
        Integer fifthPlace = winningStatus.countOfPlace(5);

        // when
        winningStatus.winning(2, 0);

        // then
        assertThat(winningStatus.countOfPlace(5)).isEqualTo(fifthPlace);
        assertThat(winningStatus.countOfPlace(4)).isEqualTo(fourthPlace);
        assertThat(winningStatus.countOfPlace(3)).isEqualTo(thirdPlace);
        assertThat(winningStatus.countOfPlace(2)).isEqualTo(secondPlace);
        assertThat(winningStatus.countOfPlace(1)).isEqualTo(firstPlace);
    }
}