package lotto.dto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lotto.dto.input.builder.WinningCombinationBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningCombinationDtoTest {

    @DisplayName("WinningCombinationDto 객체를 생성할 수 있어야 한다")
    @Test
    public void should_Create_WinningCombinationDto() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        WinningCombinationDto winningCombinationDto = new WinningCombinationDto(winningNumbers, bonusNumber);

        // then
        assertNotNull(winningCombinationDto);
        assertEquals(winningNumbers, winningCombinationDto.winningNumbers());
        assertEquals(bonusNumber, winningCombinationDto.bonusNumber());
    }

    @DisplayName("WinningCombinationDto 객체의 builder 메소드로 생성할 수 있어야 한다")
    @Test
    public void should_Create_WinningCombinationDto_With_Builder() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        WinningCombinationDto winningCombinationDto = WinningCombinationBuilder.builder()
                .withWinningNumbers("1,2,3,4,5,6")
                .withBonusNumber("7")
                .build();

        // then
        assertNotNull(winningCombinationDto);
        assertEquals(winningNumbers, winningCombinationDto.winningNumbers());
        assertEquals(bonusNumber, winningCombinationDto.bonusNumber());
    }

    @DisplayName("WinningCombinationDto Builder로 객체를 생성 시 필드가 설정되지 않았을 때 예외 발생")
    @Test
    public void should_Throw_Exception_When_Creating_WinningCombinationDto_With_IncompleteData() {
        assertThatThrownBy(() -> WinningCombinationDto.builder().winningNumbers());
    }
}