package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.Input;
import lotto.view.Output;

public class LottoProcedure {
    private final int LOTTO_SIZE = 6;
    User user;
    Lotto lotto;
    BonusNumber bonusNumber;

    public void startLotto() {
        Output.printPaymentMessage();
        user = new User(Input.inputPayment());
        Output.printPurchaseNumber(user.PurchaseNumber());
        Output.printPurchasedLottoNumbers(user.PurchasedLottoNumbers());

        Output.printWinningNumbersMessage();
        lotto = new Lotto(Input.inputLotto());

        Output.printBonusNumberMessage();
        bonusNumber = new BonusNumber(Input.inputBonusNumber(), lotto.numbers());

        Output.printWinningStatisticsMessage();
        count();
        for (int i=3;i<user.numberOfMatches().size();i++) {
            System.out.println(i + " " + user.numberOfMatches().get(i));
            
        }

    }
    
    public void count() {
        for (int i=0;i<user.PurchasedLottoNumbers().size();i++) {
            int count = 0;
            for (int j=0;j<lotto.numbers().size();j++) {
                if (user.PurchasedLottoNumbers().get(i).contains(lotto.numbers().get(j))) {
                    count += 1;
                }
            }
            user.increaseNumberOfMatches(count);
        }
    }
}
