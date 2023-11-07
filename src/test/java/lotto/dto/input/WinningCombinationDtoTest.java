package lotto.dto.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningCombinationDtoTest {

    @DisplayName("WinningCombinationDto 객체를 생성할 수 있어야 한다.")
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
}