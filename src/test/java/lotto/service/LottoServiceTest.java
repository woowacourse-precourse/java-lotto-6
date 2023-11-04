package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.Lotto;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("구입 금액만큼 로또가 생성되는지 검사한다.")
    public void 로또_구매() throws Exception {
        //given
        User user = new User("10000");

        //when
        List<Lotto> purchasedLotto = LottoService.lottoGenerator(user.getAmount());

        //then
        //purchasedLotto.getPurchasedLotto().size();
        assertEquals(10, purchasedLotto.size());
    }
}
