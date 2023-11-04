package lotto;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void playGame() {
        requestMoney();
    }

    public void requestMoney(){
        try{
            outputView.printMoneyInputMessage();
            Money money = lottoService.changeStringToInt(inputView.getMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
