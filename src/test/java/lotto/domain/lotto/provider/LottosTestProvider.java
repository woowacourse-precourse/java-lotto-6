package lotto.domain.lotto.provider;

import java.util.List;
import java.util.stream.Stream;
import lotto.dto.LottoDto;
import org.junit.jupiter.params.provider.Arguments;

public class LottosTestProvider {

    public static Stream<Arguments> provideForGenerateTest() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new LottoDto(List.of("1", "2", "3", "4", "5", "6"))
                        ), 1
                ),
                Arguments.of(
                        List.of(
                                new LottoDto(List.of("1", "2", "3", "4", "5", "6")),
                                new LottoDto(List.of("1", "2", "3", "4", "5", "10")),
                                new LottoDto(List.of("1", "2", "3", "6", "7", "15")),
                                new LottoDto(List.of("45", "44", "43", "42", "41", "40"))
                        ), 4
                ),
                Arguments.of(
                        List.of(
                                new LottoDto(List.of("1", "2", "3", "4", "5", "6")),
                                new LottoDto(List.of("1", "2", "3", "4", "5", "10")),
                                new LottoDto(List.of("1", "2", "3", "6", "7", "15")),
                                new LottoDto(List.of("45", "44", "43", "42", "41", "40")),
                                new LottoDto(List.of("1", "2", "3", "4", "5", "6")),
                                new LottoDto(List.of("1", "2", "3", "4", "5", "10")),
                                new LottoDto(List.of("1", "2", "3", "6", "7", "15")),
                                new LottoDto(List.of("45", "44", "43", "42", "41", "40"))
                        ), 8
                )
        );
    }
}
