package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateLottoTest {
    private CreateLotto createLotto;

    @DisplayName("랜덤한 숫자로 로또 클래스를 생성한다.")
    @Test
    void createRandomSingleLotto() {
        createLotto = new CreateLotto();
        assertThat(createLotto.createRandom()).isInstanceOf(Lotto.class);
    }
}