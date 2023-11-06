package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public static void printBuyInstruction() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    public static void printNumberOfLottosPurchased(List<Lotto> playersLottos) {
        int lottosCount = playersLottos.size();
        System.out.println();
        System.out.println(lottosCount + "개를 구매했습니다.");
    }
    
    public static void printPlayerLottos(List<Lotto> playersLottos) {
    	for(Lotto lotto : playersLottos) {
    		List<Integer> lottoNumberSort = lotto.getNumbers();
    		Collections.sort(lottoNumberSort);
    		System.out.println(lottoNumberSort.toString());
    	}
    	System.out.println();
    }
    
    public static void printWinningNumberInstruction() {
    	System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void printBonusNumberInstruction() {
    	System.out.println();
    	System.out.println("보너스 번호를 입력해 주세요.");
    }
    
    
}
