package lotto;

public enum LottoResult {
    
    ZeroMatches(0, 0, "0", false),
    OneMatches(1, 0, "0", false),
    TwoMatches(2, 0 ,"0", false),
    ThreeMatches(3, 5000, "5000", false),
    FourMatches(4, 50000, "50.000", false),
    FiveMatches(5, 1500000, "1.500.000", false),
    FiveBonusMatches(5, 30000000, "30.000.000", true),
    SixMatches(6, 2000000000, "2.000.000.000", false);

    private final int match;
    private final int price;
    private final String stringPrice;
    private final boolean matchBonus;

    LottoResult(int match, int price, String stringPrice, boolean matchBonus) {
        this.match = match;
        this.price = price;
        this.stringPrice = stringPrice;
        this.matchBonus = matchBonus;
    }

    public static LottoResult getResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 0) {
            return ZeroMatches;
        }
        if (matchCount == 1) {
            return OneMatches;
        }
        if (matchCount == 2) {
            return TwoMatches;
        }
        if (matchCount == 3) {
            return ThreeMatches;
        }
        if (matchCount == 4) {
            return FourMatches;
        }
        if (matchCount == 5 && !bonusMatch) {
            return FiveMatches;
        }
        if (matchCount == 5 && bonusMatch) {
            return FiveBonusMatches;
        }
        if (matchCount == 6) {
            return SixMatches;
        }
        throw new IllegalArgumentException("유효하지 않은 결과: " + matchCount);
    }

}