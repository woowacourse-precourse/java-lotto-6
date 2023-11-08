package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PrintGames {
    Map<String, Integer> result = null;

    public void purchaseHistory(List<Lotto> lottoGames) {
        int count = lottoGames.size();
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = lottoGames.get(i).getNumbers();
            Collections.sort(lotto);
            System.out.println(lotto);
        }
    }

    public String resultMessage(int rank) {
        String message = "";
        for (Prize prize : Prize.values()) {
            if (rank == prize.getRank()) {
                message = prize.getDescription() + " - " + result.get(prize.name()) + "개";
            }
        }
        return message;
    }

    public void finalResults(Map<String, Integer> result) {
        this.result = result;
        for (int rank = Prize.values().length; rank > 0; rank--) {
            System.out.println(resultMessage(rank));
        }
    }
}
