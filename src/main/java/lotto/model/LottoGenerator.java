package lotto.model;

public interface LottoGenerator {
    int LOTTO_TICKET_PRICE = 1000;

    // 로또 1개를 만들어서 반환
    Lotto generate();
}