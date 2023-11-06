package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class InsertLottoNumberTest {

    @Test
    void 로또_번호_범위처리() {
        assertThatThrownBy(() -> new InsertLottoNumber("100,-1,30,4,5,45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_공백처리() {
        assertThatThrownBy(() -> new InsertLottoNumber("1,2, ,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_값전달() {
        assertThat(new InsertLottoNumber("1,2,3,4,5,6")
                .sendLottoNumber())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}