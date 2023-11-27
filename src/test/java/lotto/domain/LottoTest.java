package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void matchbonus() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        boolean result = userLotto.contains(new LottoNumber(6));
        assertThat(result).isTrue();
    }

    @Test
    void match() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = userLotto.numberOfMatches(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(result).isEqualTo(6);
    }

    @Test
    void create() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void invalid1() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid2() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid3() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(0, 2, 3, 4, 5, 6));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid4() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46));
        }).isInstanceOf(IllegalArgumentException.class);
    }

}