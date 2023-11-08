package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.ConstantNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class SiteUserTest {
    @Test
    @DisplayName("조건에 충족한 금액 입력 시, 유저의 사용한 금액과 랜덤하게 만들어진 로또 번호들, 구매한 로또 개수를 필드로 가진 SiteUser 객체 리턴")
    void testCreateSiteUser() {
        // given
        int money = ConstantNum.PER_PRICE.getNum();
        int cnt = money / ConstantNum.PER_PRICE.getNum();
        SiteUser testUser;

        // when
        try (final MockedStatic<Randoms> randomMock = mockStatic(Randoms.class)) {
            randomMock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt())).thenReturn(List.of(1, 2, 3, 4, 5, 6));
            testUser = SiteUser.createSiteUser(money);
        }

        // then
        assertThat(testUser.getUserMoney().getMoney()).isEqualTo(UserMoney.createMoney(money).getMoney());
        assertThat(testUser.getLottoCnt()).isEqualTo(cnt);
        assertThat(testUser.getUserLotto().getLottoTickets()).usingRecursiveComparison().isEqualTo(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }

}