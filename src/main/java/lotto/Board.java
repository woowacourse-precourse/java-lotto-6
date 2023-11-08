package lotto;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Lotto> lottos;
    private List<Match> matches = new ArrayList<>();
    private Float income = 0.0f;
    private Float incomeRate = 0.0f;

    public Board(List<Lotto> lottos){
        this.lottos = lottos;
        initMatch();
    }

    public List<Match> initMatch() {
        this.matches.add(new Match(5000, "3", "3개 일치 (5,000원)"));
        this.matches.add(new Match(50000, "4", "4개 일치 (50,000원)"));
        this.matches.add(new Match(1500000, "5", "5개 일치 (1,500,000원)"));
        this.matches.add(new Match(30000000, "5bonus1", "5개 일치, 보너스 볼 일치 (30,000,000원)"));
        this.matches.add(new Match(2000000000, "6","6개 일치 (2,000,000,000원)"));
        return this.matches;
    }

    public void calculateMatch(){
        for(Match match : matches){
            for(Lotto lotto : lottos){
                if(match.getMatchId().equals(lotto.getLottoId())){
                    match.increaseMatchLottoCount();
                }
            }
        }
    }

    public Float calculateIncome(){
        for(Match match : matches){
            this.income += (match.getReward() * match.getMatchLottoCount());
        }
        return this.income;
    }
    public Float calculateIncomeRate(int consumeMoney){
        this.incomeRate = (float) (this.income * 100 / (float) consumeMoney);
        return this.incomeRate;
    }

    public void printBoard(){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for(Match match : matches){
            System.out.println(match.getPrintString()+ " - " + match.getMatchLottoCount()+"개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", this.incomeRate);
    }


}
