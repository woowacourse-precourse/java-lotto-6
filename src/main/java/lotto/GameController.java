package lotto;

public class GameController {
    private Pocket pocket;
    private Inputter inputter;
    private Printer printer;
    private Discriminator discriminator;
    private LottoNumberGenerator lottoNumberGenerator;
    private int money;

    public GameController(Inputter inputter, Printer printer, Discriminator discriminator,
            LottoNumberGenerator lottoNumberGenerator) {
        this.inputter = inputter;
        this.printer = printer;
        this.discriminator = discriminator;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

}
