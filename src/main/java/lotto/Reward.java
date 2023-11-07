package lotto;

enum Reward{
    FIFTH(5000,"3개 일치 (5,000원)"),
    FOURTH(50000,"4개 일치 (50,000원)"),
    THIRD(1500000,"5개 일치 (1,500,000원)"),
    SECOND(30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    WINNER(2000000000,"6개 일치 (2,000,000,000원)");

    private final int money;
    private final String text;
    private int stack;
    Reward(int money,String text){
        this.money = money;
        this.text = text;
        this.stack = 0;
    }

    public int getMoney(){
        return money;
    }
    public String getText(){
        return text;
    }
    public int getStack(){
        return stack;
    }
    public void addStack(){
        stack++;
    }
    @Override
    public String toString() {
        return getText()+" - "+getStack()+"개";
    }
}