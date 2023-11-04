package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class WinningStatics {
    public List<Integer> Numbers = new ArrayList<>();
    public int[] MatchNum = new int[5];
    public enum NumberOfMatches{
        Three(0,"3개 일치 (5,000원) - ", 5000,0),
        Four(1,"4개 일치 (50,000원) - ",50000,0),
        Fifth(2,"5개 일치 (1,500,000원) - ",1500000,0),
        FifthPlusBonus(3, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000,0),
        Sixth(4,"6개 일치 (2,000,000,000원) - ",2000000000,0);
        private int Num,value,Count;
        private String detail;
        NumberOfMatches(int Num, String detail, int value, int Count) {
            this.Num=Num;
            this.detail=detail;
            this.value=value;
            this.Count=Count;
        }
    }
    public int[] HowMatch(List<Lotto> Lottos,List<Integer> winninglotto,int BonusNum){
        for (Lotto lotto : Lottos) {
            Numbers = lotto.getNumbers();
            int Count = CompareTwoList(winninglotto,BonusNum);
            if(Count>=0){
                MatchNum[Count] = MatchNum[Count]+1;
            }
        }
        return MatchNum;
    }
    public int CompareTwoList(List<Integer> winninglotto,int BonusNum){
        int i =0;
        for(Integer WinVal : winninglotto){
            if(Numbers.contains(WinVal)){
                i++;
            }
        }
        if(i>=3) {
            return CompareResult(i,BonusNum);
        }
        return -1;
    }
    public int CompareResult(int i,int Bonus){
        if(i==6){
             return 4;
        }
        if(i==5){
            if(checkBonus(Bonus)){
                i=6;
            }
        }
        if(i>=3){
            return i-3;
        }
        return -1;
    }
    public boolean checkBonus(int Bonus){
        return Numbers.contains(Bonus);
    }
}
