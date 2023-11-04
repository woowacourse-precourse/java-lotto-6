package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TddTest {

    @Test
    public void 로또는_한장에_천원() {
        Lottos lottos = new Lottos();
        int lottoCount = lottos.calculateLottoCount(8000);

        assertThat(lottoCount).isEqualTo(8);
    }

    @Test
    public void 로또_구매입력이_1000원_단위가_아닐때() {
        Lottos lottos = new Lottos();

        int money = 1500;
        assertThatThrownBy(() -> {
            lottos.calculateLottoCount(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 1000원 단위만 구매할 수 있습니다.");
    }
}
