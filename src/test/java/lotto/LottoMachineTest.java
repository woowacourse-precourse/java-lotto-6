package lotto;

import lotto.Service.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoMachineTest {
    @DisplayName("구입금액에 따른 로또 갯수 체크")
    @Test
    void checkLottoCount() {
        Integer price = 7000;

        Integer lottoCount = LottoMachine.lottoCount(price);

        assertThat(lottoCount).isEqualTo(7);
    }


    @DisplayName("랜덤 넘버 생성함수가 중복되지 않는 6자리수를 리턴하는지 체크")
    @Test
    void checkLottoNumberDuplicated() {
        List<Integer> randomNumbers = LottoMachine.makeRandomNumbers();

        int count = (int) randomNumbers.stream().distinct().count();

        assertThat(count).isEqualTo(6);
    }

}
