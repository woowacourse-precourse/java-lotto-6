package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

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
}
