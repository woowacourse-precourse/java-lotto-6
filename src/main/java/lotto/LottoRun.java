package lotto;

import domain.*;
import util.InputUtil;
import util.MessageUtil;
import util.ValidationUtil;
import java.util.List;

public class LottoRun {
//    private final InputUtil inputUtil = new InputUtil();
//    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
    private final LottoBonusNumber lottoBonusNumber = new LottoBonusNumber();
//    private final LottoResultCompute lottoResultCompute = new LottoResultCompute();
    public void run(){
        messageUtil.printPurchaseAmount();
        LottoPurchase purchaseInfo = lottoPurchase.getLottoPurchaseInfo();
        LottoWinningNumber winningNumInfo = lottoWinningNumber.getLottoWinningNumInfo();
        LottoBonusNumber bonusNumInfo = lottoBonusNumber.getLottoBonusNumInfo();
        LottoResultCompute resultCompute = new LottoResultCompute(winningNumInfo, bonusNumInfo);
        resultCompute.getLottoResultComputeInfo(purchaseInfo.getUserLottos(), purchaseInfo.getUserLottoAmount());
    }

}
