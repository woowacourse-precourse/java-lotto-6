package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersDtoTest {

    @Test
    @DisplayName("불변 리스트 반환 확인")
    void givenLottoNumbersDto_whenGetLottosNumbers_thenThrowExceptionInAdd() {
        // given
        LottoNumbersDto lottoNumbersDto = new LottoNumbersDto(List.of(List.of(1, 2, 3, 4, 5, 6)));

        // when
        List<List<Integer>> result = lottoNumbersDto.getLottosNumbers();

        // then
        assertThatThrownBy(() -> result.add(List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

}
