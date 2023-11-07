package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @DisplayName("구입 금액과 로또 티켓으로 유저를 생성한다.")
    @Test
    void createUserTest() {
        Money money = new Money(5000);
        LottoTicket lottoTicket = new LottoTicket(5);
        User user = new User(money, lottoTicket);

        assertThat(user.getBuyAmount()).isEqualTo(money);
        assertThat(user.getLottoTicket()).isEqualTo(lottoTicket.getLottoTicket());
    }
}