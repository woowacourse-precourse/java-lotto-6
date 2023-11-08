package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class UserLottoTest {
    @Test
    @DisplayName("로또 개수를 입력하면, 정상적으로 랜덤한 로또 번호 객체 UserLotto 를 리턴")
    void testMakeRandomLotto() {
        // given
        int cnt = 1;
        UserLotto userLotto;

        // when
        try (final MockedStatic<Randoms> randomMock = mockStatic(Randoms.class)) {
            randomMock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt())).thenReturn(List.of(1, 2, 3, 4, 5, 6));
            userLotto = UserLotto.makeRandomLotto(cnt);
        }

        // then
        assertThat(userLotto.getLottoTickets()).usingRecursiveComparison().isEqualTo(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }

}