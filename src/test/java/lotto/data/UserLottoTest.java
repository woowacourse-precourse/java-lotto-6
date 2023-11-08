package lotto.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserLottoTest {
    private Lotto systemLotto;

    @BeforeEach
    void init() {
        systemLotto = new Lotto(List.of(1, 10, 11, 12, 13, 14));
    }

    @Test
    void 숫자_비교_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        UserLotto userLotto = new UserLotto(lotto);

        userLotto.compareNumber(systemLotto);

        assertThat(userLotto.getCorrectCnt()).isEqualTo(1);
    }

    @Test
    void 보너스_번호_테스트() {
        int bonusNumber = 2;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        UserLotto userLotto = new UserLotto(lotto);

        userLotto.compareBonus(bonusNumber);

        assertThat(userLotto.getCorrectCnt()).isEqualTo(1);
    }

    @Test
    void 로또_2등_테스트() {
        int bonusNumber = 2;
        Lotto lotto = new Lotto(List.of(1, 2, 11, 12, 13, 14));
        UserLotto userLotto = new UserLotto(lotto);

        userLotto.compareNumber(systemLotto);
        userLotto.compareBonus(bonusNumber);

        assertThat(userLotto.getCorrectCnt()).isEqualTo(5);
        assertThat(userLotto.getBonusCnt()).isEqualTo(1);
    }
}
