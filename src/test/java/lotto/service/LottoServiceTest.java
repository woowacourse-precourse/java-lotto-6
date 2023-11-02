package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottosDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("여러 개의 로또 생성 메소드 확인")
    @Test
    void generateLottosByNum() {
        // given
        int numberOfLottos = 10;
        LottoNumberDto dto = new LottoNumberDto(numberOfLottos);

        // when
        LottosDto lottosDto = lottoService.generateLottos(dto);
        ArrayList<Lotto> lottos = lottosDto.lottos();

        // then
        assertThat(lottos.size()).isEqualTo(numberOfLottos);
    }
}