package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int DIVIDER_MONEY_TO_EXCHANGE_AMOUNT = 1000;

    public static int enterPurchaseAmount() {
        InputView.noticeToGetPurchaseAmount();
        String inputMoney = Console.readLine();
        int money = Integer.parseInt(inputMoney);
        //천 원 단위로 입력받았는지 검증
        PurchaseAmountValidator.validateMoney(inputMoney, DIVIDER_MONEY_TO_EXCHANGE_AMOUNT);

        OutputView.printPurchaseAmount(money);
        return money / DIVIDER_MONEY_TO_EXCHANGE_AMOUNT;
    }

    public static Lotto enterWinningNumbers() {
        InputView.noticeToGetWinningNumbers();
        String[] numbers = Console.readLine().split(",");
        //중복 값 입력받았는지 여부 확인
//        LottoValidator.
        List<Integer> inputNumbers = new ArrayList<>();
        for (String number : numbers) {
            inputNumbers.add(Integer.parseInt(number));
        }
        return new Lotto(inputNumbers);
    }

    public static int enterBonusNumber() {
        InputView.noticeToGetBonusNumber();
        //보너스 번호가 당첨 번호랑 중복되는지 여부 확인

        return Integer.parseInt(Console.readLine());
    }
}
