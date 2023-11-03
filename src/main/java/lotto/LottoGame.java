package lotto;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int WINNING_NUMBERS_COUNT = 6;
    private static final int BONUS_NUMBER_COUNT = 1;

    public int gameCount;

    public void setLottoGame(int number){
        this.gameCount = number;
    }

    public void validatePurchaseAmount(int price){
        if (price % LOTTO_PRICE == 0){
            setLottoGame(price % LOTTO_PRICE);
        } else {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

}
