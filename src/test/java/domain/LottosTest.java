package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @DisplayName("정해진 수만큼 로또를 생성한다.")
    @Test
    void LottosCorrectCount(){
        int count = 10;
        int actual = new Lottos(count).getLottos().size();

        assertThat(actual).isEqualTo(count);
    }

}