package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.dto.WinningNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    private final LottoController lottoController = new LottoController();

    @DisplayName("정확히 6개의 숫자를 콤마로 구분해서 입력했을 때")
    @Test
    void post1stNumberTest() {
        // given
        String input = "21,15,1,24,35,3";

        // when
        try {
            WinningNumberDto dto = lottoController.post1stNumber(input);
            // then
            assertThat(dto.winningNumber().getNormalNumbers().containsAll(List.of(21, 15, 1, 24, 35, 3)));

        } catch (Exception e) {}

    }

    @DisplayName("보너스 번호 입력 정상 테스트")
    @Test
    void postBonusNumTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 5, 11, 12, 43));
        WinningNumber winningNumber = new WinningNumber(lotto);
        String input = "21";

        // when
        try {
            WinningNumberDto dto = lottoController.postBonusNumber(new WinningNumberDto(winningNumber), input);

            // then
            assertThat(dto.winningNumber().getBonusNumber()).isEqualTo(Integer.parseInt(input));

        } catch (Exception e) {}

    }
}