package lotto.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTest {
    private List<Integer> validLottoNumbers;
    private List<Integer> invalidLottoNumbers;

    @BeforeEach
    void setUp() {
        validLottoNumbers = Arrays.asList(2, 1, 3, 4, 5, 6);
        invalidLottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    void testValidLottoConstruction() {
        Lotto lotto = new Lotto(validLottoNumbers);
        Assertions.assertThat(lotto).isNotNull();
    }

    @Test
    void testInvalidLottoConstruction() {
        Assertions.assertThatThrownBy(() -> new Lotto(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testLottoToString() {
        Lotto lotto = new Lotto(validLottoNumbers);
        Assertions.assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}