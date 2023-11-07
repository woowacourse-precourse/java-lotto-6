package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static lotto.Constant.*;

public class PurchaseLottos extends Amount{

    private List<Lotto> userLottos = new ArrayList<>();
    private final int lottoTicketCount;

    public PurchaseLottos(int amount) {
        super(amount);
        lottoTicketCount = this.amount / this.unitOfMoney;
        makeLotto();
    }


    private void makeLotto(){
        for(int i=0; i<lottoTicketCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minimumLottoNumber, maximumLottoNumber, NUMBER_COUNT);
            userLottos.add(new Lotto(numbers));
        }
    }

    public BuyLottoInfo getBuyLottoInfo(){
        List<List<Integer>> lottoNumber = userLottos.stream().map(Lotto::getLottoNumbers).toList();
        return new BuyLottoInfo(lottoNumber, lottoTicketCount);
    }
}
