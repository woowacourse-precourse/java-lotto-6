package lotto.dto.input.builder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.input.WinningCombinationDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningCombinationBuilderTest {

    @DisplayName("WinningCombinationBuilder로 WinningCombinationDto 생성")
    @Test
    void should_Build_WinningCombinationDto() {
        // given
        // when
        WinningCombinationDto winningCombinationDto = WinningCombinationBuilder.builder()
                .withWinningNumbers("1,2,3,4,5,6")
                .withBonusNumber("7")
                .build();

        // then
        assertThat(winningCombinationDto.winningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningCombinationDto.bonusNumber()).isEqualTo(7);
    }

    @DisplayName("누락된 필드가 있는 경우 예외 발생")
    @Test
    void should_Throw_Exception_When_Missing_Fields() {
        // when
        // then
        assertThatThrownBy(() -> WinningCombinationBuilder.builder()
                .withWinningNumbers("1,2,3,4,5,6")
                .build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호 또는 보너스 번호가 설정되지 않았습니다.");

        assertThatThrownBy(() -> WinningCombinationBuilder.builder()
                .withBonusNumber("7")
                .build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호 또는 보너스 번호가 설정되지 않았습니다.");
    }

    @DisplayName("보너스 번호가 당첨번호와 중복된 경우 예외 발생")
    @Test
    void should_Throw_Exception_When_Bonus_Contains_WinningNumbers() {
        // when
        // then
        assertThatThrownBy(() -> WinningCombinationBuilder.builder()
                .withWinningNumbers("1,2,3,4,5,6")
                .withBonusNumber("6")
                .build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호가 당첨 번호와 중복될 수 없습니다.");
    }
}