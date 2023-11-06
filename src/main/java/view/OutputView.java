package view;

import java.util.Arrays;
import java.util.List;
import model.Lotto;

public class OutputView {

    public static void showGeneratedLotto(int lottoMount, List<Lotto> generatedLottos) {
        System.out.println(lottoMount + "개를 구매했습니다.");

        for (Lotto ticket : generatedLottos) {
            System.out.println(ticket.getNumbers());
        }
    }

}
