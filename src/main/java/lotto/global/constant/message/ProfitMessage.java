package lotto.global.constant.message;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public enum ProfitMessage implements MessageUtil<Double> {


    PROFIT_MESSAGE() {
        public String makeMessage(Double profit) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setMinimumFractionDigits(1);

            String number = decimalFormat.format(profit);

            return String.format("총 수익률은 %s%%입니다.",number);
        }
    };


    @Override
    public String makeMessage(Double number) {
        return null;
    }
}
