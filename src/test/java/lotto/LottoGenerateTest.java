package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGenerateTest {
    @DisplayName("요청 횟수만큼 로또 번호 묶음 생성되는지 확인")
    @Test
    void checkSize() {
        LottoGenerate lottoGenerate = new LottoGenerate(3);
        assertThat(lottoGenerate.getRandomLottoNumbers().size()).isEqualTo(3);
    }

    @DisplayName("로또 번호 오름차순으로 출력되는지 확인")
    @Test
    void checkNumberSortedASC() {
        LottoGenerate lottoGenerate = new LottoGenerate(1);
        List<Integer> result = lottoGenerate.getRandomLottoNumbers().get(0);
        List<Integer> compare = result.stream().sorted().toList();

        assertThat(result).isEqualTo(compare);
    }
}