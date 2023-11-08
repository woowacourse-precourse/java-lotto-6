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


    }
}
