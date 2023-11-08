package lotto.domain;

import static lotto.config.GameConfig.LOTTO_NUMBER_UNIT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import lotto.domain.lotto.LottoManager;
import lotto.domain.lotto_policy.FixedLottoWinningPolicy;
import lotto.domain.lotto_prize.FixedLottoPrizeStandard;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {
    private final LottoManager lottoManager = new LottoManager();

    @DisplayName("알맞은 개수의 로또를 생성하는 지 검증한다.")
    @Test
    void generateSpecificNumberOfLotteries() {
        // given
        Integer purchaseAmount = 8_000;
        lottoManager.generateLotteries(purchaseAmount);

        // when
        List<List<Integer>> lotteriesNumbers = lottoManager.getLotteriesNumbers();

        // then
        assertThat(lotteriesNumbers.size())
                .isEqualTo(purchaseAmount / LOTTO_NUMBER_UNIT);
    }

    @DisplayName("정해진 범위내 로또 숫자로 로또를 생성하는 지 검증한다.")
    @Test
    void generateLottoNumberInSpecifiedRage() {
        // given
        Integer purchaseAmount = 8_000;

        // when
        lottoManager.generateLotteries(purchaseAmount);
        List<List<Integer>> lotteriesNumbers = lottoManager.getLotteriesNumbers();

        // then
        Integer size = validateNumbersRange(lotteriesNumbers);
        assertThat(size).isEqualTo(lotteriesNumbers.size());
    }

    private static Integer validateNumbersRange(List<List<Integer>> lotteriesNumbers) {
        return lotteriesNumbers.stream()
                .filter(lottoNumbers -> lottoNumbers.stream().allMatch(InputValidator::validateLottoNumberRange))
                .toList().size();
    }

    @DisplayName("정렬된 형태의 당첨 결과를 제공하는 지 검증한다.")
    @Test
    void generateSortedWinningResult() {
        // given
        Integer purchaseAmount = 8_000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        // when
        lottoManager.generateLotteries(purchaseAmount);
        lottoManager.setWinningNumbers(winningNumbers);
        lottoManager.setFixedLottoWinningPolicy(new FixedLottoWinningPolicy(bonusNumber));

        // then
        List<Entry<FixedLottoPrizeStandard, Integer>> winningResults =
                new ArrayList<>(lottoManager.getLottoWinningResults().entrySet());

        boolean isSorted = IntStream.range(0, winningResults.size() - 1)
                .allMatch(i -> winningResults.get(i).getKey().getMatchCount()
                        <= winningResults.get(i).getKey().getMatchCount());

        assertThat(isSorted).isTrue();
    }

    @DisplayName("총 수익률을 올바르게 계산하여 제공하는 지 검증한다.")
    @Test
    void calculateTotalReturnRate() {
        // given
        Integer purchaseAmount = 8_000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        // when
        lottoManager.generateLotteries(purchaseAmount);
        lottoManager.setWinningNumbers(winningNumbers);
        lottoManager.setFixedLottoWinningPolicy(new FixedLottoWinningPolicy(bonusNumber));

        // then
        Integer totalReturn = lottoManager.getLottoWinningResults().entrySet().stream()
                .mapToInt(winningResult -> winningResult.getKey().getPrize() * winningResult.getValue())
                .sum();
        Double totalReturnRate = lottoManager.getTotalReturnRate();
        assertThat(1.0 * totalReturn / purchaseAmount * 100)
                .isEqualTo(totalReturnRate);
    }
}
