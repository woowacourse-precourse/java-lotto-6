package lotto;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("구입한 개수만큼 로또가 생성된다.")
    void buyCountCreateLotto() {
        //given
        int buyCount = 5;

        //when
        Map<Integer, List<Integer>> lottoNumbers = LottoMachine.create(buyCount);

        //then
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(5);
    }
}