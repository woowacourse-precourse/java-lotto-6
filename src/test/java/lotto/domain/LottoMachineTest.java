package lotto.domain;

import lotto.numbermaker.ExpectedNumberMaker;
import lotto.numbermaker.NumberMaker;
import lotto.numbermaker.RandomNumberMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    LottoMachine lottoMachine;
    NumberMaker numberMaker;

    @BeforeEach
    void create() {
        numberMaker = new RandomNumberMaker();
        lottoMachine = new LottoMachine(numberMaker);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "8000:8", "1000:1"}, delimiter = ':')
    @DisplayName("입력받은 금액에 맞는 갯수의 lotto 티켓을 발행한다.")
    void buyLotto(Integer amount, Integer expectLottoCount) {
        // given
        Money money = new Money(amount);

        // when
        List<Lotto> lottoBundle = lottoMachine.buyLotto(money);

        // then
        assertThat(lottoBundle.size()).isEqualTo(expectLottoCount);
    }

    @Test
    @DisplayName("범위 밖의 숫자를 가진 로또를 생성하면 Lotto 생성 과정에서 예외가 발생한다.")
    void issueLotto_outOfRange() {
        // given
        numberMaker = new ExpectedNumberMaker(List.of(1,2,3,4,5,49), 6);
        lottoMachine = new LottoMachine(numberMaker);
        Money money = new Money(1000);

        // when & then
        assertThatThrownBy(() -> lottoMachine.buyLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("중복된 숫자를 생성하면 Lotto생성 과정에서 예외가 발생한다.")
    void issueLotto_duplicate() {
        // given
        numberMaker = new ExpectedNumberMaker(List.of(1,2,3,4,5,6,6), 7);
        lottoMachine = new LottoMachine(numberMaker);
        Money money = new Money(1000);

        // when & then
        assertThatThrownBy(() -> lottoMachine.buyLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}