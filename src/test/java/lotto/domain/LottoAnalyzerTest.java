package lotto.domain;

import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoAnalyzerTest {
    private LottoAnalyzer lottoAnalyzer;

    @BeforeEach
    void init() {
        List<Lotto> lottos = new ArrayList<>();
        lottoAnalyzer = new LottoAnalyzer(lottos);
    }

    @DisplayName("당첨 번호에 중복된 보너스 숫자를 입력한 경우 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonus = 5;

        //when
        lottoAnalyzer.addWinningNumbers(winningNumbers);

        //then
        assertThatThrownBy(() -> lottoAnalyzer.addBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_WINNING_NUMBER);
    }
}