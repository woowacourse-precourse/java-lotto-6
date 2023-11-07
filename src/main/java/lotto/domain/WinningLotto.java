package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    private int getMatchCount(Lotto ticket) {
        return (int) ticket.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }
    private boolean matchBonus(Lotto ticket) {
        return ticket.getNumbers().contains(bonusNumber);
    }
    public static List<Integer> convertToIntegerList(String str) {
        String[] splitStr = str.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : splitStr) {
            numbers.add(Integer.parseInt(s.trim()));
        }
        return numbers;
    }
    // 당첨 결과 계산 로직 작성 필요
    public LottoResult compare(List<Lotto> tickets) {
        LottoResult result = new LottoResult();
        for (Lotto ticket : tickets) {
            int matchCount = getMatchCount(ticket);
            boolean matchBonus = matchBonus(ticket);
            System.out.println("matchCount: " + matchCount + ", matchBonus: " + matchBonus);
            result.add(LottoEnum.LottoRank.valueOf(matchCount, matchBonus));
        }
        return result;
    }
}
