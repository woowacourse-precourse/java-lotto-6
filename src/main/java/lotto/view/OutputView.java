package lotto.view;

public class OutputView {

    private static final String PRINT_LOTTOS_COUNT = "개를 구매했습니다.";

    public void printTicketingLottos(int count, String lottos) {
        System.out.println(count + PRINT_LOTTOS_COUNT);
        System.out.println(lottos);
    }
}
