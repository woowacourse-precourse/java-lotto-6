package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Money;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @DisplayName("5천원일 경우 로또 5개를 발행한다.")
    @Test
    void makeFiveWithFiveThousand() {
        //given
        Money fiveThousand = new Money(5_000);
        LottoMachine lottoMachine = new LottoMachine();

        //when
        List<List<Integer>> lottoNumbers = lottoMachine.generateLotto(fiveThousand);

        //then
        assertThat(lottoNumbers).hasSize(5);
    }
}
