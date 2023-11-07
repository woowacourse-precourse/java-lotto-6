package lotto;

/**
 * 사용자의 로또가 어떤 상태를 얻을 수 있을지에 대한 열거형입니다.
 * 각각 몇개를 맞추었는지, 가격과 보너스 번호를 맞추었는지에 대한 정보가 담겨 있습니다.
 */
public enum LottoResult {
    
    ZeroMatches(0, 0, "0", false),
    OneMatches(1, 0, "0", false),
    TwoMatches(2, 0 ,"0", false),
    ThreeMatches(3, 5000, "5,000", false),
    FourMatches(4, 50000, "50,000", false),
    FiveMatches(5, 1500000, "1,500,000", false),
    FiveBonusMatches(5, 30000000, "30,000,000", true),
    SixMatches(6, 2000000000, "2,000,000,000", false);

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

    /**
     * LottoResult 열거형을 return 합니다.
     * @param matchCount
     * @param bonusMatch
     * @return 얼마나 맞았는지에 따라 각각 열거형을 return 합니다.
     */
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

    public int getMatch() {
        return match;
    }

    public int getPrice() {
        return price;
    }

    public String getStringPrize() {
        return stringPrice;
    }

    public boolean getBonusMatch() {
        return matchBonus;
    }

}