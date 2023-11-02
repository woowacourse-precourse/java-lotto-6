package view;

import enums.StringEnums;
import enums.WinType;

public class OutputView {

    private static final String PURCHASE_RESULT = StringEnums.PURCHASE_RESULT.toString();
    private static final String STATISTICS_HEADER = StringEnums.STATICS_HEADER.toString();
    private static final String EARN_RATE_HEADER = StringEnums.EARN_RATE_HEADER.toString();
    private static final String EARN_RATE_FOOTER = StringEnums.EARN_RATE_FOOTER.toString();

    public void purchaseResult(Integer amount) {
        String s = amount + PURCHASE_RESULT;
        System.out.println(s);
    }

    public void resultHeader() {
        System.out.println(STATISTICS_HEADER);
    }

    public void earnRate(String s) {
        System.out.println(EARN_RATE_HEADER + s + EARN_RATE_FOOTER);
    }

    public void printResult(int frequency, WinType e) {
        String resultString = e.getString() + frequency + StringEnums.UNIT;
        System.out.println(resultString);
    }
}
