package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.common.Constant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("1 ~ 45 사이의 6개의 숫자 리스트 생성 테스트")
    @Test
    void generateNumberList() {
        // Arrange & Act
        List<Integer> generateNumbers = LottoNumberGenerator.generate();

        // Assert
        Assertions.assertEquals(Constant.LOTTO_NUM_SIZE, generateNumbers.size());
        generateNumbers.forEach(number -> Assertions.assertTrue(LottoNumberValidator.validate(number)));
    }
}