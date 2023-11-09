package lotto.model;

public interface LottoGenerator {
    int LOTTO_TICKET_PRICE = 1000;
    
    Lotto generate();
}