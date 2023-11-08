package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBatchTest {

    @DisplayName("입력 개수만큼 로또를 만든다.")
    @ParameterizedTest
    @ValueSource(ints = {10,3,4})
    void createLottoByDuplicatedNumber(int source) {
        LottoBatch lottoBatch = new LottoBatch(source);
        assertThat(lottoBatch.getLottos().size()).isEqualTo(source);
    }
}
