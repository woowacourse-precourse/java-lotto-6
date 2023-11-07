package lotto;

public class Print {
    private static final String LOTTO_COUNT_PRINT_MESSAGE = "개를 구매했습니다.";
    public void printLottoCount(int count) {
        System.out.println(count + LOTTO_COUNT_PRINT_MESSAGE);
    }

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
