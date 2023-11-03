package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManager lottoManager = null;

        boolean error = true;

        while (error) {
            try {
                lottoManager = LottoManager.priceInput();
                error = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
