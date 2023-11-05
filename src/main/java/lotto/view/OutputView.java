package lotto.view;

public class OutputView {
    private static final String PRINT_LOTTO_AMOUNT_SENTENCE = "개를 구매했습니다.";
    private static final String EMPTY_LINE = "";

    public static void printLottoAmount(int amount) {
        System.out.println(EMPTY_LINE);

        StringBuilder sb = new StringBuilder();
        sb.append(amount);
        sb.append(PRINT_LOTTO_AMOUNT_SENTENCE);
        System.out.println(sb);
    }

}
