package lotto.model;

public class LottoManager {
    private final Token token;

    public LottoManager(int amount) {
        this.token = new Token(amount);
    }
}
