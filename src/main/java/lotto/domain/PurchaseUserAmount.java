package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Constant.*;

public class PurchaseUserAmount extends Amount{

    private List<Lotto> userLottoes;
    private final int lottoTicketCount;

    public PurchaseUserAmount(int amount) {
        super(amount);
        lottoTicketCount = this.amount % this.unitOfMoney;
        makeLotto();
    }

    private void makeLotto(){
        for(int i=0; i<lottoTicketCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minimumLottoNumber, maximumLottoNumber, NUMBER_COUNT);
            userLottoes.add(new Lotto(numbers));
        }
    }

}
