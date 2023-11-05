package lotto;

import lotto.controller.BuyerController;
import lotto.controller.JackpotController;
import lotto.controller.PurchaseController;
import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.JackpotNumber;
import lotto.domain.lottery.Lottos;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Buyer buyer = BuyerController.requestPayment();
        Lottos lottos = PurchaseController.purchase(buyer);

        List<JackpotNumber> jackpotNormalNumbers = JackpotController.requestJackpotNumbers();
        JackpotNumber jackpotBonusNumber = JackpotController.requestJackpotBonusNumber();

        jackpotNormalNumbers.stream()
                .map(JackpotNumber::getNumber)
                .forEach(System.out::println);

        System.out.println("jackpotBonusNumber = " + jackpotBonusNumber.getNumber());
    }
}
