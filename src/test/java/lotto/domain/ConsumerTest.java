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

    private static final int LESS_AMOUNT = 900;
    private static final int GREATER_AMOUNT = 101000;
    private static final int DIVIDE_AMOUNT = 1250;
    private static final int AMOUNT = 1000;
    private static final String ERROR_PREFIX_TEXT = "[ERROR]";

    @ParameterizedTest
    @MethodSource("errorAmountData")
    @DisplayName("구매 금액의 제약조건에 의해 예외 발생 상황 테스트")
    void buyAmountExceptionTest(int amount, String errorPrefix, String errorMessage) {
        assertThatThrownBy(() -> new Consumer(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorPrefix, errorMessage);
    }

    static Stream<Arguments> errorAmountData() {
        return Stream.of(
                Arguments.of(LESS_AMOUNT, ERROR_PREFIX_TEXT, "구매 금액이 최소 구매 금액(1,000원)보다 미만입니다."),
                Arguments.of(GREATER_AMOUNT, ERROR_PREFIX_TEXT, "구매 금액이 최대 구매 금액(100,000원)보다 초과 되었습니다."),
                Arguments.of(DIVIDE_AMOUNT, ERROR_PREFIX_TEXT, "구매 금액이 1,000원으로 나누어 떨어지지 않습니다.")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    @DisplayName("구매자의 구매 금액이 정상적으로 입력된 경우 저장")
    void buyAmountSave(int amount) {
        Consumer consumer = new Consumer(amount);
        assertThat(consumer.getBuyAmount()).isEqualTo(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    @DisplayName("구매자의 구매 금액이 정상적인 경우 구매 가능 수량 확인")
    void buyAvailableQuantity(int amount) {
        Consumer consumer = new Consumer(amount);

        assertThat(consumer.getBuyAvailableQuantity()).isEqualTo(amount / AMOUNT);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 2000, 3000})
    @DisplayName("구매자의 구매 금액이 정상적인 경우 구매 가능 수량이 다른 경우 예외 발생 확인")
    void buyAvailableQuantityException(int amount) {
        Consumer consumer = new Consumer(amount);

        assertThatThrownBy(() -> consumer.buyLotto(Arrays.asList(new Lotto(List.of(1, 2, 3, 4, 5, 6)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, "구매 가능 수량이 구매 수량과 일치하지 않습니다.");
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