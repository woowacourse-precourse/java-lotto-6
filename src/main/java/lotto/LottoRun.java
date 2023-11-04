package lotto;

import domain.Lotto;
import domain.LottoPurchase;
import domain.LottoWinningNumber;
import domain.LottoBonusNumber;
import util.InputUtil;
import util.MessageUtil;
import util.ValidationUtil;

public class LottoRun {
//    private final InputUtil inputUtil = new InputUtil();
//    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
    private final LottoBonusNumber lottoBonusNumber = new LottoBonusNumber();
    public void run(){
        messageUtil.printPurchaseAmount();
//        getLottoPurchaseInfo
        lottoPurchase.getLottoPurchaseInfo();
        lottoWinningNumber.getLottoWinningNumInfo();
        lottoBonusNumber.getLottoBonusNumInfo();

    }

}
