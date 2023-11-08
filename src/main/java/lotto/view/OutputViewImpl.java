package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Yield;
import lotto.dto.WinningResult;

import java.util.*;

public class OutputViewImpl implements OutputView {

    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_COUNT_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String YIELD_RESULT_MESSAGE = "총 수익률은 %s입니다.";
    private static final String RESULT_STATICS_MESSAGE = "당첨 통계";
    private static final String HEADER = "[ERROR] ";
    private static final String DIVISION = "---";

    @Override
    public void writeLottoPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
    }

    @Override
    public void writeGeneratedLotto(List<Lotto> lottos) {
        System.out.printf(BUY_COUNT_LOTTO_MESSAGE, lottos.size());
        lottos.forEach(System.out::println);
    }

    @Override
    public void writeLottoWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    @Override
    public void writeLottoBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    @Override
    public void writeResult(WinningResult winningResult, Yield yield) {
        System.out.println(RESULT_STATICS_MESSAGE);
        System.out.println(DIVISION);

        List<Rank> ranks = getRanksExceptMiss();
        for (Rank rank : ranks) {
            printIndividualRank(winningResult.getRanks(), rank);
        }

        printYield(yield);
    }

    @Override
    public void writeBlank() {
        System.out.println();
    }

    @Override
    public void writeWithErrorMessage(String message) {
        System.out.println(HEADER + message);
    }

    private List<Rank> getRanksExceptMiss() {
        List<Rank> ranks = new ArrayList<>(Arrays.asList(Rank.values()));
        ranks.remove(Rank.MISS);
        Collections.reverse(ranks);
        return ranks;
    }

    private void printIndividualRank(Map<Rank, Integer> rankMap, Rank rank) {
        int count = rankMap.getOrDefault(rank, 0);
        System.out.println(rank.showMessageWithCount(count));
    }

    private void printYield(Yield yield) {
        String message = String.format(YIELD_RESULT_MESSAGE, yield);
        System.out.println(message);
    }
}
