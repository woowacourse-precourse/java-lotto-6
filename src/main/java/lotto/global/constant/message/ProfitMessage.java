package lotto.global.constant.message;

import lotto.global.constant.message.MessageUtil;

public enum ProfitMessage implements MessageUtil<Double> {
    PROFIT_MESSAGE() {
        public String makeMessage(Double number) {
            return String.format("총 수익률은 %s%%입니다.",number);
        }
    };


    @Override
    public String makeMessage(Double number) {
        return null;
    }
}
