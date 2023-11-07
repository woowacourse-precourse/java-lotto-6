package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.dto.CountScoreRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private LottoController lottoController;

    @BeforeEach
    void after(){
        lottoController = LottoController.getInstance();
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
                    List<Lotto> lottoTickets = lottoController
                            .setLottoBudget("1000");
                    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
                    Lotto lotto = new Lotto(numbers);
                    int bonus = 7;
                    CountScoreRequestDTO dto = new CountScoreRequestDTO.Builder()
                            .lottoTickets(lottoTickets)
                            .bonus(bonus)
                            .numbers(lotto)
                            .build();
                    assertThat(lottoController.countScore(dto).getSecondPlace())
                            .isEqualTo(1);
                },
                List.of(1,2,3,4,5,7)
        );
    }

    @Test
    void 삼등_테스트(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottoTickets = lottoController
                            .setLottoBudget("1000");
                    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
                    Lotto lotto = new Lotto(numbers);
                    int bonus = 45;
                    CountScoreRequestDTO dto = new CountScoreRequestDTO.Builder()
                            .lottoTickets(lottoTickets)
                            .bonus(bonus)
                            .numbers(lotto)
                            .build();
                    assertThat(lottoController.countScore(dto).getThirdPlace())
                            .isEqualTo(1);
                },
                List.of(1,2,3,4,5,7)
        );
    }
}