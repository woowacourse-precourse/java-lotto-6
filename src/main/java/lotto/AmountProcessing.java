package lotto;

public class AmountProcessing {
    public int getLottoCount(int cost){
        return cost/1000;
    }

    public boolean isDivided(int cost){
        if (cost%1000 > 0){
            throw new IllegalArgumentException();
        }
        return true;
    }
}
