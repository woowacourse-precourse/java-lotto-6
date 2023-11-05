package lotto.domain;

public class LottoBuy {
    private String money;
    private int lottoNum;
    private static int MONEY_UNIT = 1000;
    private static final String LOTTO_MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 로또 구입 금액 입력은 1,000원 단위로 입력해야합니다.";

    public LottoBuy(String money, int lottoNum){
        validate(money);
        this.money = money;
        this.lottoNum = lottoNum;
    }

    public String getMoney() {
        return this.money;
    }

    public int getLottoNum() {
        return this.lottoNum;
    }

    private void validate(String money) {
        if(Integer.parseInt(money) % MONEY_UNIT != 0){
            throw new IllegalArgumentException(LOTTO_MONEY_UNIT_ERROR_MESSAGE);
        }
    }
}
