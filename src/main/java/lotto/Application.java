package lotto;

import lotto.utils.LottoUtil;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoView lottoView = new LottoView();
        LottoUtil lottoUtil = new LottoUtil();
        boolean numberCheck = false;
        String payment = null;
        int count = 0;

        lottoView.printBuyLottomMoneyMessage();
        while (!numberCheck) {
            payment = lottoUtil.getUserInput();
            numberCheck = lottoUtil.validateNumber(payment);
            if(numberCheck) {
                numberCheck = lottoUtil.validateThousand(payment);
            }
        }
        count = lottoUtil.getCount(payment);





    }
}
