package lotto.controller;

import lotto.AppConfig;
import lotto.message.ErrorMessage;
import lotto.model.GameMoney;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetGameMoneyTest {

    AppConfig appConfig = new AppConfig();
    GetBuyNumber getBuyNumber = appConfig.getBuyNumber();


    @Test
    void 알맞은_가격_입력() {
        GameMoney gameMoney = getBuyNumber.getValid("8000");
        Assertions.assertThat(gameMoney.getGameCount()).isEqualTo(8);
        GameMoney gameMoney2 = getBuyNumber.getValid("15000");
        Assertions.assertThat(gameMoney2.getGameCount()).isEqualTo(15);
    }

    @Test
    void 음수_입력() {
        Assertions.assertThatThrownBy(() -> getBuyNumber.getValid("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_NATURAL_NUM.toString());
    }

    @Test
    void 영_입력() {
        Assertions.assertThatThrownBy(() -> getBuyNumber.getValid("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_NATURAL_NUM.toString());
    }

    @Test
    void 정수가_아닌_입력() {
        Assertions.assertThatThrownBy(() -> getBuyNumber.getValid("테스트"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_NUMBER.toString());
        Assertions.assertThatThrownBy(() -> getBuyNumber.getValid("1000.0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_NUMBER.toString());
    }

    @Test
    void 천원_단위가_아닌_입력() {
        Assertions.assertThatThrownBy(() -> getBuyNumber.getValid("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_THOUSANDS_UNIT.toString());
    }

}
