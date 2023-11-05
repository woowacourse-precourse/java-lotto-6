package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinnerTypeTest {
    @Test
    @DisplayName("6개의 번호를 맞추면 FIRST여야 한다.")
    void firstWinner() {
        // given
        WinnerType winner = WinnerType.of(6);

        // then
        assertThat(winner).isEqualTo(WinnerType.FIRST);
    }

    @Test
    @DisplayName("5개의 번호와 보너스 번호를 맞추면 SECOND여야 한다.")
    void secondWinner() {
        // given
        WinnerType winner = WinnerType.of(5, true);

        // then
        assertThat(winner).isEqualTo(WinnerType.SECOND);
    }

    @Test
    @DisplayName("5개의 번호를 맞추면 THIRD여야 한다.")
    void thirdWinner() {
        // given
        WinnerType winner = WinnerType.of(5);

        // then
        assertThat(winner).isEqualTo(WinnerType.THIRD);
    }

    @Test
    @DisplayName("4개의 번호를 맞추면 FOURTH여야 한다.")
    void fourthWinner() {
        // given
        WinnerType winner = WinnerType.of(4);

        // then
        assertThat(winner).isEqualTo(WinnerType.FOURTH);
    }

    @Test
    @DisplayName("3개의 번호를 맞추면 FIFTH여야 한다.")
    void fifthWinner() {
        // given
        WinnerType winner = WinnerType.of(3);

        // then
        assertThat(winner).isEqualTo(WinnerType.FIFTH);
    }

    @ParameterizedTest
    @DisplayName("2개 이하의 번호를 맞추면 NOTHING이여야 한다.")
    @ValueSource(ints = {0, 1, 2})
    void firstWinner(int match) {
        // given
        WinnerType winner = WinnerType.of(match);

        // then
        assertThat(winner).isEqualTo(WinnerType.NOTHING);
    }

    @Test
    @DisplayName("각 등수별로 당첨 메세지를 출력할 수 있다.")
    void winnerMessage() {
        // given
        WinnerType firstWinner = WinnerType.FIRST;
        WinnerType secondWinner = WinnerType.SECOND;
        WinnerType thirdWinner = WinnerType.THIRD;
        WinnerType fourthWinner = WinnerType.FOURTH;
        WinnerType fifthWinner = WinnerType.FIFTH;

        // when
        String expectedFirstMessage = "6개 일치 (2,000,000,000원) - ";
        String expectedSecondMessage = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        String expectedThirdMessage = "5개 일치 (1,500,000원) - ";
        String expectedFourthMessage = "4개 일치 (50,000원) - ";
        String expectedFifthMessage = "3개 일치 (5,000원) - ";

        // then
        assertAll(
                () -> assertThat(firstWinner.message()).isEqualTo(expectedFirstMessage),
                () -> assertThat(secondWinner.message()).isEqualTo(expectedSecondMessage),
                () -> assertThat(thirdWinner.message()).isEqualTo(expectedThirdMessage),
                () -> assertThat(fourthWinner.message()).isEqualTo(expectedFourthMessage),
                () -> assertThat(fifthWinner.message()).isEqualTo(expectedFifthMessage)
        );
    }
}
