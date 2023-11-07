package lotto.domain;

public class UserLottos {
    private final LottoValidator validator = new LottoValidator();
    private final Lottos lottos = new Lottos();
    private final int amount;

    public UserLottos(int amount) {
        this.amount = amount;
        validator.validateDivideByLottoPrice(amount);
        buyLottos(amount/1000);
    }

    private void buyLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.generate();
        }
    }

    public double calculateRateOfReturn(double winningAmount) {
        return winningAmount/amount*100;
    }
}
