package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static List<Integer> lottoResult = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    private int matchCount;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> getLottoResult() {
        System.out.println(lottoResult);
        Collections.sort(lottoResult);
        System.out.println(lottoResult);
        return lottoResult;
    }

    private void setLottoResult(int matchCount) {
        if (matchCount == 6)
            removeLastElement();
        lottoResult.add(matchCount);
    }

    private void removeLastElement() {
        if (!lottoResult.isEmpty()) {
            lottoResult.remove(lottoResult.size() - 1); // 마지막 요소 삭제
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        setLottoResult(matchCount);
        this.matchCount = matchCount;
    }

}
