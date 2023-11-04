package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGenerateTest {
    LottoGenerate lottoGenerate = new LottoGenerate();

    @DisplayName("요청 횟수만큼 로또 번호 묶음 생성되는지 확인")
    @Test
    void checkSize() {
        assertThat(lottoGenerate.getRandomLottoResult(3).size()).isEqualTo(3);
    }

    @DisplayName("로또 번호 오름차순으로 출력되는지 확인")
    @Test
    void checkNumberSortedASC() {
        List<Integer> result = lottoGenerate.getRandomLottoResult(1).get(0);
        List<Integer> compare = result.stream().sorted().toList();

        assertThat(result).isEqualTo(compare);
    }
}