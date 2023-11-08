package service;

import lotto.model.domain.Referee;
import lotto.model.service.LottoService;
import lotto.model.service.RefereeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();
    private final RefereeService refereeService = new RefereeService();

    @DisplayName("로또 번호 무작위 값을 생성할 때 1 ~ 45 사이의 값이 생성된다.")
    @RepeatedTest(10)
    void createLottoByValidRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        int purchaseAmount = 1000;
        List<Integer> numbers = lottoService.pickLottoNumbers();

        for (Integer num : numbers) {
            assertTrue(1 <= num && num <= 45, "범위 밖의 숫자가 포함되어 있습니다.");
        }
    }

    @DisplayName("로또 당첨 번호와 로또 번호 중 n개 일치할 경우 n개가 카운팅 된다.")
    @ParameterizedTest
    @MethodSource("provideListsForTest")
    void matchingLottoNumbersWithWinningNumbers(List<Integer> winningNumbers, int count, List<Integer> lottoNumbers, int expectedCount) {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        int actualCount = refereeService.getHitNumberCount(winningNumbers, count, lottoNumbers);
        assertEquals(expectedCount, actualCount);
    }

    static Stream<Arguments> provideListsForTest() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 0, List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 0, List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 0, List.of(1, 2, 3, 4, 11, 7), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 0, List.of(1, 2, 3, 12, 44, 7), 3)

        );
    }

    @DisplayName("보너스 번호와 로또 번호 중 n개 일치할 경우 보너스 번호 일치가 정상적으로 동작한다.")
    @ParameterizedTest
    @MethodSource("provideNumberListsForTest")
    void matchingBonusNumberWithWinningNumbers(int bonusNumber, List<Integer> lottoNumbers, boolean expectedCount) {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        boolean hitBonusNumber = refereeService.isHitBonusNumber(bonusNumber, lottoNumbers);
        assertEquals(expectedCount, hitBonusNumber);
    }

    static Stream<Arguments> provideNumberListsForTest() {
        return Stream.of(
                Arguments.of(1, List.of(1, 2, 3, 4, 5, 6), true),
                Arguments.of(7, List.of(1, 2, 3, 4, 5, 6), false)
        );
    }

    @DisplayName("수익률이 소숫점 첫째 자리 반올림으로 정확하게 계산된다.")
    @Test
    void calculateBenefitValueByRoundToFirstDecimalPlace() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Referee referee = new Referee(List.of(1, 2, 3, 4, 5, 6), 7);
        referee.increaseCountForRank(5);
        referee.calculateLottoBenefit(8000);

        assertEquals(referee.getLottoBenefit(), 62.5);
    }

    @DisplayName("맞춘 갯수 만큼 랭킹 등수가 정확하게 산정된다.")
    @ParameterizedTest
    @MethodSource("provideRankListsForTest")
    void calculateRankingListByHitNumbers(int hitNumberCount, boolean isHitBonusNumber, int expectedRank) {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        int rank = refereeService.getRank(hitNumberCount, isHitBonusNumber, 0);

        assertEquals(rank, expectedRank);
    }

    static Stream<Arguments> provideRankListsForTest() {
        return Stream.of(
                Arguments.of(3, false, 5),
                Arguments.of(4, false, 4),
                Arguments.of(5, false, 3),
                Arguments.of(5, true, 2),
                Arguments.of(6, false, 1),
                Arguments.of(0, false, 0),
                Arguments.of(1, false, 0),
                Arguments.of(2, false, 0)
        );
    }
}
