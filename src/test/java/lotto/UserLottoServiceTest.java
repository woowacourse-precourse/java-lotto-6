package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.User;
import lotto.domain.UserLotto;
import lotto.service.UserLottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottoServiceTest {
    private UserLottoService userInputDataService = new UserLottoService();

    @DisplayName("구매금액 반환 테스트")
    @Test
    public void getBuyingPriceTest() {
        // given
        int buyingPrice = 10000;
        User user = new User(buyingPrice);

        // when
        int result = userInputDataService.getPrice(user);

        // then
        assertThat(result).isEqualTo(buyingPrice);
    }

    @DisplayName("로또 구매 테스트")
    @Test
    public void setUserLottoTest() {
        // given
        User user = new User(10000);

        // when
        userInputDataService.setUserLotto(user);

        // then
        assertThat(user.getLottos().size()).isEqualTo(10);
    }
}