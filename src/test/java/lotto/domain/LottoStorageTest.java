package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStorageTest extends NsTest {

    @DisplayName("로또 저장소 객체 생성 테스트")
    @ParameterizedTest
    @MethodSource("getAutomaticLottoStorageAndWinningLotto")
    void createLottoStorage(AutomaticLottoStorage automaticLottoStorage, WinningLotto winningLotto) {
        // Act & Assert
        Assertions.assertInstanceOf(LottoStorage.class, LottoStorage.of(automaticLottoStorage, winningLotto));
    }

    private static Stream<Arguments> getAutomaticLottoStorageAndWinningLotto() {
        return Stream.of(
                Arguments.of(AutomaticLottoStorage.from(8000), WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 7)),
                Arguments.of(AutomaticLottoStorage.from(6000), WinningLotto.of(List.of(3, 4, 5, 6, 7, 8), 9))
        );
    }

    @DisplayName("로또 당첨 내역 기반 당첨 통계 출력 테스트")
    @Test
    void showAllLottoRankResult() {
        Assertions.assertAll(
                () -> {
                    run();
                    Assertions.assertTrue(output().contains("3개 일치 (5,000원) - 1개"));
                    Assertions.assertTrue(output().contains("4개 일치 (50,000원) - 1개"));
                    Assertions.assertTrue(output().contains("5개 일치 (1,500,000원) - 1개"));
                });
    }

    @DisplayName("모든 자동 로또 번호와 당첨 로또 비교 테스트 및 총 수익률 출력 테스트")
    @Test
    void showLottoProfitRate() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 19437.5%입니다."
                    );
                },
                List.of(1, 3, 5, 14, 22, 45),
                List.of(1, 2, 3, 4, 42, 43),
                List.of(1, 2, 3, 4, 5, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45)
        );
    }

    @Override
    protected void runMain() {
        List<LottoRank> ranks = List.of(
                LottoRank.FIFTH_PLACE,
                LottoRank.FOURTH_PLACE,
                LottoRank.THIRD_PLACE
        );

        LottoStorage lottoStorage = LottoStorage.of(
                AutomaticLottoStorage.from(8000),
                WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 7)
        );

        lottoStorage.showAllLottoRankResult(ranks);
        lottoStorage.showLottoProfitRate(ranks);
    }
}