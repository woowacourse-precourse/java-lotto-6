package lotto;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new LottoView(), new LottoMachine());
        controller.playLottoGame();
    }
}
