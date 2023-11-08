package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount=InputView.getPurchaseAmount();
        int numberOfLotto=purchaseAmount/1000;
        OutputView.printNumberOfLotto(numberOfLotto);

        List<Lotto> lottoTickets=new ArrayList<>();

        for(int i=0;i<numberOfLotto;i++){
            Set<Integer> uniqueNumbers=new HashSet<>();
            while(uniqueNumbers.size()<6){
                int randomNumber=Randoms.pickNumberInRange(1,45);
                uniqueNumbers.add(randomNumber);
            }

            Lotto lottoTicket=new Lotto(new ArrayList<>(uniqueNumbers));
            lottoTickets.add(lottoTicket);
        }

        for (Lotto lottoTicket: lottoTickets){
            OutputView.printLottoTicketNumbers(lottoTicket);
        }

        List<Integer> winningNumbers=new ArrayList<>();
        String[] winningNumbersInput=InputView.getWinningNumbers().split(",");
        for(String winningNumber:winningNumbersInput){
            winningNumbers.add(Integer.parseInt(winningNumber));
        }

        int bonusNumber=InputView.getBonusNumber();

        for(Lotto lottoTicket: lottoTickets){
            int countForMatchingWinningNumbers=0;
            int countForMatchingBonusNumbers=0;
            List<Integer> ticketNumbers=lottoTicket.getNumbers();
            for(int ticketNumber: ticketNumbers){
                if(winningNumbers.contains(ticketNumber)){
                    countForMatchingWinningNumbers++;
                }
            }
            if(ticketNumbers.contains(bonusNumber)){
                countForMatchingBonusNumbers++;
            }
        }




    }
}
