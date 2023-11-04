package lotto.domain;

public class LottoMachine {
    public Lotto issueLotto() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return new Lotto(randomNumberGenerator.generateNumbers());
    }

}
