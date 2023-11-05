package lotto;

public class Money {
    private int pMoney;
    private int rMoney;
    private static final int[] REWARD = new int[]{5000,50000,1500000,30000000,2000000000};
    private static final String[] REWARDTEXT = new String[]{
            "3개 일치 (5,000원)",
            "4개 일치 (50,000원)",
            "5개 일치 (1,500,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)",
            "6개 일치 (2,000,000,000원)"
    };
    private static int[] REWARDDATA = new int[]{0,0,0,0,0};
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
        int reward = getrMoney()*100/getPMoney();
        if(reward%10>=5) reward+=10;
        reward/=10;
        return (double)(reward)/10;
    }
    public void addReward(double count){
        if(count<3) return;
        count+=0.5;
        int num = (int)count-3;
        REWARDDATA[num]++;
        setRMoney(getrMoney()+REWARD[num]);
    }

    public void printReward(){
        for(int i=0;i<5;i++){
            System.out.println(REWARDTEXT[i]+" - "+REWARDDATA[i]+"개");
        }
    }
}
