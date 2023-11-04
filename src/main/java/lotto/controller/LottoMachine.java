package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.config.AppConfig;
import lotto.input.PriceInputHandler;
import lotto.input.TargetNumberHandler;
import lotto.model.LottoBuyer;
import lotto.service.LottoChecker;
import lotto.service.LottoShop;

public class LottoMachine {

    public void run() {
        int amount = getTicketAmount();
        List<Integer> target = getTargetNumbers();
        int bonus = getBonusNumber(target);

        LottoShop lottoShop = new LottoShop(amount);
        LottoBuyer buyer = lottoShop.sell();
        LottoChecker lottoChecker = new LottoChecker(buyer, target, bonus);
    }

    private static int getBonusNumber(List<Integer> target) {
        String bonusInput = Console.readLine();
        return TargetNumberHandler.validateBonusNumber(bonusInput, target);
    }

    private int getTicketAmount() {
        System.out.println("지불할 금액을 입력해주세요.");
        String priceInput = Console.readLine();
        int price = PriceInputHandler.validatePrice(priceInput);
        return price / AppConfig.LOTTO_PRICE;
    }

    private List<Integer> getTargetNumbers() {
        System.out.println("정답인 6개의 로또번호를 입력해주세요.");
        String targetInput = Console.readLine();
        return TargetNumberHandler.validateTargetNumber(targetInput);
    }
}
