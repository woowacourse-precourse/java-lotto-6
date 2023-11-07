package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.View;
import lotto.constant.ErrorMessage;
import lotto.constant.ViewMessage;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseMachine {
    private final View view = new View();
    private final InputController inputController = new InputController();
    private final LottoController lottoController = new LottoController();

    public int getPurchaseQuantity() {
        int purchaseQuantity = 0;
        int money;

        view.print(ViewMessage.ASK_PURCHASE_AMOUNT.getMessage());
        money = inputController.readInputByInteger();
        do {
            try {
                purchaseQuantity = lottoController.getPurchaseQuantity(money);
            } catch (NumberFormatException e) {
                view.print(ErrorMessage.NOT_A_NUMBER.getErrorMessage());
            } catch (IllegalArgumentException e) {
                view.print(ErrorMessage.NOT_SEPARATED_1000.getErrorMessage());
            }
        } while (purchaseQuantity == 0);
        return purchaseQuantity;
    }

    public List<Lotto> getMyLottoNumber(int purchaseQuantity) {
        List<Lotto> myLotto = new ArrayList<>();
        List<Integer> numbers;
        List<Integer> sortedNumbers;

        view.printLine();
        view.print(view.getPrintPurchaseAmount(purchaseQuantity));
        for (int i = 0; i < purchaseQuantity; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sortedNumbers = sortedByAsc(numbers);
            myLotto.add(new Lotto(sortedNumbers));

            view.print(view.getPrintPurchaseNumber(myLotto.get(i)));
        }
        return myLotto;
    }

    public List<Integer> sortedByAsc(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
