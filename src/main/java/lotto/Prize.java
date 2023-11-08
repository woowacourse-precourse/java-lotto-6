package lotto;


import java.util.List;

public class Prize {
    private double totalPrize = 0;
    private int[] winningCount = new int[6];
    private double totalReturn = 0;
    private int money = 0;

    public Prize(int money, List<Integer> winningNumbers, List<Lotto> lottos, int bonusNumber){
        this.money = money;

        for(Lotto lotto: lottos){
            Rank rank = new Rank(winningNumbers, lotto, bonusNumber);
            this.totalPrize += getPrize(rank.toString());
            countWinningLotto(rank.toString());
        }

        this.totalReturn = calculateReturn();
    }

    private int getPrize(String rank){
        switch(rank){
            case "FIRST":
                return 2000000000;
            case "SECOND":
                return 30000000;
            case "THIRD":
                return 1500000;
            case "FOURTH":
                return 50000;
            case "FIFTH":
                return 5000;
            default:
                return 0;
        }
    }

    private void countWinningLotto(String rank){
        switch(rank){
            case "FIRST":
                this.winningCount[5]++;
                break;
            case "SECOND":
                this.winningCount[4]++;
                break;
            case "THIRD":
                this.winningCount[3]++;
                break;
            case "FOURTH":
                this.winningCount[2]++;
                break;
            case "FIFTH":
                this.winningCount[1]++;
                break;
            default:
                this.winningCount[0]++;
        }
    }

    public double calculateReturn(){
        return  100 - ((this.money - this.totalPrize) / this.money * 100);
    }

    private static String matchMoney(int rank){
        switch (rank){
            case 1: return "5,000";
            case 2: return "50,000";
            case 3: return "1,500,000";
            case 4: return "30,000,000";
            case 5: return "2,000,000,000";
            default: return "";
        }
    }

    public void printResult(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for(int rank=1; rank < 6;rank++){
            System.out.println((rank+2)+"개 일치 ("+matchMoney(rank)+"원) - "+winningCount[rank]+" 개");
        }

        System.out.println("총 수익률은 " + this.totalReturn +"%입니다.");

    }
}
