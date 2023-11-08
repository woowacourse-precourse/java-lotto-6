package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateLottoNumberTest {

    @Test
    @DisplayName("임의의 로또 번호 6개 생성, 1~45 내에 있는 숫자인지 검증")
    void 로또번호생성() {
        CreateLottoNumber createLottoNumber = new CreateLottoNumber();
        List<Integer> lottoNumber = createLottoNumber.createLottoNumber();
        assertThat(lottoNumber.size()).isEqualTo(6);
        for (Integer number : lottoNumber) {
            assertThat(number > 1 && number < 45).isTrue();
        }
    }

}