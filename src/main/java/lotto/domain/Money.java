package lotto.domain;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Money {

    private final int money;
    private final int UNIT = 1000;

    public Money(String inputMoney) {
        int money = convertToInt(inputMoney);
        validateUnit(money);
        this.money = money;
    }

    private int convertToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private void validateUnit(int money) {
        if (money % UNIT != 0 || money == 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }

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
