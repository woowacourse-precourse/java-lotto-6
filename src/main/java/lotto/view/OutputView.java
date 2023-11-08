package lotto.view;

import lotto.domain.RankingStatus;

import java.text.DecimalFormat;
import java.util.*;

public class OutputView {
    public void lottoView(int countTickets){
        System.out.println(countTickets+"개를 구매했습니다.");
    }

    public void lottoSortView(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }
    public void resultStatiticView(Map<RankingStatus,Integer> rankings ){
        DecimalFormat formatter = new DecimalFormat("###,###");

        System.out.println("당첨 통계");
        System.out.println("---");

        Arrays.stream(RankingStatus.values())
                .forEach(rank ->
                        System.out.println(rank.message+" ("+formatter.format(rank.reward)+"원) "+"- "+rankings.get(rank)+"개"));
    }
    public void rewardRateView(double rewardRate){
        System.out.println("총 수익률은 "+ rewardRate +"%입니다.");
    }

}
