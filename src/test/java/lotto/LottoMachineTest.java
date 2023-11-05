package lotto;

import java.util.ArrayList;
import lotto.Model.Lotto;
import lotto.Model.Prize;
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



    @DisplayName("통계를 카운트하는 함수가 맞게 카운트 하는지 확인")
    @Test
    void checkCountStatistics() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 43, 44, 45)));
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
        Integer bonusNumber = 7;

        LottoMachine.countStatistics(lottos , winningNumbers , bonusNumber);


        assertThat(Prize.THREE.getCount()).isEqualTo(1);
    }
}
