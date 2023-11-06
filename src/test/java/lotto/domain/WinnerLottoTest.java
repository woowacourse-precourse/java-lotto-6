package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerLottoTest {

    @Test
    @DisplayName("로또번호와 중복된 보너스 숫자 입력시 에러를 생성한다.")
    public void createWinnerLottoByBounusNumberContainLottoNumber() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7)
        );

        assertThatThrownBy(() ->
                        new WinnerLotto(new Lotto(lottoNumbers),new LottoNumber(7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개 모두 존재한다면 Rank이늄의 SIX를 반환한다.")
    void allItemIsSameThenReturnSIX() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7)
        );

        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(lottoNumbers), new LottoNumber(8));

        assertThat(winnerLotto.calcRank(new Lotto(lottoNumbers))).isNotEmpty().contains(Rank.SIX);
    }
}
