package lotto.domain.model;

import lotto.constant.RankConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteriesTest {

    private static List<List<Integer>> provideListsForProduceStatics() {
        return Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 8, 7),
                Arrays.asList(1, 2, 3, 9, 8, 7),
                Arrays.asList(1, 2, 3, 9, 8, 7)
        );
    }

    private static Stream<Arguments> provideObjects() {
        // 여기에서 객체를 생성하고 Arguments로 래핑하여 반환
        return Stream.of(
                Arguments.of(new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), new BonusNumber(7))
        );
    }

    @DisplayName("당첨 통계가 반환되는지 확인한다.")
    @Test
    void produceStatistics() {
        // Given
        Lotteries lotteries = new Lotteries();
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        List<List<Integer>> listForCreateLotteries = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 5, 8),
                Arrays.asList(1, 2, 3, 4, 8, 7),
                Arrays.asList(1, 2, 3, 9, 8, 7)
        );

        for (List<Integer> listForCreateLotto : listForCreateLotteries) {
            lotteries.add(new Lotto(listForCreateLotto));
        }

        // When
        Map<String, Integer> mapForTest = lotteries.produceStatistics(winningNumber, bonusNumber);

        // Then
        assertEquals(1, mapForTest.get(RankConstant.FIRST));
        assertEquals(1, mapForTest.get(RankConstant.SECOND));
        assertEquals(1, mapForTest.get(RankConstant.THIRD));
        assertEquals(1, mapForTest.get(RankConstant.FOURTH));
        assertEquals(1, mapForTest.get(RankConstant.FIFTH));
    }

}