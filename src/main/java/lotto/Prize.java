package lotto;


import java.util.List;

public class Prize {
    private int total = 0;

    public Prize(List<Integer> winningNumbers, List<Lotto> lottos, int bonusNumber){
        for(Lotto lotto: lottos){
            Rank rank = new Rank(winningNumbers, lotto, bonusNumber);
            this.total += getPrize(rank.toString());

        }
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
            default:
                return 0;
        }
    }

    public double calculate(int payedMoney){
        return (this.total - payedMoney) / payedMoney * 100;
    }
}
