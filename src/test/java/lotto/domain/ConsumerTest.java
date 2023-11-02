package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConsumerTest {

    private final int LESS_AMOUNT = 900;
    private final int GREATER_AMOUNT = 101000;
    private final int DIVIDE_AMOUNT = 1250;
    private final int AMOUNT = 2000;

    @ParameterizedTest
    @ValueSource(ints = {LESS_AMOUNT, GREATER_AMOUNT, DIVIDE_AMOUNT})
    @DisplayName("구매 금액의 제약조건에 의해 예외 발생 상황 테스트")
    void buyAmountExceptionTest(int amount) {
        assertThatThrownBy(() -> new Consumer(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    @DisplayName("구매자의 구매 금액이 정상적으로 입력된 경우 저장")
    void buyAmountSave(int amount) {
        Consumer consumer = new Consumer(amount);
        assertThat(consumer.getBuyAmount()).isEqualTo(amount);
    }

    @ParameterizedTest
    @MethodSource("initLottoData")
    @DisplayName("구매자 로또 정보 저장하기")
    void buyLottosSaveTest(List<Lotto> lottos) {
        Consumer consumer = new Consumer(AMOUNT);
        consumer.buyLotto(lottos);

        List<Lotto> findLottos = consumer.getLottos();
        assertThat(findLottos).isEqualTo(lottos);
        assertThat(findLottos.size()).isEqualTo(consumer.getBuyAmount() / AMOUNT);
    }

    @ParameterizedTest
    @MethodSource("initLottoData")
    @DisplayName("구매자 로또 정보 변경 시 예외 발생 상황 테스트")
    void getLottosAndModifiedTest(List<Lotto> lottos) {
        Consumer consumer = new Consumer(AMOUNT);
        consumer.buyLotto(lottos);

        List<Lotto> findLottos = consumer.getLottos();

        assertThatThrownBy(() -> findLottos.set(0, new Lotto(List.of(45, 44, 43, 42, 41, 40))))
                .isInstanceOf(UnsupportedOperationException.class);

    }

    static Stream<Arguments> initLottoData() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Lotto(List.of(1, 2, 3, 4, 5, 6)))),
                Arguments.of(Arrays.asList(new Lotto(List.of(7, 8, 9, 10, 11, 12)))),
                Arguments.of(Arrays.asList(new Lotto(List.of(13, 14, 3, 4, 5, 6))))
        );
    }


}