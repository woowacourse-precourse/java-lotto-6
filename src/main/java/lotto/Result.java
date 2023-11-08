package lotto;

public enum Result {
    MATCH_SIX(0,2000000000),
    MATCH_FIVE_AND_BONUS(0,30000000),
    MATCH_FIVE(0,1500000),
    MATCH_FOUR(0,50000),
    MATCH_THREE(0,5000);
    private int count;
    private int amount;
    Result(int count, int amount){
        this.count = count;
        this.amount = amount;
    }
    public int getCount(){
        return count;
    }
    public int getAmount(){
        return amount;
    }
    public void increaseCount(){
        this.count++;
    }

}
