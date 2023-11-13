package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTest {
    private List<Integer> validLottoNumbers;
    private List<Integer> invalidLottoNumbers;
    Lotto lotto;

    @BeforeEach
    void setUp() {
        validLottoNumbers = Arrays.asList(2, 1, 3, 4, 5, 6);
        invalidLottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
        lotto = new Lotto(validLottoNumbers);
    }

    @Test
    void testInvalidLottoConstruction() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(invalidLottoNumbers));
    }

    @Test
    void testLottoToString() {
        Assertions.assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}