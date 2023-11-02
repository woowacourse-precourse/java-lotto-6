package lotto;

public class Money {
    private int pMoney;
    private int rMoney;
    Money(){
        setPMoney(0);
    }
    Money(int pMoney){
        setPMoney(pMoney);
    }

    private void setPMoney(int pMoney){
        validate(pMoney);
        this.pMoney = pMoney;
    }
    private void validate(int money){
        if(money%1000 !=0)
            throw new IllegalArgumentException("금액은 1000원으로 나누어 떨어져야 합니다.");
    }
    public int getPMoney(){
        return pMoney;
    }

    public void setRMoney(int rMoney){
        this.rMoney = rMoney;
    }
    public int getrMoney(){
        return rMoney;
    }

    public double getRRate(){
        int reword = getrMoney()*100/getPMoney();
        return (double)(reword)/100;
    }
}
