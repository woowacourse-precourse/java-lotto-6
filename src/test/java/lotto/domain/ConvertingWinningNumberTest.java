package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class ConvertingWinningNumberTest {

    @Test
    @DisplayName("당첨 번호 문자열을 정수 리스트로 변환해야 함")
    void convertWinningNumber() {
        ConvertingWinningNumber converter = new ConvertingWinningNumber();
        String winningNumber = "1, 2, 3, 4, 5, 6";
        List<Integer> convertedNumbers = converter.convertingWinningNumber(winningNumber);
        assertThat(convertedNumbers).isNotNull();
        assertThat(convertedNumbers).hasSize(6);
        assertThat(convertedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
