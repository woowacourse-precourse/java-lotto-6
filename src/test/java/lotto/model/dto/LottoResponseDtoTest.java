package lotto.model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResponseDtoTest {
    @DisplayName("사용자가 구입한 로또 숫자 리스트의 문자열 변환 테스트한다.")
    @Test
    void createLottoMessage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoResponseDto lottoResponseDto = new LottoResponseDto(numbers);

        String expect = "[1, 2, 3, 4, 5, 6]";
        String actual = lottoResponseDto.createLottoMessage();

        assertThat(actual).isEqualTo(expect);
    }
}