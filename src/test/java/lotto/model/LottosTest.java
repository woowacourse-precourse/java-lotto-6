package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottosTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("Lottos 생성 성공")
    void createLottosSuccessfully() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        Assertions.assertThatCode(() -> Lottos.from(lottoList))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Lottos 생성 실패 - null 입력")
    void createLottosWithNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Lottos.from(null));
        Assertions.assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @MethodSource("provideLottoListsForEquivalencePartitioning")
    @DisplayName("동치 분할 테스트 - 빈 리스트와 비어있지 않은 리스트")
    void equivalencePartitioningWithLottoLists(List<Lotto> lottos) {
        Assertions.assertThatCode(() -> Lottos.from(lottos)).doesNotThrowAnyException();
    }

    static Stream<List<Lotto>> provideLottoListsForEquivalencePartitioning() {
        return Stream.of(
                Collections.emptyList(),
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))
        );
    }
}