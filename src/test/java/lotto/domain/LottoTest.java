package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoTest {
    private static final int LOTTO_FIXED_CIPHERS = 6;
    private static final int START_INCLUSIVE_LOTTO_NUMBER = 1;
    private static final int END_INCLUSIVE_LOTTO_NUMBER = 45;
    private static final String ERROR_CODE = "[ERROR]";

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

    @Test
    void 중복되지_않은_범위_내의_숫자를_로또번호_자릿수만큼_생성자_매개변수에_전달하면_정상_동작() {
        assertThatNoException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또번호_자릿수만큼의_숫자를_생성자_매개변수에_입력하지_않으면_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2)))
                .isExactlyInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_숫자를_생성자_매개변수에_입력하면_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 1, 1, 1, 1)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 정해진_범위_외의_숫자를_생성자_매개변수에_입력하면_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, END_INCLUSIVE_LOTTO_NUMBER + 1)))
                .isExactlyInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(Arrays.asList(START_INCLUSIVE_LOTTO_NUMBER - 1, 2, 3, 4, 5, 6)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 검증에_실패한_경우_모두_에러코드를_포함해서_메시지를_보낸다() {
        // 너무 적은 수를 입력한 경우
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2)))
                .hasMessageContaining(ERROR_CODE);
        // 너무 많은 수를 입력한 경우
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .hasMessageContaining(ERROR_CODE);

        // 중복된 숫자를 입력한 경우
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 1, 1, 1, 1)))
                .hasMessageContaining(ERROR_CODE);

        // 45를 초과한 숫자를 입력한 경우
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, END_INCLUSIVE_LOTTO_NUMBER + 1)))
                .hasMessageContaining(ERROR_CODE);
        // 1 미만의 숫자를 입력한 경우
        assertThatThrownBy(() -> new Lotto(Arrays.asList(START_INCLUSIVE_LOTTO_NUMBER - 1, 2, 3, 4, 5, 6)))
                .hasMessageContaining(ERROR_CODE);
    }
}