package lotto;

import java.util.Arrays;
import java.util.HashMap;

public enum WinnigCase {
    MATCH_THREE(3, "3개 일치 (5,000원)"),
    MATCH_FOUR( 4, "4개 일치 (50,000원)"),
    MATCH_FIVE( 5, "5개 일치 (1,500,000원)"),
    MATCH_FIVE_AND_BONUS(7, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_SIX(6, "6개 일치 (2,000,000,000원)");

    private String contents;
    private int caseNumber;

    private static HashMap<Integer, WinnigCase> winningCaseByIdx = new HashMap<>();
    static {
        Arrays.stream(values()).forEach(e -> winningCaseByIdx.put(e.getCaseNumber(), e));
    }

    private WinnigCase(int caseNumber, String contents) {
        this.caseNumber = caseNumber;
        this.contents = contents;
    }

    public static WinnigCase getByCaseNumber(int caseNumber) {
        return winningCaseByIdx.get(caseNumber);
    }

    public String getContents() {
        return this.contents;
    }

    public int getCaseNumber() {
        return this.caseNumber;
    }

}

