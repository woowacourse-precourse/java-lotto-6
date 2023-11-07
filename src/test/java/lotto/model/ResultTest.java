package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("일치하는 숫자가 3개일 경우 결과값 반환 테스트")
    @Test
    void getResultOfSame3Test() {
        assertThat(Result.getResult(3))
                .isEqualTo(Result.SAME3);
    }

    @DisplayName("일치하는 숫자가 4개일 경우 결과값 반환 테스트")
    @Test
    void getResultOfSame4Test() {
        assertThat(Result.getResult(4))
                .isEqualTo(Result.SAME4);
    }

    @DisplayName("일치하는 숫자가 5개일 경우 결과값 반환 테스트")
    @Test
    void getResultOfSame5Test() {
        assertThat(Result.getResult(5))
                .isEqualTo(Result.SAME5);
    }

    @DisplayName("일치하는 숫자가 5개이고 보너스 숫지를 포함한 경우 결과값 반환 테스트")
    @Test
    void getResultOfSame5BonusTest() {
        assertThat(Result.getResult(5.5))
                .isEqualTo(Result.SAME5_BONUS);
    }

    @DisplayName("일치하는 숫자가 6개일 경우 결과값 반환 테스트")
    @Test
    void getResultOfSame6Test() {
        assertThat(Result.getResult(6))
                .isEqualTo(Result.SAME6);
    }
}
