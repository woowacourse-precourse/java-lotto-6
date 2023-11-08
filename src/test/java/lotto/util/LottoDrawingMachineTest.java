package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.PlayerBuyPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDrawingMachineTest {

    @DisplayName("validateDuplicationNumbers() : 당첨 번호와 중복으로 사용될 수 없다.")
    @Test
    void validateDuplicationNumbers_Fail() throws Exception{
        //given
        String exceptionMessage = "[ERROR] 보너스 번호는 당첨 번호와 중복으로 사용할 수 없습니다.";
        Lotto lottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBall lottoBall = new LottoBall("6");

        //when //then
        assertThatThrownBy(() -> new LottoDrawingMachine(lottoNumber, lottoBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);

    }
}