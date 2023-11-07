package lotto;
public enum LottoConfig {
    Fifth_Place(3,"3개 일치 (5,000원) - ",5000),
    Fourth_Place(4,"4개 일치 (50,000원) - ",50000),
    Third_Place(5,"5개 일치 (1,500,000원) - ",1500000),
    Second_Place(6,"5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    First_Place(7,"6개 일치 (2,000,000,000원) - ",2000000000);


    private final Integer match;
    private final String message;
    private final Integer price;
    LottoConfig(int match, String message, int price) {
        this.match = match;
        this.message = message;
        this.price = price;
    }

    public Integer match() {
        return match;
    }

    public String message() {
        return message;
    }

    public Integer price() {
        return price;
    }
}
