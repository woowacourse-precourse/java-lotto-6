package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.dto.*;
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
        Lotto[] lottos = lottosDto.lottos();

        // then
        assertThat(lottos.length).isEqualTo(numberOfLottos);
    }

    @DisplayName("6개의 일반 당첨 번호 등록 메소드 확인")
    @Test
    void postNormalNumTest() {
        // given
        NumbersDto numbersDto = new NumbersDto(List.of(1, 2, 5, 11, 12, 43));

        // when
        WinningNumberDto dto = lottoService.postNormalNumbers(numbersDto);

        // then
        WinningNumber winningNumber = dto.winningNumber();
        assertThat(winningNumber.getNormalNumbers().containsAll(List.of(1, 2, 5, 11, 12, 43)));

    }

    @DisplayName("5개의 일반 당첨 번호 등록 메소드 예외 확인")
    @Test
    void postNormalBy5num() {
        // given
        NumbersDto numbersDto = new NumbersDto(List.of(1, 2, 5, 11, 12));

        // then
        assertThatThrownBy(() -> lottoService.postNormalNumbers(numbersDto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복되지 않는 보너스 숫자 추가")
    @Test
    void postBonusNumTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 5, 11, 12, 43));
        WinningNumber winningNumber = new WinningNumber(lotto);
        int bonusNum = 7;

        // when
        WinningNumberDto dto = lottoService.postBonusNumber(new WinningNumberDto(winningNumber), bonusNum);

        // then
        assertThat(dto.winningNumber().getBonusNumber()).isEqualTo(bonusNum);
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호를 입력한 경우")
    @Test
    void postSameBonusNumTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 5, 11, 12, 43));
        WinningNumber winningNumber = new WinningNumber(lotto);
        int bonusNum = 5;

        // then
        assertThatThrownBy(() -> lottoService.postBonusNumber(new WinningNumberDto(winningNumber), bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("등수 계산 테스트")
    @Test
    void judgeRanksTest() {
        // given
        Lotto[] lottos = new Lotto[3];
        lottos[0] = new Lotto(List.of(1, 2, 5, 11, 12, 43)); // 1st
        lottos[1] = new Lotto(List.of(1, 2, 5, 11, 12, 45)); // 3rd
        lottos[2] = new Lotto(List.of(1, 2, 5, 11, 12, 15)); // 2nd

        LottosDto lottosDto = new LottosDto(lottos);

        Lotto winning = new Lotto(List.of(1, 2, 5, 11, 12, 43));
        int bonusNum = 15;
        WinningNumber winningNumber = new WinningNumber(winning);
        winningNumber.addBonusNumber(bonusNum);
        WinningNumberDto winningNumberDto = new WinningNumberDto(winningNumber);

        // when
        RanksDto dto = lottoService.judgeRanks(winningNumberDto, lottosDto);

        // then
        int[] ranks = dto.ranks();
        assertThat(ranks[0]).isEqualTo(1);
        assertThat(ranks[1]).isEqualTo(1);
        assertThat(ranks[2]).isEqualTo(1);
        assertThat(ranks[3]).isEqualTo(0);
        assertThat(ranks[4]).isEqualTo(0);
    }
}