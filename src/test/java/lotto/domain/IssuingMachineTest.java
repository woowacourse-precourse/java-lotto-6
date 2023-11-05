package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class IssuingMachineTest {

    @Test
    @DisplayName("입력한 금액에 따라 발급 횟수가 정해진다.")
    void 발급_횟수() {
        //given
        IssuingMachine issuingMachine = IssuingMachine.turnOn(14000);

        //when
        int count = issuingMachine.calculateCount();

        //then
        Assertions.assertThat(count).isEqualTo(14);
    }

    @Test
    @DisplayName("중복되지 않는 6자리의 번호를 갖는 로또를 만들어낸다.")
    void 로또_생성() {
        //given
        IssuingMachine issuingMachine = IssuingMachine.turnOn(1000);
        Lotto lotto = issuingMachine.createLotto();

        //when
        boolean hasDuplicate = lotto.getNumbers().stream()
                .anyMatch(e -> Collections.frequency(lotto.getNumbers(), e) > 1);
        int size = lotto.getNumbers().size();

        //then
        Assertions.assertThat(hasDuplicate).isEqualTo(false);
        Assertions.assertThat(size).isEqualTo(6);
    }

    @Test
    @DisplayName("입력된 금액만큼 로또를 발급해야한다.")
    void 로또_생성_횟수() {
        //given
        IssuingMachine issuingMachine = IssuingMachine.turnOn(10000);

        //then
        issuingMachine.operate();
        int size = issuingMachine.issueLotto().size();

        //then
        Assertions.assertThat(size).isEqualTo(10);
    }
}