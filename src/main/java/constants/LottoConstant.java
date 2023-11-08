package constants;

public enum LottoConstant {
    CORRECT_SIX(6),
    CORRECT_FIVE(5),
    CORRECT_FOUR(4),
    CORRECT_THREE(3),
    FIRST_PLACE(4),
    SECOND_PLACE(3),
    THIRD_PLACE(2),
    FOURTH_PLACE(1),
    FIFTH_PLACE(0),
    FIRST_REWARD(2000000000),
    SECOND_REWARD(30000000),
    THIRD_REWARD(1500000),
    FOURTH_REWARD(50000),
    FIFTH_REWARD(5000);
    private int result;
    LottoConstant(int result){
        this.result=result;
    }
    public int getResult(){
        return result;
    }
}
