package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private static final List<String> MATCH_THREE = Arrays.asList("3", "5,000");
    private static final List<String> MATCH_FOUR = Arrays.asList("4", "50,000");
    private static final List<String> MATCH_FIVE = Arrays.asList("5", "1,500,000");
    private static final List<String> MATCH_FIVE_BONUS = Arrays.asList("5", "30,000,000");
    private static final List<String> MATCH_SIX = Arrays.asList("6", "2,000,000,000");
    private final HashMap<List<String>, Integer> results;

    public LottoResult(HashMap<List<String>, Integer> results) {
        this.results = results;
    }

    public LottoResult(int match){

    }

    public HashMap<List<String>, Integer> getResults() {
        return results;
    }
}
