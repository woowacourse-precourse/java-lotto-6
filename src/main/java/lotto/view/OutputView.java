package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.dto.response.PurchaseHistoryDto;

public class OutputView {

    private static final String QUANTITY_OUTPUT_MESSAGE = "개를 구매했습니다.";

    public void printPurchaseHistory(PurchaseHistoryDto purchaseHistoryDto) {
        printCount(purchaseHistoryDto);
        List<List<Integer>> lottoNumbers = purchaseHistoryDto.getLottoNumbers();
        for (List<Integer> lottoNumber : lottoNumbers) {
            printLottoNumberHistory(lottoNumber);
        }
    }

    private void printCount(PurchaseHistoryDto purchaseHistoryDto) {
        System.out.println(purchaseHistoryDto.getCount() + QUANTITY_OUTPUT_MESSAGE);
    }

    private void printLottoNumberHistory(List<Integer> lottoNumber) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(getLottoNumber(lottoNumber));
        builder.append("]");
        System.out.println(builder);
    }

    private String getLottoNumber(List<Integer> lottoNumber) {
        return lottoNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
