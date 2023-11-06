package lotto.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.UserLottoService;


public class UserTest {
    @Test
    @DisplayName("로또 구매 금액이 12000원이라면 생성된 로또의 수는 12개여야한다")
    void lottoCountTest() {
        //given
        User user;
        int amount = 12;
        //when
        user = UserLottoService.lottoSetting(12);
        //then
        List<Lotto> lottos = user.getLottos();
        assertThat(lottos).hasSize(12);
    }
}
