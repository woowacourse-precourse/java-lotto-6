package lotto.model;

import java.util.List;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchingCount;
    private final int amount;


    Prize(int matchingCount, int amount) {
        this.matchingCount = matchingCount;
        this.amount = amount;
    }



    public String getDescription(){
        if(this==FIRST) return "1등";
        if(this==SECOND) return "2등";
        if(this==THIRD) return "3등";
        if(this==FOURTH) return "4등";
        if(this==FIFTH) return "5등";
        if(this==NONE) return "꽝";
        return "";
    }

    public int getAmount() {
        return amount;
    }

    public boolean match(List<Integer> winningNumbers, int bonusNumber, List<Integer> lottoNumbers) {
        long matchingCount = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        if (matchingCount == 5 && lottoNumbers.contains(bonusNumber)) {
            return this == SECOND;
        }

        return matchingCount == this.matchingCount;
    }
}
