package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 500, 999, 1001})
    void 로또_구매_금액이_1000원_단위가_아니라면_예외를_발생시킨다(int money) {
        // given
        Money purchaseMoney = new Money(money);
        LottoMachine lottoMachine = new LottoMachine((min, max, length) -> List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> lottoMachine.purchaseLotto(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void 로또_구매_금액은_1000원_단위여야_한다(int money) {
        // given
        Money purchaseMoney = new Money(money);
        LottoMachine lottoMachine = new LottoMachine((min, max, length) -> List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatCode(() -> lottoMachine.purchaseLotto(purchaseMoney))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> provideLottoNumbers() {
        List<List<Integer>> numbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(45, 44, 43, 42, 41, 40)
        );

        return Stream.of(Arguments.of(numbers));
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    void 주어진_숫자_생성기에_따라_로또를_발행할_수_있다(List<List<Integer>> lottoNumbers) {
        // given
        AtomicInteger index = new AtomicInteger(0);
        LottoMachine lottoMachine = new LottoMachine((min, max, length) -> lottoNumbers.get(index.getAndIncrement()));

        Lottos expectedLottos = new Lottos(lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));

        // when
        Lottos actualLottos = lottoMachine.purchaseLotto(new Money(3000));

        // then
        assertThat(expectedLottos).usingRecursiveComparison()
                .isEqualTo(actualLottos);
    }

    @Test
    void 랜덤_로또를_발행할_수_있다() {
        // given
        LottoMachine lottoMachine = new LottoMachine(Randoms::pickUniqueNumbersInRange);

        // when & then
        assertThatCode(() -> lottoMachine.purchaseLotto(new Money(3000)))
                .doesNotThrowAnyException();
    }
}
