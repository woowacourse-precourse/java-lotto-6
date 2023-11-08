package lotto.dto;

public class WinningStatisticDTO {
    private final Integer matchedThree;
    private final Integer matchedFour;
    private final Integer matchedFive;
    private final Integer matchedFiveAndBonus;
    private final Integer matchedSix;

    public WinningStatisticDTO(Integer matchedThree, Integer matchedFour, Integer matchedFive, Integer matchedFiveAndBonus,
                                Integer matchedSix) {
        this.matchedThree = matchedThree;
        this.matchedFour = matchedFour;
        this.matchedFive = matchedFive;
        this.matchedFiveAndBonus = matchedFiveAndBonus;
        this.matchedSix = matchedSix;
    }

    public Integer getMatchedThree() {
        return matchedThree;
    }

    public Integer getMatchedFour() {
        return matchedFour;
    }

    public Integer getMatchedFive() {
        return matchedFive;
    }

    public Integer getMatchedFiveAndBonus() {
        return matchedFiveAndBonus;
    }

    public Integer getMatchedSix() {
        return matchedSix;
    }
}
