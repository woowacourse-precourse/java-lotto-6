package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.dto.PurchaseHistoryDto;
import lotto.controller.dto.WinningStatisticDto;

public class OutputView {

    private static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String QUANTITY_OUTPUT_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTIC_MESSAGE = "당첨 통계\n---";

    public void printPurchaseInput() {
        System.out.println(PURCHASE_INPUT_MESSAGE);
    }
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

    public void printLineSeparator() {
        System.out.println();
    }

    public void printWinNumberInput() {
        System.out.println(WIN_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printWinningStatistic(WinningStatisticDto dto) {
        System.out.println(STATISTIC_MESSAGE);
        List<Integer> count = dto.getCount();
        System.out.println("3개 일치 (5,000원) - " + count.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + count.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + count.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + count.get(0) + "개");
        System.out.format("총 수익률은 %.1f%%입니다.", dto.getYield());
    }
}
