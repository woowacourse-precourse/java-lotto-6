package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lotto = new LottoController();
            lotto.main();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
