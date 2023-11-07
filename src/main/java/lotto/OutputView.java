package lotto;

import static lotto.Constant.FIRST;
import static lotto.Constant.ZERO;

import java.util.List;
import java.util.Map;

public class OutputView {
    private final String MONEY = "구매금액을 입력해주세요.";
    private final String ISSUE = "개를 구매했습니다.";
    private final String NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String LUCKY = "보너스 번호를 입력해 주세요.";
    private final String EARNING_STATICS = "당첨 통계";
    private final String AMOUNT = "총 수익률은,%입니다.";
    private final String BORDER = "---";
    private final String DELIMiTER = ",";


    private void println(String message) {
        System.out.println(message);
    }

    private void println() {
        System.out.println();
    }

    private void message(String[] messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    private void message(List<Integer> list) {
        System.out.println(list);
    }

    public void moneyInput() {
        println(MONEY);
    }

    public void issueNotice(int count) {
        println(String.format("%d%s", count, ISSUE));
    }

    public void getIssues(Map<Integer, List<Integer>> lottoTable) {
        for (List<Integer> list : lottoTable.values()) {
            message(list);
        }
        println();
    }

    public void numbersInput() {
        println(NUMBERS);
    }

    public void luckyInput() {
        println(LUCKY);
    }

    public void staticsResult(Map<Integer, Long> gainStatics) {
        ResultMessage resultMessage = new ResultMessage();
        earningOutput();
        String[] messages = resultMessage.makingStatics(gainStatics);
        message(messages);
    }

    public void earningResult(String message) {
        String[] parts = AMOUNT.split(DELIMiTER);
        int end = parts.length - FIRST;
        String sentence = String.format("%s %s%s", parts[ZERO], message, parts[end]);
        println(sentence);
    }

    public void earningOutput() {
        println(EARNING_STATICS);
        border();
    }

    public void border() {
        println(BORDER);
    }
}