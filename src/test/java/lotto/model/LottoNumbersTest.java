package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    private static List<Integer> lottoNumberList;

    @DisplayName("랜덤으로 생성되는 로또 개수가 6개를 넘을경우 예외가 발생한다.")
    @Test
    void createRandomNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumberList = lottoNumbers.setRandomNumbers();
        assertThat(lottoNumberList.size()).isEqualTo(6);
    }

    @DisplayName("구매 개수에 맞게 로또를 생성하지 않으면 예외가 발생한다.")
    @Test
    void createLottoByValidNumber() {
        int numOfLotto = 12;
        LottoNumbers lottos = new LottoNumbers(numOfLotto);
        assertThat(lottos.getLottos().size()).isEqualTo(12);
    }

}
