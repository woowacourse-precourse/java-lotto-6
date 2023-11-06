package lotto.controller;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.controller.converter.WinningNumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumberConverterTest {
    private WinningNumberConverter converter;

    @BeforeEach
    void setUp() {
        converter = new WinningNumberConverter();
    }

    @Test
    void testConvert() {
        String winningNumbers = "5,3,2,7,1";
        Map<Integer, Integer> result = converter.convert(winningNumbers);

        assertThat(result).contains(
                entry(1, 0),
                entry(2, 1),
                entry(3, 2),
                entry(5, 3),
                entry(7, 4)
        );
    }
}