package lotto.controller.converter;

import java.util.Set;
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
        Set<Integer> result = converter.convert(winningNumbers);
        
    }
}