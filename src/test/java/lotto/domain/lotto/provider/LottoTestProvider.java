package lotto.domain.lotto.provider;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class LottoTestProvider {

    public static Stream<Arguments> provideValuesForNumbersDuplicatedException() {
        return Stream.of(
                Arguments.of(List.of(12, 13, 23, 23, 23, 4)),
                Arguments.of(List.of(1, 12, 12, 12, 2, 4)),
                Arguments.of(List.of(5, 2, 23, 45, 2, 45))
        );
    }
}
