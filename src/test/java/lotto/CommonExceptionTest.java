package lotto;

import lotto.domain.Lotto;
import lotto.exception.CommonException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommonExceptionTest {

    @DisplayName("로또 당첨번호와 보너스 번호가 중복되면 예외 발생")
    @Test
    void test1(){
        assertThatThrownBy(() -> CommonException.commonException(List.of(1,2,3,4,5,6), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
