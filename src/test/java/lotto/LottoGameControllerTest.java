package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameControllerTest extends NsTest {
    private static LottoGameController controller;

    @BeforeAll
    static void 초기_설정() {
        controller = new LottoGameController();
    }

    @DisplayName("로또구매 금액에 따른 수량 및 번호 반환(buy_unit=1000)")
    @Test
    void 로또_구매_결과_반환() {
        //given
        long buyCash = 5000;
        long buyAmountExpected = 5;

        List<Lotto> expectedLottos = new ArrayList<>();
        expectedLottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        expectedLottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        expectedLottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        expectedLottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        expectedLottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = controller.purchaseLotto(buyCash);
                    assertThat(lottos.getLottoAmount()).isEqualTo(buyAmountExpected);

                    List<Lotto> lottoTickets = lottos.getLottoTickets();

                    for (int index = 0; index < lottoTickets.size(); index++) {
                        assertThat(lottoTickets.get(index).getNumbersMessage())
                                .isEqualTo(expectedLottos.get(index).getNumbersMessage());
                    }
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );

    }

    @DisplayName("입력한 로또 당첨번호 생성 로직")
    @Test
    void 당첨_로또_생성기능() {
        //given
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        //when
        Lotto winningLotto = controller.generateWinningLotto(winningNumbers);

        //then
        assertThat(winningLotto.getNumbersMessage()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        winningNumbers.forEach((number) -> assertThat(winningLotto.isContains(number)).isTrue());
    }

    @Override
    public void runMain() {

    }

}
