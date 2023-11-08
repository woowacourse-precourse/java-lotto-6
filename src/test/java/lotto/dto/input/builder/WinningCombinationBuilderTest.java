package lotto.dto.input.builder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.input.WinningCombinationDto;
import lotto.util.ErrorMessage;
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

    @DisplayName("모든 필드가 설정되지 않으면 생성 시 예외 발생")
    @Test
    void should_Throw_Exception_when_Not_All_Fields_Set() {
        // given
        WinningCombinationBuilder builder1 = WinningCombinationBuilder.builder().withWinningNumbers("1,2,3,4,5,6");
        WinningCombinationBuilder builder2 = WinningCombinationBuilder.builder().withBonusNumber("7");

        // when
        // then
        assertThatThrownBy(builder1::build)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_SET_ALL_FIELDS_NUMBERS.get());

        assertThatThrownBy(builder2::build)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_SET_ALL_FIELDS_NUMBERS.get());
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
                .hasMessageContaining(ErrorMessage.DUPLICATE_WINNING_NUMBERS_AND_BONUS_NUMBER.get());
    }
}