package lotto.view;

import lotto.model.Lotto;

import java.util.List;

import static lotto.constant.ErrorMessage.*;

public class GameView {

    public void errorMessageView(String errorMessage) {
        System.out.println(ERROR_MESSAGE_FRONT + errorMessage);
    }

    public void lottoPrintView(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void resultView(int[] result, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", result[5]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", result[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result[2]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result[1]);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
