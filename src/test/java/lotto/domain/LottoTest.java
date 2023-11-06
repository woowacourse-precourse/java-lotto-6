package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 확인")
    void createLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 출력 확인")
    void printLotto(){
        Lotto lotto = new lotto.domain.Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("만들어진 로또와 비교할 로또를 비교하여 일치하는 enum 반환한다.")
    void mathLotto(){
        Lotto lotto = new lotto.domain.Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new lotto.domain.Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto.match(winningLotto, 7)).isEqualTo(LottoValue.FIVE);
    }

}
