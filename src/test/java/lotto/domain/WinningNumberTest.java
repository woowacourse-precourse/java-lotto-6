package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("보너스번호와 당첨번호가 일치하면 예외발생")
    @Test
    void testWinningNumberCreationWithDuplicateBonusNumber(){
        List<LottoNumber> list = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .toList();
        assertThatThrownBy(() -> new WinningNumber(list, new LottoNumber(1))).isInstanceOf(IllegalArgumentException.class);
    }

}