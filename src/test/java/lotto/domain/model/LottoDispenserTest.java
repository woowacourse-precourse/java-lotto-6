package lotto.domain.model;

import java.util.List;
import lotto.constant.IllegalStateExceptionType;
import lotto.domain.LottoGenerateStrategy;
import lotto.domain.LottoManualGenerator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDispenserTest {

    LottoDispenser lottoDispenser;
    List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
    List<Integer> numbers2 = List.of(2, 4, 6, 8, 10, 12);
    List<Integer> numbers3 = List.of(5, 10, 20, 30, 40, 45);
    @BeforeEach
    void setUp() {
        LottoGenerateStrategy lottoManualGenerator = new LottoManualGenerator(List.of(numbers1, numbers2, numbers3));
        LottoPurchaseCost lottoPurchaseCost = new LottoPurchaseCost(3000L);

        lottoDispenser = new LottoDispenser(lottoManualGenerator, lottoPurchaseCost);
    }

    @DisplayName("로또_발행_테스트")
    @Test
    void dispenseLottosOnce() {
        List<Lotto> dispensedLottos = lottoDispenser.dispense();
        List<List<Integer>> dispensedLottosNumbers = dispensedLottos.stream().map(Lotto::getNumbers).toList();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(dispensedLottosNumbers.get(0)).isEqualTo(numbers1);
        softAssertions.assertThat(dispensedLottosNumbers.get(1)).isEqualTo(numbers2);
        softAssertions.assertThat(dispensedLottosNumbers.get(2)).isEqualTo(numbers3);

        softAssertions.assertAll();
    }

    @DisplayName("로또_재발행_실패_테스트")
    @Test
    void dispenseLottosTwice() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThatCode(() -> lottoDispenser.dispense()).doesNotThrowAnyException();
        softAssertions.assertThatThrownBy(() -> lottoDispenser.dispense())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(IllegalStateExceptionType.LOTTO_ALREADY_DISPENSED.getMessage());

        softAssertions.assertAll();
    }
}