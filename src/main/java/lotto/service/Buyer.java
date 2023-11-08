package lotto.service;

import static lotto.view.View.showLottoTickets;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class Buyer {
    //로또 서비스 같은 기능
    private static Buyer buyer = new Buyer();
    private final List<Lotto> lottoTickets;

    private Buyer(){
        lottoTickets = new ArrayList<>();
    }

    public static Buyer getInstance(){
        return buyer;
    }
    public static int calculateLottoTickets(PurchaseAmount purchaseAmount){
        //금액을 쪼개서 몇개 로또를 살 수 있는지 리턴
        int lottoTicketCount = purchaseAmount.getPurchaseAmount() / 1000;
        return lottoTicketCount;
    }

    private List<Integer> generateLottoNumbers(){
        List<Integer>lottoTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoTicket;
    }

    public void buyLottoTickets(int lottoTicketCount){
        for(int i=0;i<lottoTicketCount;i++){
            Lotto lotto = new Lotto(generateLottoNumbers());
            lottoTickets.add(lotto);
        }
        showLottoTickets(lottoTickets);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
