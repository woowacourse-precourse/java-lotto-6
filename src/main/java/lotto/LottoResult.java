package lotto;

import java.util.List;

public class LottoResult {
    private final List<Integer> counted;
    private final List<Boolean> checked;

    public LottoResult(List<Integer> counted, List<Boolean> checked) {
        this.counted = counted;
        this.checked = checked;
    }
}