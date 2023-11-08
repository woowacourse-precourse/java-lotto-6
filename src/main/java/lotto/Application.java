package lotto;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInterface controll = new UserInterface();
        Customer user = new Customer();
        Integer money =controll.buyLottoInput();
        List<LottoResults> judgeresult = Arrays.asList(LottoResults.values());
        user.buyLottos(controll.moneyValidate(money));
        user.printPocket();
        List<Integer> winningNumbers = controll.winningValidate(controll.winningNumberInput());
        Integer bonusNumber = controll.bonusValidate(winningNumbers, controll.bonusInput());
        user.judgment(winningNumbers, bonusNumber, judgeresult);
        controll.printJudgment(judgeresult);
        controll.printPrizeRate(user.calculatePrizeRate(user.calculatePrize(judgeresult),money));
    }
}
