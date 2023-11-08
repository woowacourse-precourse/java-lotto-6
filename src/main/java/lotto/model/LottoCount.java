package lotto.model;

public class LottoCount {
    private Integer count;

    public LottoCount(Integer purchaseAmount){
        validateUnit(purchaseAmount);
        this.count = purchaseAmount/1000;

    }

    public void validateUnit(Integer purchaseAmount){
        if((purchaseAmount % 1000)!=0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
        }
    }

    public Integer getValue(){
        return count;
    }


}
