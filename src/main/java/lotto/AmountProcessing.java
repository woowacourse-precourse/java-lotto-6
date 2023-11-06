package lotto;

public class AmountProcessing {
    public int getLottoCount(int cost){
        return cost/1000;
    }

    public boolean isDivided(int cost){
        if (cost%1000 > 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다. 다시 입력해주세요");
        }
        return true;
    }
}
