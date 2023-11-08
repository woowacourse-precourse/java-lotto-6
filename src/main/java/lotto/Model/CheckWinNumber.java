package lotto.Model;

import java.util.List;

public class CheckWinNumber {
    private final int MAX = 6;
    private final int BONUS = 5;

    public int checkWinNumber(List<Integer> autoTicket, List<Integer> winNumbers, int bonusNumber ){
        //a는 오토티켓, b는 당첨, c는 보너스번호
        int cnt=0;
        // System.out.println("---- check ----");
        // System.out.println(autoTicket);
        // System.out.println(winNumbers);
        // System.out.println(bonusNumber);


        for(int i=0;i<MAX;i++){
            int winNumber = winNumbers.get(i);
            //System.out.println(winNumber);
            cnt += compareNumber(autoTicket, winNumber);
            
            if(cnt == BONUS) cnt = checkBonus(autoTicket, bonusNumber, cnt);
        }
        // System.out.println("이번 cnt : " + cnt);
        // System.out.println("---- check ----");

        return cnt;
    }

    public int compareNumber(List<Integer> autoTicket,int winNumber){
        int cnt=0;
        for(int i=0;i<MAX;i++){
            if(autoTicket.get(i) == winNumber){
                cnt++;
            }
        }
        return cnt;
    }

    public int checkBonus(List<Integer> autoTicket, int bonusNumber, int cnt){
        for(int i=0;i<MAX;i++){
            if(autoTicket.get(i) == bonusNumber){
                cnt++;
                cnt++;
                //System.out.println("왜 12야?");
            } 
            
        }
        return cnt;
    }
}
