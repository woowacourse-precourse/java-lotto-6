package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외를 발생한다.")
    @Test
    void validateSize(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    void createMoney_나누어_떨어지지_않는다(){
        assertThatThrownBy(() -> new LottoMoney("83290"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}