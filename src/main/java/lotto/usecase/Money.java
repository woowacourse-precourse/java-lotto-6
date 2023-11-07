package lotto.usecase;

public interface Money {
    int getTicketAmount(int givenMoney) ;
    void checkMoney(int givenMoney) ;
    int saveMoney(int givenMoney);
    double countPrize(int totalPrize) ;
}
