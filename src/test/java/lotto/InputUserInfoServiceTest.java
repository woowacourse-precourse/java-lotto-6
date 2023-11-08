package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.User;
import lotto.service.InputUserInfoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputUserInfoServiceTest {
    private InputUserInfoService inputUserInfoService = new InputUserInfoService();

    @DisplayName("구매금액 반환 테스트")
    @Test
    public void getBuyingPriceTest() {
        // given
        int buyingPrice = 10000;
        User user = new User(buyingPrice);

        // when
        int result = inputUserInfoService.getBuyingPrice(user);

        // then
        assertThat(result).isEqualTo(buyingPrice);
    }

    @DisplayName("로또 구매 테스트")
    @Test
    public void setUserLottoTest() {
        // given
        User user = new User(10000);

        // when
        inputUserInfoService.setUserLottos(user);

        // then
        assertThat(user.getLottos().size()).isEqualTo(10);
    }
}
