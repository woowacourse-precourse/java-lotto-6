package lotto.domain;

public class LottoResult {

    private final Integer countOfSameNumbers;
    private final Boolean checkBonus;

    public LottoResult(Integer countOfSameNumbers, Boolean checkBonus) {
        this.countOfSameNumbers = countOfSameNumbers;
        this.checkBonus = checkBonus;
    }


}
