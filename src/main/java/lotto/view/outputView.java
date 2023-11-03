package lotto.view;

import java.util.List;
import java.util.Map;

public class outputView {
    public void outputAmountOfLotto(int amountOfLotto) {
        System.out.println(amountOfLotto + "개를 구매했습니다.");
    }

    public void outputLottosNumbers(int[][] LottoNumbers) {
        for (int i = 0; i < LottoNumbers.length; i++) {
            System.out.print("[");
            // 여기에 랜덤 번호를 저장한 배열을 호출하는 메소드 추가
            System.out.println("]");
        }
        System.out.println();
    }



    public void outputWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        // Enum을 통한 상수 값 호출 추가

    }

    public void outputReturn(double rateReturn) {
        System.out.println("총 수익률은 " + rateReturn + "입니다.");
    }

}
