package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class LottoPrint {
    public void inputAmountPrint(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void purchaseLottoPrint(int amount, List<Lotto> lotto){
        StringBuilder sb = new StringBuilder();
        sb.append(amount).append("개를 구매했습니다.").append("\n");
        for(Lotto one : lotto){
            sb.append("[");
            for(int i = 0; i < one.getNumbers().size(); i++){
                sb.append(one.getNumbers().get(i));
                if(i != one.getNumbers().size()-1) sb.append(", ");
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }

    public void inputPrizeNumberPrint() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public void inputBonusNumberPrint() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void winningStaticsMent() {
        System.out.println("당첨 통계");
        System.out.println("—-");
    }

    public void winningStaticsPrint(Map<Integer, Integer> winningCount, double rate) {
        System.out.println("3개 일치 (5,000원) - " + winningCount.get(5000) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCount.get(50000) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningCount.get(1500000) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCount.get(30000000) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCount.get(2000000000) + "개");
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
