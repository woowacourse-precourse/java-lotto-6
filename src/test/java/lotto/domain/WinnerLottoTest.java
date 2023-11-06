package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerLottoTest {

    @Test
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

}
