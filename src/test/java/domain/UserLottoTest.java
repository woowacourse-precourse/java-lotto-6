package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottoTest {

    private UserLotto userLotto;

    @DisplayName("구입 금액이 유효성 검사를 통과할 경우 구입 금액을 포함한 UserLotto 객체를 반환한다")
    @Test
    void createUserLottoWithAmountTest() {
        //given
        String amount = "8000";

        //when
        userLotto = new UserLotto(amount);

        //then
        assertThat(userLotto)
                .isNotNull()
                .extracting("amount")
                .isEqualTo(8000);
    }

}
