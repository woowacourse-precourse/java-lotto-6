package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public static void printBuyInstruction() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    public static void printNumberOfLottosPurchased(List<Lotto> playersLottos) {
        int lottosCount = playersLottos.size();
        System.out.println(lottosCount + "개를 구매했습니다.");
    }
    
    public static void printPlayerLottos(List<Lotto> playersLottos) {
    	for(Lotto lotto : playersLottos) {
    		System.out.println(lotto.getNumbers().toString());
    	}
    	System.out.println();
    }
}
