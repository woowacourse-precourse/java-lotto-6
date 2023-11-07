package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoWInningNumberTest {

    @DisplayName("로또 번호를 입력했을 경우에 정상적으로 로또 번호가 들어왔는지 체크")
    @Test
    void winningNumberLottoCorrect() {
        //given
        final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        final String lottoNumber = "2,5,8,12,16,25";

        //when
        final List<Integer> lottoNumbers = List.of(2, 5, 8, 12, 16, 25);

        //then
        assertThat(lottoWinningNumber.lottoWinningNumber(lottoNumber)).isEqualTo(lottoNumbers);
    }

    @DisplayName("보너스 번호가 로또 당첨 번호와 중복되지 않게 들어왔는지 체크")
    @Test
    void bonusNumberLottoCorrect() {
        //given
        final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        final List<Integer> lottoNumbers = List.of(2, 5, 8, 12, 16, 25);
        final String bonus = "18";

        //when
        final int bonusNumber = lottoWinningNumber.lottoBonusNumber(bonus, lottoNumbers);

        //then
        for (int number : lottoNumbers) {
            assertThat(number).isNotEqualTo(bonusNumber);
        }

    }

}
