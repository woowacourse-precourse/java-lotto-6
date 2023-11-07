package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserLottoTest {

    @DisplayName("사용자 보너스번호가 당첨번호에 중복된 숫자가 존재하는 경우 예외 발생 및 출력메시지")
    @Test
    void createUserLottoBonusDuplicatedNumber(){
        assertThatThrownBy(() ->
                new UserLotto(List.of(1, 2, 3, 4, 5, 6)).addBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 당첨번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createUserLottoByDuplicatedNumber(){
        assertThatThrownBy(() -> new UserLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);

    }

}