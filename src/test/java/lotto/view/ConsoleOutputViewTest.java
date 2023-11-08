package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.dto.response.PurchasePriceResponse;
import lotto.dto.response.WinningResponse;
import lotto.dto.response.WinningStatistic;
import lotto.exception.InputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static lotto.domain.Reward.FIRST_PLACE;
import static lotto.domain.Reward.FOURTH_PLACE;
import static lotto.domain.Reward.LAST_PLACE;
import static lotto.domain.Reward.SECOND_PLACE;
import static lotto.domain.Reward.THIRD_PLACE;
import static lotto.exception.errorcode.InputErrorCode.INVALID_BONUS_NUMBER_RANGE;
import static lotto.fixture.UserFixture.총_2장_구매_당첨_X_유저;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleOutputViewTest {
    private OutputStream outputStream;
    private final OutputView outputView = new ConsoleOutputView();

    @BeforeEach
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void afterEach() {
        Console.close();
    }

    @DisplayName("구매한 금액만큼 발급한 로또 번호를 출력한다.")
    @Test
    public void printPurchaseResponses() throws Exception {
        final User user = 총_2장_구매_당첨_X_유저.생성();
        final List<PurchasePriceResponse> responses = PurchasePriceResponse.createResponsesFromUser(user);

        outputView.printPurchaseLottos(responses);
        final StringBuilder stringBuilder = new StringBuilder("\n2개를 구매했습니다.");
        for (PurchasePriceResponse response : responses) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(response.getNumbers());
        }
        stringBuilder.append(System.lineSeparator());

        final String expect = stringBuilder.toString();
        final String actual = outputStream.toString();

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("당첨 통계과 수익률을 출력한다.")
    @Test
    public void printWinningResponse() throws Exception {
        final Map<Integer, WinningStatistic> statisticGroupingByRank = initStatisticGropingByRank();
        final double profitRate = 70.5;
        final WinningResponse winningResponse = new WinningResponse(statisticGroupingByRank, profitRate);

        outputView.printWinningStatistic(winningResponse);
        final String actual = outputStream.toString();
        final String expectStatistic = "3개 일치 (5,000원) - 1개\n" + "4개 일치 (50,000원) - 2개";
        final String expectProfitRate = "총 수익률은 " + profitRate + "%입니다.";

        assertThat(actual).contains(expectStatistic, expectProfitRate);
    }

    @DisplayName("예외 발생시 예외 메시지를 출력한다.")
    @Test
    public void printExceptionMessageWhenThrowsException() throws Exception {
        outputView.printExceptionMessage(new InputException(INVALID_BONUS_NUMBER_RANGE));
        final String actual = outputStream.toString();
        final String expect = INVALID_BONUS_NUMBER_RANGE.getMessage() + "\n";

        assertThat(actual).isEqualTo(expect);
    }

    private Map<Integer, WinningStatistic> initStatisticGropingByRank() {
        final Map<Integer, WinningStatistic> statisticGroupingByRank = new ConcurrentHashMap();
        statisticGroupingByRank.put(FIRST_PLACE.getRank(), WinningStatistic.from(FIRST_PLACE, 0));
        statisticGroupingByRank.put(SECOND_PLACE.getRank(), WinningStatistic.from(SECOND_PLACE, 0));
        statisticGroupingByRank.put(THIRD_PLACE.getRank(), WinningStatistic.from(THIRD_PLACE, 0));
        statisticGroupingByRank.put(FOURTH_PLACE.getRank(), WinningStatistic.from(FOURTH_PLACE, 2));
        statisticGroupingByRank.put(LAST_PLACE.getRank(), WinningStatistic.from(LAST_PLACE, 1));
        return statisticGroupingByRank;
    }
}