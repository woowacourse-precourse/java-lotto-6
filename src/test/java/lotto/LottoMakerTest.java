package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMakerTest {

    private LottoMaker lottoMaker;

    @BeforeEach
    void setup(){
        lottoMaker = new LottoMaker();
    }

    @DisplayName("6자리 숫자열을 만드는지 확인")
    @Test
    void getLottoNumbersTest() {
        List<Integer> numberList = lottoMaker.getLottoNumbers();
        assertThat(numberList.size()).isEqualTo(6);
    }

    @DisplayName("주어진 개수만큼 로또를 구매한다.")
    @Test
    void getLottoAsMuchAsVolumeTest() {
        List<Lotto> lottos = lottoMaker.getLottoAsMuchAsVolume(5);
        assertThat(lottos.size()).isEqualTo(5);
    }

}