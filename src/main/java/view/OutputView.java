package view;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    public static void outputTotalPurchaseQuantity(int totalPurchaseQuantity) {
        String message = String.format(OutputMessages.TOTAL_PURCHASED_QUANTITY.getMessage(), totalPurchaseQuantity);
        System.out.println(message);
    }

    public static void outputLottoList(List<Lotto> lottoList) {
        lottoList.stream().forEach(Lotto::printLottoNumbers);
    }
}
