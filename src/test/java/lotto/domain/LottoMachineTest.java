package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @DisplayName("랜덤 로또번호 생성 성공")
    @Test
    void createRandomLottoNumbers() {
        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = new Lotto(lottoMachine.getNumbers());

        Assertions.assertThat(lotto.getLotto()).isEqualTo(lottoMachine.getNumbers());

    }
}