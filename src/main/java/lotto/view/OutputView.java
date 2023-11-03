package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.dto.response.PurchaseHistoryDto;

public class OutputView {

    private static final String QUANTITY_OUTPUT_MESSAGE = "개를 구매했습니다.";

    public void printPurchaseHistory(PurchaseHistoryDto purchaseHistoryDto) {
        System.out.println(purchaseHistoryDto.getCount() + QUANTITY_OUTPUT_MESSAGE);
        List<List<Integer>> lottoNumbers = purchaseHistoryDto.getLottoNumbers();
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.print("[");
            String s = lottoNumber.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.print(s);
            System.out.print("]");
            System.out.println();
        }
    }
}
