package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constant.*;
import static lotto.Message.NOT_VALID_MONEY;

public class PurchaseLottos {

    protected final int unitOfMoney = 1000;
    private List<Lotto> userLottos = new ArrayList<>();

    private final int lottoTicketCount;

    public PurchaseLottos(int amount) {
        validateNotHasRemainder(amount);
        lottoTicketCount = amount / this.unitOfMoney;
        makeLotto();
    }

    public BuyLottoInfo getBuyLottoInfo(){
        List<List<Integer>> lottoNumber = userLottos.stream().map(Lotto::getLottoNumbers).toList();
        return new BuyLottoInfo(lottoNumber, lottoTicketCount);
    }

    public List<List<Integer>> geBuyingLottoNumbers(){
        return userLottos.stream().map(Lotto::getLottoNumbers).toList();
    }

    private void validateNotHasRemainder(int amount){
        if(amount % unitOfMoney != 0) throw new IllegalArgumentException(NOT_VALID_MONEY);
    }

    private void makeLotto(){
        for(int i=0; i<lottoTicketCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minimumLottoNumber, maximumLottoNumber, NUMBER_COUNT);
            Collections.sort(numbers);
            userLottos.add(new Lotto(numbers));
        }
    }

}
