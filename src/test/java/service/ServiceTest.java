package service;

import domain.Lotto;
import domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceTest {
    Service service = new Service();
    @DisplayName("입력을 유효성 검사 후 정수형의 돈으로 반환해준다.")
    @Test
    void getMoneyByUserInput() {
        assertThat(service.getMoneyByUserInput("10000")).isEqualTo(10000);
    }

}
