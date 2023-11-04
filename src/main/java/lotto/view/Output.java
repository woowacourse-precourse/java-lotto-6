package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.WinningRank;

import java.util.Comparator;
import java.util.Map;

public class Output {

    private static final String LINE_BREAK = "\n";
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String WINNING_RANK_COUNT_FORMAT = " - %d개";

    public void showMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void showLottoTickets(LottoTickets lottoTickets) {
        showBuyCount(lottoTickets);
        showLottoNumbers(lottoTickets);
    }

    private void showLottoNumbers(LottoTickets lottoTickets) {
        lineBreak();
        lottoTickets.getLottos().forEach(System.out::println);
    }

    private void showBuyCount(LottoTickets lottoTickets) {
        lineBreak();
        System.out.printf(BUY_COUNT_FORMAT, lottoTickets.getSize());
    }

    public void showWinningNumbersInputMessage() {
        lineBreak();
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public void showBonusNumberInputMessage() {
        lineBreak();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void showWinningStats(Map<WinningRank, Integer> winningResult) {
        lineBreak();
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDER);
        showWinningResult(winningResult);
    }

    private void showWinningResult(Map<WinningRank, Integer> winningResult) {
        winningResult.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> -e.getKey().getRanking()))
                .filter(entry -> !entry.getKey().equals(WinningRank.NONE))
                .forEach(entry -> System.out.println(entry.getKey() + String.format(WINNING_RANK_COUNT_FORMAT, entry.getValue())));
    }

    private void lineBreak() {
        System.out.print(LINE_BREAK);
    }
}
