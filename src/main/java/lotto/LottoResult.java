
public enum LottoResult {
    
    ZeroMatches(0, 0, "0"),
    OneMatches(1, 0, "0"),
    TwoMatches(2, 0 ,"0"),
    ThreeMatches(3, 5000, "5000"),
    FourMatches(4, 50000, "50.000"),
    FiveMatches(5, 30000000, "30.000.000"),
    SixMatches(6, 2000000000, "2.000.000.000");

    private final int rank;
    private final int price;
    private final String stringPrice;

    LottoResult(int rank, int price, String stringPrice) {
        this.rank = rank;
        this.price = price;
        this.stringPrice = stringPrice;
    }

}