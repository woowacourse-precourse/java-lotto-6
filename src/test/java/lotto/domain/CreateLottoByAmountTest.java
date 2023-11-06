package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateLottoByAmountTest {

    @DisplayName("주어진 갯수만큼의 로또로 이루어진 리스트를 생성한다.")
    @Test
    void createLottoList() {
        CreateLottoByAmount createLottoByAmount = new CreateLottoByAmount();

        createLottoByAmount.setAmount(5);
        createLottoByAmount.multipleLotto();

        assertThat(createLottoByAmount.getLottos().get(4)).isInstanceOf(Lotto.class);
    }
}