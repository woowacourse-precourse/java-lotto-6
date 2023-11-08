package lotto.domain;


import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Lotto 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottosTest {

    private static Lottos lottos;


    @BeforeEach
    void setUp() {
        lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(4, 5, 6, 7, 8, 9))
                ));
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndBonusNumbers")
    void findLottoRanks_메소드는_로또들의_당첨_등수를_반환한다(String winning, int bonus, List<LottoRank> expect) {
        WinningNumbers testWinningNumber = new WinningNumbers(winning);
        BonusNumber testBonusNumber = new BonusNumber(bonus, testWinningNumber);

        Assertions.assertEquals(lottos.findLottoRanks(testWinningNumber, testBonusNumber), expect);
    }

    private static Stream<Arguments> provideWinningNumbersAndBonusNumbers() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", 7, List.of(LottoRank.FIRST, LottoRank.FIFTH)),
                Arguments.of("5,6,7,8,9,10", 4, List.of(LottoRank.NOTHING, LottoRank.SECOND))
        );
    }
}
