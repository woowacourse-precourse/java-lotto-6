package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {


    @DisplayName("생성 테스트")
    @Test
    void create() {
        LottoMachine machine = LottoMachine.from(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("알 수 없는 로또 생성기로 로또 기계를 생성할 수 없다.")
    @Test
    void checkFactoryNonNull() {
        assertThatThrownBy(() -> LottoMachine.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 로또 생성기로 로또 기계를 생성할 수 없습니다.");
    }
}
