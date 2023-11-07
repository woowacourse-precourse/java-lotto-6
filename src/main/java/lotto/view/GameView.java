package lotto.view;

import lotto.model.Lotto;

import java.util.List;

import static lotto.constant.Constant.ERROR_MESSAGE_FRONT;

public class GameView {

    public void errorMessageView(String errorMessage) {
        System.out.println(ERROR_MESSAGE_FRONT + errorMessage);
    }

    public void lottoPrintView(int lottoCount, List<Lotto> lotto) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lottoNumbers : lotto) {
            System.out.println(lottoNumbers);
        }
    }
}
