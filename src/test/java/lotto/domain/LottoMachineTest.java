package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @DisplayName("랝덤 로또 번호 생성 - Lotto를 통해 유효성 검사 시 예외 발생하지 않음")
    @Test
    void createRandomLottoNumbers(){
        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = new Lotto(lottoMachine.getRandomNumbers());

        assertThat(lotto.getNumbers()).isEqualTo(lottoMachine.getRandomNumbers());
    }

}