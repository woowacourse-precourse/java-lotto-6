package lotto;

public class Money {
    private int pMoney;
    private int rMoney;
    Reward[] rewards;
    Money(){
        setPMoney(0);
    }
    Money(int pMoney){
        setPMoney(pMoney);
    }

    private void setPMoney(int pMoney){
        rewards = Reward.values();
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
        double reward = (double)getrMoney()/getPMoney();
        return reward*100;
    }
    public void addReward(double count){
        if(count<3) return;
        count+=0.5;
        int num = (int)count-3;
        rewards[num].addStack();
        setRMoney(getrMoney()+rewards[num].getMoney());
    }

    public void printReward(){
        for(int i=0;i<5;i++){
            System.out.println(rewards[i]);
        }
    }
}
