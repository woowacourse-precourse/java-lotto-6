package lotto.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoesDtoTest {

    private LottoesDto lottoesDto;
    private LottoDto lottoDto;
    private LottoDto lottoDto2;

    @BeforeEach
    void LottoesDto_객체생성() {
        lottoDto = new LottoDto(Arrays.asList(1, 2, 3));
        lottoDto2 = new LottoDto(Arrays.asList(1, 2, 3));
        lottoesDto = new LottoesDto(Arrays.asList(lottoDto, lottoDto2));
    }

    @Test
    void 레코드는_생성자_기능을_자동으로_갖고있다() {
        List<LottoDto> annotherLottoDtoes = Arrays.asList(lottoDto, lottoDto2);
        assertThat(lottoesDto.lottoDtos())
                .isEqualTo(annotherLottoDtoes);
    }

    @Test
    void 현재_본인이_갖고있는_LottoDto의_개수도_반환한다() {
        assertThat(lottoesDto.getLottoCount())
                .isEqualTo(2);
    }
}