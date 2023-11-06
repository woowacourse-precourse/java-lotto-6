package lotto.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoDtoTest {
    @Test
    void LottoDto는_생성자_기능을_담고있다() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        LottoDto lottoDto = new LottoDto(list);

        List<Integer> sameElements = Arrays.asList(1, 2, 3);
        assertThat(lottoDto.numbers())
                .isEqualTo(sameElements);
    }
}