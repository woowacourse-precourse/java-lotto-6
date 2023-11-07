package lotto.collaboration.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningLottoMessageTest {

    @Test
    void get으로_메시지조회가능하다() {
        String expected = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";

        String actual = WinningLottoMessage.EXCEPTION_DUPLICATED.get();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}