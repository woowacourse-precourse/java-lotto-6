package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.service.LottoGenerate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGenerateTest {
    @DisplayName("요청 횟수만큼 로또 번호 묶음 생성되는지 확인")
    @Test
    void checkSize() {
        LottoGenerate lottoGenerate = new LottoGenerate();
        assertThat(lottoGenerate.createLottoRepeat(3).size()).isEqualTo(3);
    }

    @DisplayName("로또 번호 오름차순으로 출력되는지 확인")
    @Test
    void checkNumberSortedASC() {
        LottoGenerate lottoGenerate = new LottoGenerate();
        List<Integer> result = lottoGenerate.createLottoRepeat(1).get(0).getLotto();
        List<Integer> compare = result.stream().sorted().toList();

        assertThat(result).isEqualTo(compare);
    }
}