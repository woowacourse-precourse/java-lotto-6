package lotto.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.MockNumberGenerator;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottoTest {
    @DisplayName("UserLotto에 발행된 로또들이 저장되는지 확인한다.")
    @Test
    void createUserLotto() {
        LottoCount lottoCount = new LottoCount(3000);
        UserLotto userLotto = new UserLotto(lottoCount);
        MockNumberGenerator mockNumberGenerator = new MockNumberGenerator();

        Lotto lotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));

        //when
        userLotto.create(mockNumberGenerator);

        //then
        assertThat(userLotto.getLottos().get(0)).usingRecursiveComparison().isEqualTo(lotto);
        assertThat(userLotto.getLottos().get(1)).usingRecursiveComparison().isEqualTo(lotto);
    }
}
