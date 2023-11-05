package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.Input;
import lotto.view.Output;

public class LottoProcedure {
    private final int MINIMUM_NUMBER_OF_SAME = 3;
    private final int LOTTO_SIZE = 6;
    private final List<Double> amount = new ArrayList<>();
    User user;
    Lotto lotto;
    BonusNumber bonusNumber;

    public LottoProcedure() {
        List<Double> amount = List.of(0.0, 0.0, 0.0, 5000.0, 50000.0, 1500000.0, 200000000.0, 30000000.0);
        this.amount.addAll(amount);
    }

    public void startLotto() {
        getPayment();

        Output.printPurchaseNumber(user.purchaseNumber());
        Output.printPurchasedLottoNumbers(user.PurchasedLottoNumbers());

        getLotto();

        getBonusNumber();

        Output.printWinningStatisticsMessage();
        checkRank();
        Output.printStatistics(user.numberOfWin());
        double sum = calculateYeild();
        System.out.println("총 수익률은 " + String.format("%.1f",sum/user.payment() * 100) +"%입니다.");
    }

    public void getPayment() {
        Output.printPaymentMessage();
        do {
            try {
                user = new User(Input.inputPayment());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessages
                        .PAYMENT_ERROR_MESSAGE
                        .getMessage());
            }
        } while(true);
    }

    public void getLotto() {
        Output.printWinningNumbersMessage();
        do {
            try {
                lotto = new Lotto(Input.inputLotto());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessages
                        .LOTTO_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }

    public void getBonusNumber() {
        Output.printBonusNumberMessage();
        do {
            try {
                bonusNumber = new BonusNumber(Input.inputBonusNumber(), lotto.numbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessages
                       .BONUS_NUMBER_ERROR_MESSAGE
                       .getMessage());
            }
        } while (true);
    }

    public double calculateYeild() {
        double sum = 0;
        for (int i=MINIMUM_NUMBER_OF_SAME;i<user.numberOfWin().size();i++) {
            if (user.numberOfWin().get(i) != 0) {
                sum += this.amount.get(i);
            }
        }
        return sum;
    }

    public void checkRank() {
        for (int i=0;i<user.purchasedLottoNumbersSize();i++) {
            int count = 0;
            for (int j=0;j<LOTTO_SIZE;j++) {
                if (user.PurchasedLottoNumbers().get(i).contains(lotto.numbers().get(j))) {
                    count += 1;
                }
            }
            if (count == 5) {
                count = checkBonusNumber(user.PurchasedLottoNumbers().get(i), bonusNumber.bonusNumber());
            }
            user.increaseNumberOfWin(count);
        }
    }

    public int checkBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            return 7;
        }
        return 5;
    }

//    public void count() {
//        for (int i=0;i<user.PurchasedLottoNumbers().size();i++) {
//            int count = 0;
//            for (int j=0;j<LOTTO_SIZE;j++) {
//                if (user.PurchasedLottoNumbers().get(i).contains(lotto.numbers().get(j))) {
//                    count += 1;
//                }
//            }
//            user.increaseNumberOfMatches(count);
//        }
//    }
}
