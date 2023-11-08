package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStorageTest {

    @DisplayName("로또 저장소 객체 생성 테스트")
    @ParameterizedTest
    @MethodSource("getAutomaticLottoStorageAndWinningLotto")
    void createLottoStorage(AutomaticLottoStorage automaticLottoStorage, WinningLotto winningLotto) {
        // Act & Assert
        Assertions.assertInstanceOf(LottoStorage.class, LottoStorage.of(automaticLottoStorage, winningLotto));

    }

    private static Stream<Arguments> getAutomaticLottoStorageAndWinningLotto() {
        return Stream.of(
                Arguments.of(AutomaticLottoStorage.from(8000), WinningLotto.of(List.of(1,2,3,4,5,6), 7)),
                Arguments.of(AutomaticLottoStorage.from(6000), WinningLotto.of(List.of(3,4,5,6,7,8), 9))
        );
    }

//
//    @Test
//    void showAllLottoRankResult() {
//    }
//
//    @Test
//    void showLottoProfitRate() {
//    }
//
//    @Test
//    void compareAllAutomaticLottoWithWinningNumbers() {
//    }
}