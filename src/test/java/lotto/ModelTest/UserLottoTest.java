package lotto.ModelTest;

import lotto.controller.LottoController;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoTest {
    LottoController lottoController = new LottoController();

    @DisplayName("유저 로또 값 확인")
    @Test
    void checkUserLotto(){
        List<Lotto> lo = lottoController.generateLottoNum(5);
        assertThat(lo.size()).isEqualTo(5);
    }
}
