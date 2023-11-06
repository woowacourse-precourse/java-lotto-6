package lotto.domain;

public interface LottoGenerateStrategy {
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;
    int SIZE = 6;

    public Lotto generate();
}
