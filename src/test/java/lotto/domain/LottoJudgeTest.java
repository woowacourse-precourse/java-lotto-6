package lotto.domain;

import lotto.domain.wrapper.BuyLottos;
import lotto.domain.wrapper.Lotto;
import lotto.domain.wrapper.WinLottoWithBonus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoJudgeTest {

    private static Stream<Arguments> generateBasicLotto() {
        return Stream.of(
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,4,5,6"))), LottoHandler.SIX),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,4,5,7"))), LottoHandler.FIVE_WITH_BONUS),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,4,5,8"))),  LottoHandler.FIVE),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,4,8,7"))),  LottoHandler.FOUR),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,9,8,7"))),  LottoHandler.THREE),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,10,9,8,7"))),  LottoHandler.OTHER)
        );
    }
    private WinLottoWithBonus winLottoWithBonus;

    @BeforeEach
    void init() {
        winLottoWithBonus = WinLottoWithBonus.create(List.of(1, 2, 3, 4, 5, 6), "7");
    }

    @DisplayName("Handler 객체가 정상적으로 반환된다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @MethodSource("generateBasicLotto")
    void createLottoHandler(BuyLottos buyLottos, LottoHandler result) {
        LottoJudge lottoJudge = LottoJudge.create(buyLottos, winLottoWithBonus);

        for (LottoHandler lottoHandler : lottoJudge.matchLottoHandler().keySet()) {
            assertThat(lottoHandler).isEqualTo(result);
        }
    }
}
