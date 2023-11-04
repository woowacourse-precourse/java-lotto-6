package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.config.AppConfig;
import lotto.input.PriceInputHandler;
import lotto.input.TargetNumberHandler;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.win.Rank;
import lotto.service.Calculator;
import lotto.service.LottoShop;
import lotto.view.LottoView;

public class LottoMachine {
    LottoView lottoView = new LottoView();
    Calculator calculator = new Calculator();

    public void run() {
        int amount = getTicketAmount();
        LottoShop lottoShop = new LottoShop(amount);
        List<Lotto> lottoTickets = lottoShop.sell();
        lottoView.printLotto(lottoTickets);

        Lotto target = getTargetLotto();
        int bonus = getBonusNumber(target);
        LottoBuyer buyer = new LottoBuyer(lottoTickets, target, bonus);

        Map<Rank, Integer> checkResult = buyer.checkAllLotto();

        double rateOfReturn = calculator.calculateRateOfReturn(checkResult, amount * AppConfig.LOTTO_PRICE);
        lottoView.printResult(checkResult, rateOfReturn);
    }

    private static int getBonusNumber(Lotto target) {
        String bonusInput = Console.readLine();
        return TargetNumberHandler.validateBonusNumber(bonusInput, target);
    }

    private int getTicketAmount() {
        System.out.println("지불할 금액을 입력해주세요.");
        String priceInput = Console.readLine();
        int price = PriceInputHandler.validatePrice(priceInput);
        return price / AppConfig.LOTTO_PRICE;
    }

    private Lotto getTargetLotto() {
        System.out.println("정답인 6개의 로또번호를 입력해주세요.");
        String targetInput = Console.readLine();
        List<Integer> target = TargetNumberHandler.validateTargetNumber(targetInput);
        return new Lotto(target);
    }
}
