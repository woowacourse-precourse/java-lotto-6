package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateLottoTest {

    @DisplayName("로또 생성테스트")
    @Test
    void 로또생성() {
        CreateLotto createLotto = new CreateLotto();
        Lotto lotto = createLotto.createLotto();

        //객체가 생성 됬는지 확인
        assertThat(lotto).isNotNull();
        //생성된 로또에 개수가 6개가 맞는지 확인
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }
}