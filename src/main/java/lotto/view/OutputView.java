package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static constant.MessageList.*;

public class OutputView {
    public static void printPurchaseQuantityMessage(int purchaseQuantity) {
        System.out.println(purchaseQuantity + OUTPUT_PURCHASE_QUANTITY_MESSAGE);
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        List<String> lotto = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(lotto);
    }
}
