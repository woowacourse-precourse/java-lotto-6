package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoGrade;
import lotto.model.Lottos;
import lotto.model.MoneyToBuy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    OutputView outputView = new OutputView();

    @Nested
    class PrintNumberOfBoughtLottosTest extends NsTest {
        @DisplayName("구매한 로또 개수 출력에 대한 테스트입니다.")
        @Test
        void printNumberOfBoughtLottosTest() {
            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "1개를 구매했습니다.",
                        "100개를 구매했습니다."
                );
            });
        }

        @Override
        protected void runMain() {
            outputView.printNumberOfBoughtLottos(1);
            outputView.printNumberOfBoughtLottos(100);
        }
    }

    @Nested
    class printLottosTest extends NsTest {
        Lottos lottos = new Lottos();

        @DisplayName("구매한 로또 번호 출력 테스트입니다.")
        @Test
        void printLottosTest() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run();
                        assertThat(output()).contains(
                                "[1, 2, 3, 4, 5, 6]",
                                "[1, 2, 3, 4, 5, 6]\n"
                                        + "[10, 11, 12, 13, 14, 15]"
                        );
                    },
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(10, 11, 12, 13, 14, 15)
            );
        }

        @Override
        protected void runMain() {
            lottos.generate(1);
            outputView.printLottos(lottos);
            lottos.generate(1);
            outputView.printLottos(lottos);
        }
    }

    @Nested
    class PrintPrizeResultsTest extends NsTest {
        Map<LottoGrade, Integer> grades = new HashMap<>();

        @DisplayName("당첨 내역에 대한 테스트입니다.")
        @Test
        void printPrizeResultsTest() {
            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "3개 일치 (5,000원) - 5개"
                        , "4개 일치 (50,000원) - 4개"
                        , "5개 일치 (1,500,000원) - 3개"
                        , "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개"
                        , "6개 일치 (2,000,000,000원) - 1개"
                );
            });
        }

        @Override
        protected void runMain() {
            grades.put(LottoGrade.SIX_MATCH, 1);
            grades.put(LottoGrade.FIVE_AND_BONUS_MATCH, 2);
            grades.put(LottoGrade.FIVE_MATCH, 3);
            grades.put(LottoGrade.FOUR_MATCH, 4);
            grades.put(LottoGrade.THREE_MATCH, 5);

            outputView.printPrizeResults(grades);
        }
    }


    @Nested
    class PrintRateOfReturnTest extends NsTest {
        Map<LottoGrade, Integer> grades = new HashMap<>();
        MoneyToBuy moneyToBuy = new MoneyToBuy(10000);

        @DisplayName("수익률 출력에 대한 테스트입니다.")
        @Test
        void printRateOfReturnTest() {
            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "총 수익률은 650.0%입니다."
                );
            });
        }

        @Override
        protected void runMain() {
            grades.put(LottoGrade.SIX_MATCH, 0);
            grades.put(LottoGrade.FIVE_AND_BONUS_MATCH, 0);
            grades.put(LottoGrade.FIVE_MATCH, 0);
            grades.put(LottoGrade.FOUR_MATCH, 1);
            grades.put(LottoGrade.THREE_MATCH, 3);

            outputView.printRateOfReturn(grades, moneyToBuy);
        }
    }
}
