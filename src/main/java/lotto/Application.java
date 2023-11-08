package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lotto = new LottoController();
            lotto.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
