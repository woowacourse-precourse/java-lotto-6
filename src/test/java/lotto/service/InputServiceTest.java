package lotto.service;

import static lotto.service.InputService.winningNumberList;
import static lotto.view.InputView.winningNumber;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputServiceTest {
    @Test
    @DisplayName("String 형 리스트를 int 형 리스트로 변환")
    void validateTransformWinningNumber() {
        // given
        winningNumber = "1,2,3,4,5,6";
        winningNumberList = new ArrayList<>();

        // when
        InputService.transformWinningNumber();

        // then
        assertThat(winningNumberList).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
