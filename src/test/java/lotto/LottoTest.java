package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Service.LottoService;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private LottoController lottoController;
    private LottoService lottoService;

    @BeforeEach
    void after(){
        lottoController = LottoController.getInstance();
        lottoService = LottoService.getInstance();
        lottoService.cleanData();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    void 이등_테스트(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoController.setLottoBudget("1000");
                    lottoController.createUserLottoNumber("1,2,3,4,5,6");
                    lottoController.createBonusNumber("7");

                    assertThat(lottoController.countScore().getSecondPlace())
                            .isEqualTo(1);
                },
                List.of(1,2,3,4,5,7)
        );
    }

    @Test
    void 삼등_테스트(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoController.setLottoBudget("1000");
                    lottoController.createUserLottoNumber("1,2,3,4,5,6");
                    lottoController.createBonusNumber("45");

                    assertThat(lottoController.countScore().getThirdPlace())
                            .isEqualTo(1);
                },
                List.of(1,2,3,4,5,7)
        );
    }
}