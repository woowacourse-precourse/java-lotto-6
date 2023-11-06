package lotto.view;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_PRINT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_PRINT_MESSAGE = "당첨 통계\n---";

    public void printNumberOfLottosPurchased(int numberOfLottos) {
        System.out.println(numberOfLottos + NUMBER_OF_LOTTOS_PURCHASED_PRINT_MESSAGE);
    }
}
