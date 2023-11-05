package lotto;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lottos;
import lotto.view.LottoView;
import org.junit.jupiter.api.Test;

public class MyLottoTest {

    @Test
    void 금액_입력시_로또_번호_발행() {
        String numberStr = "10000";
        LottoView lottoView = new LottoView();

        lottoView.lottoPay(numberStr);
    }

    @Test
    void 숫자가_아닌_것_예외처리(){
        String numberStr = "ㅂㅈㄷ";

        assertThatThrownBy(() -> new Lottos(numberStr))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 천_미만의_수_예외처리(){
        String numberStr = "900";

        assertThatThrownBy(() -> new Lottos(numberStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 백원단위가_있을_때_예외처리(){
        String numberStr = "11900";

        assertThatThrownBy(() -> new Lottos(numberStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
