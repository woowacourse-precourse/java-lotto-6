package lotto.domain;

import lotto.util.Constants;
import lotto.view.InputView;

public class CostValidator {
    private static String costInput;
    private static int cost;
    public static int lottoCount;
    private static InputView input;
    public CostValidator(String coststring) {
        while(true){
            try{
                this.costInput = coststring;
                this.cost = Integer.parseInt(coststring);
                isRightNum(cost);
                isRightLotto(cost);
                setLottoNum();
                break;
            }catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(Constants.NUM_IS_INT, e);
            }

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
    public int getLottoCount() {
        return lottoCount;
    }
}
