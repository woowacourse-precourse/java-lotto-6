package lotto;

import java.text.DecimalFormat;

public enum reward {
    first(2000000000),
    second(30000000),
    third(1500000),
    fourth(50000),
    fifth(5000)
    ;

    public int money;

    reward(int money) {
        this.money = money;
    }

    public String formatMoney(){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(this.money);
    }
}
