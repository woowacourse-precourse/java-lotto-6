package lotto.view;

import lotto.entity.Lotto;
import lotto.entity.Prize;
import lotto.model.Profit;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {
//    DecimalFormat decimalFormat = new DecimalFormat("#.00%");
    public void profitResult(Profit profit){
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Prize,Integer> resultList=profit.getResultCount();
        for(Prize prize:Prize.values()){
            if(prize==Prize.OUT){
                continue;
            }
            String message = prize.getMessage();
            String count = resultList.get(prize).toString();
            System.out.println(message+" - "+count+"개");
        }
        String profitRate = String.format("%,.1f",profit.getProfitRate());
        System.out.println("총 수익률은 "+profitRate+"%입니다.");
    }
    public void lottoResult(List<Lotto> lottos){
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for(Lotto lotto:lottos){
            lottoFormatOutput(lotto.getNumbers());
        }
        System.out.println();
    }
    public void lottoFormatOutput(List<Integer> lotto){
        List<Integer> sortedLotto = lotto.stream()
                .sorted()
                .toList();
        String result = sortedLotto.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("[" + result + "]");

    }
}
