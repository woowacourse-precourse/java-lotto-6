package lotto.view;

import lotto.util.LottoGuideMessage;

public class OutputView {

    public void showMessage(String message) {
        System.out.println(message);
    }
    public void showMessage(LottoGuideMessage lottoGuideMessage) {
        System.out.println(lottoGuideMessage.getMessage());
    }
}
