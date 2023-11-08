package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.playLotto();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
