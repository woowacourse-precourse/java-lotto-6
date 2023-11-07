package lotto.domain;

import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoAnalyzerTest {

    @DisplayName("당첨 번호에 중복된 보너스 숫자를 입력한 경우 예외가 발생한다.")
    @Test
    void duplicateBonusNumberTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonus = 5;

        assertThatThrownBy(() -> new LottoAnalyzer(winningNumbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_WINNING_NUMBER);
    }

    @DisplayName("로또번호와 당첨번호 간의 일치하는 숫자 갯수 반환 테스트")
    @Test
    void countMatchingNumbersTest() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> lotto = List.of(2, 3, 6, 7, 14, 15, 21);

        //when
        int match = (int) winningNumbers.stream().filter(lotto::contains)
                .distinct()
                .count();

        //then
        assertThat(match).isEqualTo(4);
    }

    @DisplayName("로또 번호에 보너스 번호가 존재 테스트")
    @Test
    void hasBonusNumberTest() {
        //given
        List<Integer> lottoNumbers = List.of(2, 3, 6, 7, 14, 15, 21);
        int bonusNumber = 21;

        //when
        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);

        //then
        assertThat(hasBonusNumber).isEqualTo(true);
    }
}