package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @DisplayName("클래스 변수에 올바른 값이 들어오는지 확인")
    @Test
    void getFirstPlaceCount() {
        WinningResult winningResult = new WinningResult(List.of(1,2,3,4,5));
        assertThat(winningResult.getFifthPlaceCount()).isEqualTo(5);
    }

}