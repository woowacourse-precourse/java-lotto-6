package util.message;

import util.EnumUtil;

public enum OutputMessage implements EnumUtil<String, String>{
    LOTTO_PURCHASE_COUNT("\n%d개를 구매했습니다."),
    WINNING_STATICS("\n당첨통계\n" + "---"),
    TOTAL_RATE_OF_PROFIT_START("총 수익률은 "),
    TOTAL_RATE_OF_PROFIT_END("%입니다.");

    private final String message;

    OutputMessage(final String message){
        this.message = message;
    }


    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
