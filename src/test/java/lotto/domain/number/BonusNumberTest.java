package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.dto.request.BonusNumberRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    List<Integer> a = List.of(1,2,3,4,5,6);
    Lotto init = new Lotto(a);
    WinningLotto winningLotto = new WinningLotto(init);

    @Test
    void getBonusNumber() {

    }

    @Test
    @DisplayName("잘못된 타입 예외처리")
    void validateType(){
        String init1 = "!";
        WinningLotto winningLotto = new WinningLotto(init);
        BonusNumberRequest request = new BonusNumberRequest(init1);

        assertThatThrownBy(() -> new BonusNumber(request, winningLotto))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 수보다 높거나 낮은 예외처리")
    void validateRange(){
        String init1 = "0";
        BonusNumberRequest request = new BonusNumberRequest(init1);

        assertThatThrownBy(() -> new BonusNumber(request, winningLotto))
            .isInstanceOf(IllegalArgumentException.class);
    }
}