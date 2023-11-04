package lotto.domain;

public class CostValidator {
    private static String COSTSTRING;
    private static int COST;
    public static int LottoNum;
    public CostValidator(String coststring) {
        while(true){
            try{
                this.COSTSTRING = coststring;
                this.COST = Integer.parseInt(coststring);
                isRightNum(COST);
                isRightLotto(COST);
                setLottoNum();
            }catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("숫자를 입력해 주십시오");
            }
        }
    }
    public void isRightNum(int cost){
        if(cost<=0){
            throw new IllegalArgumentException("음수가 아닌 양수를 입력해 주십시오");
        }
    }
    public void isRightLotto(int cost){
        if(cost%1000!=0){
            throw new IllegalArgumentException("1000원 단위의 입력만 가능합니다.");
        }
    }
    public void setLottoNum(){
        this.LottoNum = COST%1000;
    }
}
