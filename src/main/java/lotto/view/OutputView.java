package lotto.view;

import static lotto.constant.OutputViewConstant.PURCHASE_MESSAGE;
import static lotto.service.LottoService.lottoNumberLists;
import static lotto.service.OutputService.quantity;

import java.util.List;

public class OutputView {
    public static void printPurchaseMessage() {
        System.out.print("\n" + quantity + PURCHASE_MESSAGE);
    }

    public static void printLottoNumbers() {
        for (List<Integer> list : lottoNumberLists) {
            System.out.println(list);
        }
    }
}
