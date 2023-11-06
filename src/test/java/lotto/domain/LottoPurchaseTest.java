package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.dto.LottoNumbersInfo;
import lotto.dto.LottoPurchaseInfo;
import lotto.message.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoPurchaseTest {

    @ParameterizedTest
    @DisplayName("당첨 구매 수익률을 계산한다.")
    @MethodSource("provideLottoPurchase")
    void calculateProfitRate(LottoPurchase lottoPurchase, float expected) {
        assertEquals(lottoPurchase.getProfitRate(), expected);
    }

    private static Stream<Arguments> provideLottoPurchase() {
        return Stream.of(
                Arguments.of(new LottoPurchase(
                        new LottoPurchaseInfo(BigDecimal.valueOf(1000), Lotto.PRICE),
                        new LottoNumbersInfo(List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                                List.of(1, 2, 3, 4, 5, 6),
                                7
                        )), LottoResult.FIRST.getPrize() / Lotto.PRICE.floatValue() * 100
                ),
                Arguments.of(new LottoPurchase(
                                new LottoPurchaseInfo(BigDecimal.valueOf(1000), Lotto.PRICE),
                                new LottoNumbersInfo(List.of(
                                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                        new Lotto(List.of(11, 12, 13, 14, 15, 18))
                                ),
                                        List.of(1, 2, 3, 4, 5, 6),
                                        7
                                )),
                        (LottoResult.FIRST.getPrize() + LottoResult.SECOND.getPrize()) / Lotto.PRICE.floatValue() * 100
                )
        );
    }
}
