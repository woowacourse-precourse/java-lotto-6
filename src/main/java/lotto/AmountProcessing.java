package lotto;

public class AmountProcessing {
    private static final int DIVIDED = 1000;
    public int getLottoCount(int cost){
        return cost/DIVIDED;
    }
}
