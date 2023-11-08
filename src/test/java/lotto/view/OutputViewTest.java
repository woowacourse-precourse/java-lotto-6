package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.model.LottoResult;
import lotto.model.WinningInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
    }

    @Nested
    @DisplayName("구매 개수 출력 테스트")
    class PrintPurchaseAmountTest extends NsTest {
        int purchaseAmount;

        @DisplayName("구매 개수 출력")
        @Test
        public void PrintPurchaseAmount() {
            purchaseAmount = 8;

            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "8개를 구매했습니다."
                );
            });

        }

        @Override
        protected void runMain() {
            outputView.printPurchaseAmount(purchaseAmount);
        }
    }


    @Nested
    @DisplayName("구매한 로또 출력 테스트")
    class PrintPurchaseLottosTest extends NsTest {
        List<String> lottos;

        @DisplayName("구매한 로또 모두 출력")
        @Test
        public void PrintPurchaseLottos() {
            lottos = List.of("[1, 2, 3, 4, 5, 6]", "[7, 8, 9, 10, 11, 12]", "[13, 14, 15, 16, 17, 18]");

            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "[1, 2, 3, 4, 5, 6]",
                        "[7, 8, 9, 10, 11, 12]",
                        "[13, 14, 15, 16, 17, 18]"
                );
            });

        }

        @Override
        protected void runMain() {
            outputView.printPurchaseLottos(lottos);
        }
    }


    @Nested
    @DisplayName("당첨 통계 출력 테스트")
    class printWinnerStatusTest extends NsTest {
        LottoResult lottoResult;

        @DisplayName("당첨 통계 출력")
        @Test
        public void printWinnerStatus() {
            lottoResult = LottoResult.of();
            addResults();

            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "3개 일치 (5,000원) - 2개",
                        "4개 일치 (50,000원) - 1개",
                        "5개 일치 (1,500,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 0개"
                );
            });
        }

        private void addResults() {
            lottoResult.addResult(WinningInfo.THREE_MATCH);
            lottoResult.addResult(WinningInfo.THREE_MATCH);
            lottoResult.addResult(WinningInfo.FOUR_MATCH);
            lottoResult.addResult(WinningInfo.FIVE_MATCH);
        }

        @Override
        protected void runMain() {
            outputView.printWinnerStatus(lottoResult);
        }
    }


    @Nested
    @DisplayName("수익률 출력 테스트")
    class printTotalRateOfReturnTest extends NsTest {
        double rateOfReturn;

        @DisplayName("수익률 출력")
        @Test
        public void printTotalRateOfReturn() {
            rateOfReturn = 0.255;

            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "총 수익률은 25.5%입니다."
                );
            });
        }

        @Override
        protected void runMain() {
            outputView.printTotalRateOfReturn(rateOfReturn);
        }
    }


}