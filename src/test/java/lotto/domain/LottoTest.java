package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private static final int LOTTO_FIXED_CIPHERS = 6;

    @Test
    void Lotto_도메인은_생성과_동시에_로또_번호를_생성한다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers().size())
                .isEqualTo(LOTTO_FIXED_CIPHERS);
    }

    @Test
    void Lotto_도메인이_갖고있는_번호는_중복되지_않는다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers())
                .doesNotHaveDuplicates();
    }

    @Test
    void Lotto_도메인은_생성과_동시에_번호를_오름차순으로_정렬한다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers())
                .isSorted();
    }
}