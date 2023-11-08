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
}
