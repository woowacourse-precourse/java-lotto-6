package lotto;

public class LottoService {
    private final int LOTTO_PRICE = 1000;

    public LottoService() {
    }

    public void run() {
        User user = new User();
        user.buyLotto(LOTTO_PRICE);

        Computer computer = new Computer();

        Analyst analyst = new Analyst(user.lottos, computer.getWinningLottoNumber(), computer.getBonusNumber());
        analyst.calculate();

        Output.printLottoResult(analyst.lottoResult, user.money);
    }
}
