package lotto.domain;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import lotto.util.Convertor;
import lotto.util.Validator;

public class Money {

    private final int money;
    private final int UNIT = 1000;

    public Money(String inputMoney) {
        int money = Convertor.getInstance().convertToInt(inputMoney);
        Validator.getInstance().validateMoney(money);
        this.money = money;
    }

    public int calculateTicket() {
        return money / UNIT;
    }

    public String calculateRevenue(double rewards) {
        double revenue = (rewards / money) * 100;

        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);

        String str = nf.format(revenue) + "e" + 1;
        revenue = Math.round(Double.parseDouble(str));
        str = nf.format(revenue) + "e" + (-1);

        DecimalFormat df = new DecimalFormat("###,###,###.0");

        return df.format(Double.parseDouble(str)) + "%";
    }

}
