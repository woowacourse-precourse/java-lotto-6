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

    @DisplayName("로또 수익률 계산 테스트")
    @Test
    void calculateRateOfReturn() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));

        LottoList lottoList = new LottoList(lottos);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoService service = new LottoService(lottoList, winningNumbers, bonusNumber);
        assertThat(service.calculateRateOfReturn()).isEqualTo(62.5d);
    }

}