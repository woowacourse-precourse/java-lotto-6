package lotto.domain;

public interface LotteryOffice {
    Money LOTTO_PRICE = new Money(1000);
    int LOTTO_START_NUMBER = 1;
    int LOTTO_END_NUMBER = 45;
    int LOTTO_LENGTH = 6;
    boolean sellTo(User user);

}
