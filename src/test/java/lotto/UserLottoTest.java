package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottoTest {
    private UserLotto userLotto;

    @BeforeEach
    public void setUp() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        userLotto = new UserLotto(List.of(lotto1, lotto2));
    }

    @DisplayName("UserLotto 객체가 정상적으로 생성되는지 테스트")
    @Test
    public void createUserLotto() {
        List<Lotto> lottos = userLotto.getUserLotto();
        assertEquals(2, lottos.size());
        assertThat(lottos.get(0).getLotto()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lottos.get(1).getLotto()).containsExactly(40, 41, 42, 43, 44, 45);
    }
}
