package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Rank {
    FIRST_PLACE(6,0,2000000000),
    SECOND_PLACE(5,1,30000000),
    THIRD_PLACE(5,0,1500000),
    FOURTH_PLACE(4,0,50000),
    FIFTH_PLACE(3,0,5000),
    NOT_WIN(0,0,0);

    private final int hit;
    private final int bonusHit;
    private final int prizeMoney;

    Rank(int hit,int bonus, int prizeMoney){
        this.hit = hit;
        this.bonusHit = bonus;
        this.prizeMoney = prizeMoney;
    }
    public int getHit(){
        return hit;
    }

    public int getBonusHit(){
        return bonusHit;
    }

    public int getPrizeMoney(){
        return prizeMoney;
    }

    public String getStatus(){
        String formattedPrizeMoney = formattingNum(getPrizeMoney());
        if(bonusHit ==1){
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)",getHit(),formattedPrizeMoney);
        }
        return String.format("%d개 일치 (%s원)",getHit(),formattedPrizeMoney);
    }
    private String formattingNum(int num){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format((long)num);
    }

    static Rank getRank(int hit,int bonus){
        if(hit<3){
            return NOT_WIN;
        }
        return Arrays.asList(Rank.values()).stream()
                .filter(rank -> rank.getHit()==hit)
                .filter(rank -> rank.getBonusHit()==bonus)
                .findAny().get();
    }
}
