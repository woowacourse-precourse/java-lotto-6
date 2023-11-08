package lotto.module.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserLottoTicketTest {

    @Test
    void 유저_로또_티켓_생성_성공_테스트() {
        // given
        UserLottoTicket userLottoTicket = UserLottoTicket.newInstance(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectedCount = 6;

        // when
        int count = userLottoTicket.getIncludedNumbersCount(lotto);

        // then
        Assertions.assertThat(count)
                .isEqualTo(expectedCount);
    }

}