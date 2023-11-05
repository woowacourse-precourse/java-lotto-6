package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssuingMachineTest {

    @Test
    @DisplayName("입력한 금액에 따라 발급 횟수가 정해진다.")
    void 발급_횟수(){
        //given
        IssuingMachine issuingMachine=IssuingMachine.turnOn(14000);

        //when
        int count=issuingMachine.calculateCount();

        //then
        Assertions.assertThat(count).isEqualTo(14);
    }
}