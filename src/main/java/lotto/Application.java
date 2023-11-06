package lotto;

import lotto.utils.LottoUtil;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoView lottoView = new LottoView();
        LottoUtil lottoUtil = new LottoUtil();
        boolean numberCheck = false;

        lottoView.printBuyLottomMoneyMessage();
        while (!numberCheck) {
            String payment = lottoUtil.getUserInput();
            numberCheck = lottoUtil.validateNumber(payment);
            if(numberCheck) {
                numberCheck = lottoUtil.validateThousand(payment);
            }
        }

    }
}
