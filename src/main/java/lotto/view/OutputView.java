package lotto.view;

import lotto.domain.Prize;
import lotto.domain.PrizeType;

import java.util.List;

public class OutputView {
    public OutputView(){
    }
    public void printCaculate(double compentationRate){
        System.out.println("총 수익률은" + compentationRate+"% 입니다.");
    }
    public void printPrize(List<Prize> prizes) { //todo: outputView 생성해서 빼기
        System.out.println("당첨 통계");
        System.out.println("------");

        for (PrizeType prizeType : PrizeType.values()) {
            int count = 0;
            int prizeAmount = 0;

            for (Prize prize : prizes) {
                if (prize.getPrizeType() == prizeType) {
                    count = prize.getCount();
                    break;
                }

            }
            String message = prizeType.getMessage();
            System.out.println(message + "-" + count + "개");
        }
    }

}
