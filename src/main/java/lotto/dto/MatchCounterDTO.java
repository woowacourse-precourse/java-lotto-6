package lotto.dto;

public class MatchCounterDTO {
    private final Integer countLotto;
    private final Integer countBonus;

    public MatchCounterDTO(Integer countLotto, Integer countBonus) {
        this.countLotto = countLotto;
        this.countBonus = countBonus;
    }

    public Integer getCountLotto() {
        return countLotto;
    }

    public Integer getCountBonus() {
        return countBonus;
    }
}
