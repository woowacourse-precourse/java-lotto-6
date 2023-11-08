package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    @DisplayName("금액을 입력받으면 구입한 로또의 갯수를 반환")
    void lottoCount() {
        LottoService lottoService = new LottoService();
        int lottoCount = lottoService.lottoCount(10000);
        Assertions.assertThat(10).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("랜덤한 6자리 숫자를 생성")
    void randomNumber() {
        LottoService lottoService = new LottoService();
        List<Integer> randomNumber = lottoService.randomNumber();

        Assertions.assertThat(6).isEqualTo(randomNumber.size());
    }

    @Test
    @DisplayName("입렵받은 갯수만큼 로또를 발행")
    void lottoIssuance() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.lottoIssuance(3);

        Assertions.assertThat(3).isEqualTo(lottos.size());
        for (int i = 0; i < lottos.size(); i++) {
            Assertions.assertThat(lottos.get(i)).isInstanceOf(Lotto.class);
        }
    }

    @Test
    @DisplayName("로또 한장의 번호와 당첨 숫자를 비교 후 몇개가 일치하는지 반환")
    void compareNumbers() {
        LottoService lottoService = new LottoService();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int i1 = lottoService.compareNumbers(lotto, new int[]{1, 2, 3, 4, 5, 6});
        int i2 = lottoService.compareNumbers(lotto, new int[]{4, 5, 6, 7, 8, 9});

        Assertions.assertThat(6).isEqualTo(i1);
        Assertions.assertThat(3).isEqualTo(i2);
    }

    @Test
    @DisplayName("일치하는 수를 넣으면 그에 맞는 등수를 추가")
    void addLottoWinner() {
        LottoService lottoService = new LottoService();
        lottoService.addLottoWinner(6, false);
        lottoService.addLottoWinner(4,false);
        lottoService.addLottoWinner(4,false);
        lottoService.addLottoWinner(5, true);
        lottoService.addLottoWinner(5, false);


        Assertions.assertThat(1).isEqualTo(lottoService.getLotto1st());
        Assertions.assertThat(2).isEqualTo(lottoService.getLotto4st());
        Assertions.assertThat(1).isEqualTo(lottoService.getLotto2st());
        Assertions.assertThat(1).isEqualTo(lottoService.getLotto3st());
    }

    @Test
    @DisplayName("발행된 갯수만큼 등수 추가")
    void lottoResult() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(7,8,9,10,11,12)));
        int[] winningNumber = {1,2,3,4,5,6};
        int bonusNum = 7;
        lottoService.lottoResult(lottos, winningNumber, bonusNum);

        Assertions.assertThat(1).isEqualTo(lottoService.getLotto1st());
    }


}