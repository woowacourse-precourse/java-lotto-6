package lotto.domain.controller.converter;

import lotto.domain.controller.converter.LottosConverter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottosConverterTest {

    @Test
    void 주어진_로또에_맞는_출력값_포맷으로_변환한다() {
        LottosConverter converter = new LottosConverter();
        List<List<Integer>> lottos = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6));
        String expected = """
                [1, 2, 3, 4, 5, 6]
                [1, 2, 3, 4, 5, 6]
                """;

        assertEquals(expected, converter.convert(lottos));
    }

}