package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {
    List<Lotto> lottoList;

    @BeforeEach
    void setup() {
        Lotto lotto1 = new Lotto(Arrays.asList(6, 9, 19, 23, 31, 41));
        Lotto lotto2 = new Lotto(Arrays.asList(9, 10, 12, 24, 25, 29));
        Lotto lotto3 = new Lotto(Arrays.asList(13, 24, 26, 27, 38, 42));
        Lotto lotto4 = new Lotto(Arrays.asList(2, 4, 8, 9, 19, 40));
        Lotto lotto5 = new Lotto(Arrays.asList(3, 6, 9, 27, 36, 40));

        lottoList = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
    }

    @DisplayName("당첨 내역의 총 수익률은 소수점 둘째 자리에서 반올림하여 계산한다")
    @Test
    void 당첨_내역의_총_수익률은_소수점_둘째_자리에서_반올림하여_계산한다() {
        //given
        //when
        //then
    }

    @DisplayName("당첨된 로또의 내역을 확인")
    @Test
    void 당첨된_로또의_내역을_확인() {
        //given
        Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        LottoMachine lottoMachine = new LottoMachine(winLotto, lottoList, 19);

        //then
        //assertThat(lottoMachine).isEqualTo();
    }

    @DisplayName("로또 배열을 탐색하면서 당첨 번호와 보너스 번호를 찾는 작업을 수행")
    @Test
    void 로또_배열을_탐색하면서_당첨_번호와_보너스_번호를_찾는_작업을_수행(){

    }

}