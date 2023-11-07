package domain;

import lotto.domin.PlayerLottoAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PlayerLottoAmountTest {


    @Test
    @DisplayName("로또 구입 금액 계산 한글로 계산")
    public void validateNumberTest() {
        String pay = "일이";
        PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount();
        assertThatThrownBy(() -> playerLottoAmount.validateNumber(pay))
                .isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    @DisplayName("로또 구입 금액 0이하 계산일 경우")
    public void validateNumberZeroTest() {
        int pay = -1;
        PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount();
        assertThatThrownBy(() -> playerLottoAmount.validateNumberZero(pay))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("로또 구입 금액 1000단위로 나누어 떨어지지 않을 경우")
    public void validateDivisibleTest() {
        int pay = 100001;
        PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount();
        assertThatThrownBy(() -> playerLottoAmount.validateDivisible(pay))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 금액으로 유효성 검사")
    public void PlayerLottoAmountTest() {
        String pay = "140000";
        PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount(pay);
        Assertions.assertThat(140000).isEqualTo(playerLottoAmount.getAmount());
    }




}