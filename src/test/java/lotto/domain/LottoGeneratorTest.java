package lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lotto.vo.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("입력한 수 만큼 로또가 생성됨")
    @Test
    void generateLottoSizeCheck() {
        // given
        int lottoCount = 10;

        // when
        List<Lotto> resultList = LottoGenerator.generateLottoes(BigDecimal.valueOf(lottoCount));

        // then
        Assertions.assertThat(resultList.size()).isEqualTo(lottoCount);
    }

    @DisplayName("각각의 로또에 생성된 숫자 리스트가 오름차순 정렬된 상태인지 확인 ")
    @Test
    void generateLotto_sort_오름차순_정렬_확인() {
        // given
        int lottoCount = 10;

        // when
        List<Lotto> resultList = LottoGenerator.generateLottoes(BigDecimal.valueOf(lottoCount));

        for (Lotto lotto : resultList) {
            List<Integer> expectedSortedNumbers = lotto.getNumbers().stream().sorted().collect(Collectors.toList());
            Assertions.assertThat(expectedSortedNumbers).isEqualTo(lotto.getNumbers());
        }
    }

    @Disabled // 너무 오래걸려서 제외함
    @DisplayName("Integer.MAX_VALUE 보다 많은 로또를 생성하면, list 사이즈는 Integer.MAX_VALUE 로 출력됨")
    @Test
    void generateLottoLargeSizeCheck() {
        // given
        long lottoCount = (long) Integer.MAX_VALUE + 1L;

        // when
        List<Lotto> resultList = LottoGenerator.generateLottoes(BigDecimal.valueOf(lottoCount));

        // then
        Assertions.assertThat(resultList.size()).isEqualTo(lottoCount);
    }
}