package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Yield;
import lotto.dto.WinningResult;

import java.util.*;

public class OutputViewImpl implements OutputView {

    private static final String HEADER = "[ERROR] ";

    @Override
    public void writeLottoPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void writeGeneratedLotto(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(System.out::println);
    }

    @Override
    public void writeLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void writeLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void writeResult(WinningResult winningResult, Yield yield) {
        System.out.println("당첨 통계");
        System.out.println("---");

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
        String message = rank.showMessage(count);
        System.out.println(message);
    }

    private void printYield(Yield yield) {
        String message = String.format("총 수익률은 %s입니다.", yield);
        System.out.println(message);
    }
}
