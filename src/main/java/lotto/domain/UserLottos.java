package lotto.domain;

public class UserLottos {
    private static final int FIRST_PLACE_PRIZE = 2000000000;
    private static final int SECOND_PLACE_PRIZE = 30000000;
    private static final int THIRD_PLACE_PRIZE = 1500000;
    private static final int FOURTH_PLACE_PRIZE = 50000;
    private static final int FIFTH_PLACE_PRIZE = 5000;

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

    public int getLottoNumbers() {
        return lottos.getSize();
    }

    public Lotto getLotto(int index) {
        return lottos.getLotto(index);
    }

    public int getThreeWins() {
        return lottos.getThreeWins();
    }

    public int getFourWins() {
        return lottos.getFourWins();
    }

    public int getFiveWins() {
        return lottos.getFiveWins();
    }

    public int getFiveAndBonusWins() {
        return lottos.getFiveAndBonusWins();
    }

    public int getSixWins() {
        return lottos.getSixWins();
    }

    public int calculateWinnings() {
        return FIRST_PLACE_PRIZE*getSixWins()
                + SECOND_PLACE_PRIZE*getFiveAndBonusWins()
                + THIRD_PLACE_PRIZE*getFiveWins()
                + FOURTH_PLACE_PRIZE*getFourWins()
                + FIFTH_PLACE_PRIZE*getThreeWins();
    }

    public void countWinningNumber(WinningLotto winningLotto) {
        lottos.countWinningNumber(winningLotto);
    }
}
