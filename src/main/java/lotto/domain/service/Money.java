package lotto.domain.service;

public interface Money {
    int getTicketAmount(int givenMoney) ;
    void checkMoney(int givenMoney) ;
    int saveMoney(int givenMoney);
    double countPrize(int totalPrize) ;
}
