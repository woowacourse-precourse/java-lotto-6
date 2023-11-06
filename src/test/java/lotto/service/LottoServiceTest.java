package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.dto.LottoPrizeDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @DisplayName("로또 집계 테스트")
    @Test
    void test1() {
        List<Lotto> lottos = new ArrayList<>();
        // 1등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // 2등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));

        // 3등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 40)));

        // 4등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 45, 44)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 38, 45)));

        // 5등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 42, 44, 45)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 40, 45, 44)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 37, 38, 39)));

        // 꽝
        lottos.add(new Lotto(Arrays.asList(1, 2, 43, 42, 41, 40)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 43, 42, 41, 40)));
        lottos.add(new Lotto(Arrays.asList(33, 34, 43, 42, 41, 40)));
        lottos.add(new Lotto(Arrays.asList(12, 11, 43, 42, 41, 40)));

        LottoList lottoList = new LottoList(lottos);
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;

        LottoService lottoService = new LottoService(lottoList, winningNumbers, bonusNumber);
        LottoPrizeDto dto = lottoService.compareLottos();

        assertThat(dto.getFirst()).isEqualTo(2);
        assertThat(dto.getSecond()).isEqualTo(3);
        assertThat(dto.getThird()).isEqualTo(1);
        assertThat(dto.getFourth()).isEqualTo(2);
        assertThat(dto.getFifth()).isEqualTo(4);
    }

}