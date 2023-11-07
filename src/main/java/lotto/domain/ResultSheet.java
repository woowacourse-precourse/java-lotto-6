package lotto.domain;

import java.util.Map;

public class ResultSheet {
    private Map<Rank, Integer> sheet;

    public ResultSheet(Map<Rank, Integer> sheet) {
        this.sheet = sheet;
    }

    public Map<Rank, Integer> getSheet() {
        return sheet;
    }
}
