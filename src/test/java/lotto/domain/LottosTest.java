package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {
    private static List<Integer> lottoNumberList;

    @Test
    @DisplayName("로또 랜덤 생성")
    void randomLottoSizing(){
        Lottos lottoNumbers = new Lottos();
        lottoNumberList = lottoNumbers.setRandomNumbers();

        assertThat(lottoNumberList.size()).isEqualTo(6);
    }
}