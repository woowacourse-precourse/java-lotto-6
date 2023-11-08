package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.dto.PurchaseHistoryDto;
import lotto.controller.dto.WinningStatisticDto;
import lotto.model.domain.vo.Rank;

public class OutputView {

    private static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String QUANTITY_OUTPUT_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTIC_MESSAGE = "당첨 통계\n---";
    private static final String YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.";

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
        RankMessage[] rankMessages = RankMessage.values();
        for (int i = 4; i >= 0; i--) {
            System.out.format(rankMessages[i].getMessage(), count.get(i));
        }
        System.out.format(YIELD_MESSAGE, dto.getYield());
    }
}
