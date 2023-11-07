package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserLottoTest {
    Lotto mainLotto;
    BonusLotto bonusLotto;

    @BeforeEach
    void setUp() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        mainLotto = new Lotto(lottoNumbers);

        bonusLotto = new BonusLotto(1);
    }

    @Test
    void 중복된_번호를_입력_받았을_떄_예외_처리() {
        assertThatThrownBy(() -> new UserLotto(mainLotto, bonusLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}