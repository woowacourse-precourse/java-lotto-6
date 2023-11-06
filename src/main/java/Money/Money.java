package Money;

import lotto.Lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Money {
    public void calculateRevenue(int lottoBuy, long correctMoney) {
        double revenue = ((double)correctMoney / (double)lottoBuy) * 100;
        revenue = Math.round(revenue * 100.0) / 100.0;
        DecimalFormat formatter = new DecimalFormat("#,##0.0#");
        String totalRevenue = formatter.format(revenue);
        System.out.println("총 수익률은 " + totalRevenue + "%입니다.");
    }
}
