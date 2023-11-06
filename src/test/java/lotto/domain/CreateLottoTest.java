package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateLottoTest {

    @DisplayName("주어진 갯수만큼의 로또로 이루어진 리스트를 생성한다.")
    @Test
    void createLottoList() {
        CreateLotto createLotto = new CreateLotto();

        createLotto.setAmount(5);
        createLotto.multipleLotto();

        assertThat(createLotto.getLottos().get(4)).isInstanceOf(Lotto.class);
    }
}