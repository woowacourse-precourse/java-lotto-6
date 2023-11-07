package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AutomaticLottoTest {

    @DisplayName("자동 로또 번호 복수 개 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5 })
    void createAutomaticLotto(Integer ticket) {
        // Arrange & Act
        List<AutomaticLotto> automaticLottos = AutomaticLotto.from(ticket);

        // Assert
        Assertions.assertEquals(automaticLottos.size(), ticket);
    }
}