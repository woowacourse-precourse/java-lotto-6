package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("구입한 로또의 갯수랑 같지 않으면 예외 발생")
    @Test
    void createLottosByDifferentSize(){
        assertThatThrownBy(() -> new Lottos(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입한 로또의 갯수와 생성된 로또의 갯수가 다릅니다.");
    }
}
