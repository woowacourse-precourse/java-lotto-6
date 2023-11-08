package lotto.domain;

public class Buy {
    private final Integer money;
    private final Integer count;

    public Buy(String money) throws IllegalArgumentException {
        int parseMoney = validateParse(money);
        validateMoney(parseMoney);
        this.money = parseMoney;
        this.count = findCount(parseMoney);
    }

    private int validateParse(String money){
        try {
           int parseNumber = Integer.parseInt(money);
            return parseNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] Enter only Numeric type");
        }
    }

    private void validateMoney(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] Enter units of 1000");
        }
    }

    private Integer findCount(Integer money) {
        return money / 1000;
    }

    public Integer getCount() {
        return count;
    }

    public int getMoney(){
        return money;
    }
}
