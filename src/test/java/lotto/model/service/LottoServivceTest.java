package lotto.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.utils.enums.LottoCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoServivceTest {
    private LottoService lottoService;
    private List<List<Integer>> createdLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void before() {
        lottoService = new LottoServiceImpl();
        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
    }

    @Test
    void 로또_결과_1등_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6); // 6개 일치
        List<Integer> numbers2 = List.of(6, 5, 4, 3, 2, 1); // 6개 일치
        List<Integer> numbers3 = List.of(1, 2, 10, 11, 12, 13); // 2개 일치

        createdLottos = new ArrayList<>(List.of(numbers, numbers2, numbers3));
        Map<LottoCount, Integer> resultTable = lottoService.compareLottoToWinningAndBonus(
                createdLottos, winningNumbers, bonusNumber);

        Assertions.assertThat(resultTable.getOrDefault(LottoCount.SIX, 0))
                .isEqualTo(2);
        Assertions.assertThat(resultTable.getOrDefault(LottoCount.NONE, 0))
                .isEqualTo(1);
    }

    @Test
    void 로또_결과_2등_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7); // 5개 + 보너스 번호 일치
        List<Integer> numbers2 = List.of(5, 4, 3, 2, 1, 7); // 5개 + 보너스 번호 일치
        List<Integer> numbers3 = List.of(1, 2, 10, 11, 12, 13); // 2개 일치

        createdLottos = new ArrayList<>(List.of(numbers, numbers2, numbers3));
        Map<LottoCount, Integer> resultTable = lottoService.compareLottoToWinningAndBonus(
                createdLottos, winningNumbers, bonusNumber);

        Assertions.assertThat(resultTable.getOrDefault(LottoCount.BONUS, 0))
                .isEqualTo(2);
        Assertions.assertThat(resultTable.getOrDefault(LottoCount.NONE, 0))
                .isEqualTo(1);
    }

    @Test
    void 로또_결과_3등_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 11); // 5개 일치
        List<Integer> numbers2 = List.of(5, 4, 3, 2, 1, 11); // 5개 일치
        List<Integer> numbers3 = List.of(1, 2, 10, 11, 12, 13); // 2개 일치

        createdLottos = new ArrayList<>(List.of(numbers, numbers2, numbers3));
        Map<LottoCount, Integer> resultTable = lottoService.compareLottoToWinningAndBonus(
                createdLottos, winningNumbers, bonusNumber);

        Assertions.assertThat(resultTable.getOrDefault(LottoCount.FIVE, 0))
                .isEqualTo(2);
        Assertions.assertThat(resultTable.getOrDefault(LottoCount.BONUS, 0))
                .isEqualTo(0);
    }

    @Test
    void 로또_결과_4등_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 10, 7); // 4개 + 보너스 번호 일치
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 10, 11); // 4개 일치
        List<Integer> numbers3 = List.of(1, 2, 10, 11, 12, 13); // 2개 일치

        createdLottos = new ArrayList<>(List.of(numbers, numbers2, numbers3));
        Map<LottoCount, Integer> resultTable = lottoService.compareLottoToWinningAndBonus(
                createdLottos, winningNumbers, bonusNumber);

        Assertions.assertThat(resultTable.getOrDefault(LottoCount.FOUR, 0))
                .isEqualTo(2);
        Assertions.assertThat(resultTable.getOrDefault(LottoCount.FIVE, 0))
                .isEqualTo(0);
    }

    @Test
    void 로또_결과_5등_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 10, 11, 12); // 3개 일치
        List<Integer> numbers2 = List.of(3, 2, 1, 10, 11, 7); // 3개 + 보너스 번호 일치
        List<Integer> numbers3 = List.of(1, 2, 10, 11, 12, 13); // 2개 일치

        createdLottos = new ArrayList<>(List.of(numbers, numbers2, numbers3));
        Map<LottoCount, Integer> resultTable = lottoService.compareLottoToWinningAndBonus(
                createdLottos, winningNumbers, bonusNumber);

        Assertions.assertThat(resultTable.getOrDefault(LottoCount.THREE, 0))
                .isEqualTo(2);
        Assertions.assertThat(resultTable.getOrDefault(LottoCount.FOUR, 0))
                .isEqualTo(0);
    }

    @Test
    void 로또_결과_미당첨_테스트() {
        List<Integer> numbers = List.of(1, 2, 9, 10, 11, 12); // 2개 일치
        List<Integer> numbers2 = List.of(2, 1, 9, 10, 11, 7); // 2개 + 보너스 번호 일치
        List<Integer> numbers3 = List.of(1, 9, 10, 11, 12, 13); // 1개 일치

        createdLottos = new ArrayList<>(List.of(numbers, numbers2, numbers3));
        Map<LottoCount, Integer> resultTable = lottoService.compareLottoToWinningAndBonus(
                createdLottos, winningNumbers, bonusNumber);

        Assertions.assertThat(resultTable.getOrDefault(LottoCount.NONE, 0))
                .isEqualTo(3);
        Assertions.assertThat(resultTable.getOrDefault(LottoCount.THREE, 0))
                .isEqualTo(0);
    }
}
