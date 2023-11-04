package lotto.domain;

import java.util.Arrays;

public enum Result {
    FIRST(6, 2_000_000_000, 0),
    SECOND(5, 30_000_000, 0),
    THIRD(5, 1_500_000, 0),
    FOURTH(4, 50_000, 0),
    FIFTH(3, 5_000, 0),
    NONE(0, 0, 0);

    private final int matchCount;
    private final int winningMoney;
    private final int status;

    Result(int matchCount, int winningMoney, int status) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.status = status;
    }

//    public static getLottoResult(Lottos lottos, UserNumbers userNumbers, UserNumbers bonus) {
//        return Arrays.stream(Result.values())
//            .filter(result -> result.matchCount == lottos.getLottos().stream()
//                .filter(lotto -> lotto.match(userNumbers))
//                .count())
//            .findFirst()
//            .orElse(NONE);
//        }
//



}
