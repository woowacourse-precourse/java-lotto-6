package lotto;

import java.util.ArrayList;
import java.util.List;

public class Compare {
    int bonusNumber;
    private int[] ranking = new int[] {0,0,0,0,0,0,0,0};

    public void compareResult(List<Lotto> playerLottos, Lotto winningLotto, int bonusNumber, int playerAmount) {
        compareLottoNumber(playerLottos, winningLotto, bonusNumber);
        OutputGuideMessage.resultGuideMessage();

        double percent = (Math.round(getWinningPercent(playerAmount) * 10) / 10.0);

        System.out.println(Rank.FIFTH.getWinningMessage() + ranking[Rank.FIFTH.getCountOfMatch()] + "개");
        System.out.println(Rank.FOURTH.getWinningMessage() + ranking[Rank.FOURTH.getCountOfMatch()] + "개");
        System.out.println(Rank.THIRD.getWinningMessage() + ranking[Rank.THIRD.getCountOfMatch()] + "개");
        System.out.println(Rank.SECOND.getWinningMessage() + ranking[Rank.SECOND.getCountOfMatch()] + "개");
        System.out.println(Rank.FIRST.getWinningMessage() + ranking[Rank.FIRST.getCountOfMatch()] + "개");
        System.out.printf("총 수익률은 %.1f", percent);
        System.out.println("%입니다.");

    }

    public void compareLottoNumber(List<Lotto> playerLottos, Lotto winningLotto, int bonusNumber) {
        for(Lotto lotto : playerLottos) {
            checkWinningCount(lotto.getLotto(), winningLotto.getLotto(), bonusNumber);
        }

    }

    public void checkWinningCount(List<Integer> playerLottoNum, List<Integer> winningLottoNum, int bonusNumber) {
        int count = 0;

        for(int player : playerLottoNum) {
            for(int winning : winningLottoNum) {
                if(player == winning) {
                    count++;
                }
            }
        }
        if(count == 5 && playerLottoNum.contains(bonusNumber)) {
            ranking[0]++;
            return ;
        }
        ranking[7-count]++;
    }

    public Double getWinningPercent(int playerAmount) {
        double percent = 0;
        Rank[] rank = Rank.values();

        for(int i = 0; i < 6; i++) {
            percent += (double) (ranking[i] * rank[i].getWinningAmount());
        }

        return (percent) / (double) playerAmount * 100;
    }
}
