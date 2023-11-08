package lotto.view;

import java.util.Map;
import lotto.domain.Consumer;
import lotto.domain.Prize;

public class OutputView {

    public void printLottos(Consumer consumer){
        System.out.println(consumer.getPurchaseAmount() + "개를 구매했습니다.");
        consumer.getLottos()
                .forEach(System.out::println);
    }

    public void printTotalPrize(Map<Prize, Integer> totalPrize){
        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계\n"
                + "---\n");
        totalPrize.keySet().forEach( prize -> {
            sb.append(prize.getMessage());
            sb.append(" - " + totalPrize.get(prize) + "개\n");
        });
        
        System.out.println(sb);
    }

    public void printTotalPrize(double revenueRate){
        System.out.println("총 수익률은 " + revenueRate + "%입니다.");
    }
}
