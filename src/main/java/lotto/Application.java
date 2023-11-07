package lotto;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                Inputter.getInputter(),
                Printer.getPrinter(),
                new Discriminator(),
                LottoNumberGenerator.getLottoNumberGenerator()
        );

        gameController.startGame();;
    }
}
