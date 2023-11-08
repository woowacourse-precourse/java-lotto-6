package lotto.modelTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,80", "1,2,3,4,5", "1,2,3,4,4,5"})
    @DisplayName("로또 번호 검증 테스트")
    public void validateLottoConstructor(String input) {
        List<Integer> lottoNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
