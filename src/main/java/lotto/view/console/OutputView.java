package lotto.view.console;

import lotto.dto.output.LottoIssueResultDTO;
import lotto.dto.output.RankResultDTO;
import lotto.dto.output.ResultDTO;

public class OutputView {

    private static final String START_INPUT_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String START_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String START_INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public static void printInputAmount() {
        System.out.println(START_INPUT_AMOUNT);
    }

    public static void printInputWinningNumbers() {
        System.out.println(START_INPUT_WINNING_NUMBERS);
    }

    public static void printInputBonus() {
        System.out.println(START_INPUT_BONUS_NUMBER);
    }

    public static void printLottoIssueResult(LottoIssueResultDTO resultDTO) {
        System.out.println("\n" + resultDTO.getTicketCount() + "개를 구매했습니다.");
        resultDTO.getLottos()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printRankResult(ResultDTO resultDTO) {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("\n당첨 통계\n---\n");
        for (RankResultDTO rankResultDTO : resultDTO.getResults()) {
            resultBuilder.append(formatRankString(rankResultDTO)).append("\n");
        }
        System.out.println(resultBuilder);
    }

    private static String formatRankString(RankResultDTO rankResultDTO) {
        return rankResultDTO.getMatchCount() + "개 일치 (" +
                rankResultDTO.getReward() + "원) - " +
                rankResultDTO.getCount() + "개";
    }
}
