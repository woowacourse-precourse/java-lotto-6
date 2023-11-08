package lotto.domain;

public record MatchResult(int ballCount, boolean matchBonus) {

    public boolean matchBallCountAndBonus(MatchResult otherMatchResult) {
        return matchOnlyBallCount(otherMatchResult) && otherMatchResult.matchBonus == matchBonus;
    }

    public boolean matchOnlyBallCount(MatchResult otherMatchResult) {
        return otherMatchResult.ballCount == ballCount;
    }
    
}
