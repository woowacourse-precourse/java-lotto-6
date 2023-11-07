package lotto.domain;

import lotto.util.Constants;

public class CostValidator {
    private static String costInput;
    private static int cost;
    public static int lottoCount;
    public CostValidator(String coststring) {
        try{
            this.costInput = coststring;
            this.cost = Integer.parseInt(coststring);
            isRightNum(cost);
            isRightLotto(cost);
            setLottoNum();
            return;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.NUM_IS_INT);
        }

    }
    public void isRightNum(int cost){
        if(cost<=0){
            throw new IllegalArgumentException(Constants.COST_WRONG_ERROR);
        }
    }
    public void isRightLotto(int cost){
        if(cost%1000!=0){
            throw new IllegalArgumentException(Constants.COST_ERROR);
        }
    }
    public void setLottoNum(){
        this.lottoCount = cost / 1000;
    }
}
