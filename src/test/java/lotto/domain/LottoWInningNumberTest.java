package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoWInningNumberTest {

    @DisplayName("로또 번호를 입력했을 경우에 정상적으로 로또 번호가 들어왔는지 체크")
    @Test
    void purchaseLottoCorrect() {
        //given
        final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        final String lottoNumber = "2,5,8,12,16,25";

        //when
        final List<Integer> lottoNumbers = List.of(2, 5, 8, 12, 16, 25);

        //then
        assertThat(lottoWinningNumber.lottoWinningNumber(lottoNumber)).isEqualTo(lottoNumbers);
    }

}
