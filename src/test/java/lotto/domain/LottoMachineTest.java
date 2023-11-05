package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;


class LottoMachineTest {

    @ParameterizedTest
    @CsvSource({"5,5", "10,10", "0,0"})
    @DisplayName("로또 생성개수 확인")
    void createLotto(int amount, int expected) {
        //given
        LottoMachine lottoMachine = new LottoMachine(amount);

        //when
        List<Lotto> lottoPapers = lottoMachine.getLottoPapers();

        //then
        Assertions.assertThat(lottoPapers.size()).isEqualTo(expected);
    }
}