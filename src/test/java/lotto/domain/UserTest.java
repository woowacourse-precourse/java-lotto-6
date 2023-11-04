package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.controller.dto.CreateUserDto;
import lotto.global.ErrorMessage;
import org.junit.jupiter.api.Test;

public class UserTest {
    private static final int LOTTO_UNIT = 1000;
    @Test
    void create_구매_금액이_정상_케이스() {
        //given
        long inputValue = 50000;
        int purchaseAmount = (int) inputValue;
        CreateUserDto createUserDto = new CreateUserDto(inputValue);
        //when
        User user = User.create(createUserDto);
        //then
        assertThat(user.getPurchaseAmount()).isEqualTo(purchaseAmount);
        assertThat(user.getQuantity()).isEqualTo(inputValue/LOTTO_UNIT);
    }

    @Test
    void create_구매_금액이_10만원_이_넘는_경우() {
        //given
        long inputValue = 100001L;
        //when
        assertThatThrownBy(() -> new CreateUserDto(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_MAXIMUM_PURCHASE_AMOUNT.getMessage());

    }

    @Test
    void create_구매_금액이_0_인_경우() {
        //given
        long inputValue = 0;
        //when
        //then
        assertThatThrownBy(() -> new CreateUserDto(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_MINIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void create_구매_금액의_단위가_1000이_아닌_경우() {
        //given
        long inputValue = 500;
        //when
        //then
        assertThatThrownBy(() -> new CreateUserDto(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_PURCHASE_UNIT.getMessage());
    }
}
