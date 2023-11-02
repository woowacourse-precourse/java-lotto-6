package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottosDto;
import lotto.dto.NumbersDto;
import lotto.dto.WinningNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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

    @DisplayName("6개의 일반 당첨 번호 등록 메소드 확인")
    @Test
    void postNormalNumTest() {
        // given
        NumbersDto numbersDto = new NumbersDto(List.of(1,2,5,11,12,43));

        // when
        WinningNumberDto dto = lottoService.postNormalNumbers(numbersDto);

        // then
        WinningNumber winningNumber = dto.winningNumber();
        assertThat(winningNumber.getNormalNumbers().containsAll(List.of(1,2,5,11,12,43)));

    }

    @DisplayName("5개의 일반 당첨 번호 등록 메소드 예외 확인")
    @Test
    void postNormalBy5num() {
        // given
        NumbersDto numbersDto = new NumbersDto(List.of(1,2,5,11,12));

        // then
        assertThatThrownBy(() -> lottoService.postNormalNumbers(numbersDto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}