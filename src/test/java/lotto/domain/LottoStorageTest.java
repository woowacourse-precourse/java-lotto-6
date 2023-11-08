package lotto.domain;

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
    }

//
//    @Test
//    void showLottoProfitRate() {
//    }
//
//    @Test
//    void compareAllAutomaticLottoWithWinningNumbers() {
//    }
}