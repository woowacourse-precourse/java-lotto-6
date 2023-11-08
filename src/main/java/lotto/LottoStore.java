package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoStore {
    private List<Lotto> tickets;
    private Map<Integer, Integer> winningResult;
    private Map<Integer, Integer> prizeMoneys;

    LottoStore(){
        this.tickets = new ArrayList<>();
        this.winningResult = new HashMap<>();
        this.prizeMoneys = new HashMap<>();
    }

    public void issueLottoTicket(int number){
        for(int issueCount = 0; issueCount < number; issueCount++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);

            Lotto lottoTicket = new Lotto(lottoNumbers);
            lottoTicket.printLottoNumbers();
            tickets.add(lottoTicket);
        }
    }


    public void confirmWin(List<Integer> winnigNumber, int bonusNumber){
        for(Lotto ticket:tickets){
            int result = ticket.checkPrize(winnigNumber);
            System.out.println("checkprize" + result);
            ticket.printLottoNumbers();
            System.out.println(winnigNumber);
            result*=2;

            if (result==10 && ticket.checkBonus(bonusNumber)){
                result++;
            }

            winningResult.put(result, winningResult.getOrDefault(result, 0)+1);
        }
    }

    public void setPrizeMoneys(){
        prizeMoneys.put(3*2, 5000);
        prizeMoneys.put(4*2, 50000);
        prizeMoneys.put(5*2, 1500000);
        prizeMoneys.put(5*2+1, 30000000);
        prizeMoneys.put(6*2, 2000000000);
    }

    public void printTotalPrize(){
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int key=0; key<=12; key++){
            if(prizeMoneys.containsKey(key)){
                String result = key/2 +"개 일치";
                if(key%2!=0){
                    result += ", 보너스 볼 일치";
                }
                result +=" (" + String.format("%,d", prizeMoneys.get(key)) + "원) - ";
                result +=winningResult.getOrDefault(key,0);
                System.out.println(result);
            }
        }
    }

    public void printPrizeRate(int ticketPrice){
        int totalPrize = 0;
        double earingRate;

        for(int key : prizeMoneys.keySet()){
            totalPrize+=winningResult.getOrDefault(key,0)*prizeMoneys.get(key);
        }

        earingRate = (double)totalPrize / (tickets.size()*ticketPrice) * 100.0;
        System.out.println("총 수익률은 "+ (Math.round(earingRate*100)/100.0)+"%");

    }
}
