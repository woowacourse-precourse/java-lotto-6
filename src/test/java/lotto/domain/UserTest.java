package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("구입금액을 입력하면 알맞는 로또개수를 반환한다.")
    @Test
    void 구입금액_입력시_로또개수_반환() {
        // given
        String pay = "7000";

        // when
        User user = new User(pay);

        // then
        assertEquals(7, user.getLottoCnt());
    }
}