package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Validator;
import lotto.domain.dto.BuyLottoInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constant.*;
import static lotto.ErrorMessage.NOT_VALID_MONEY;
import static lotto.Validator.validatePositiveNumber;

public class PurchaseLottos {

    protected final int unitOfMoney = 1000;
    private List<Lotto> userLottos = new ArrayList<>();

    private final int lottoTicketCount;
    private final int amount;

    public PurchaseLottos(int amount) {
        validatePositiveNumber(amount);
        validateNotHasRemainder(amount);
        this.amount = amount;
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

    public int getPurchaseAmount(){ return amount; }

    private void validateNotHasRemainder(int amount){
        if(amount % unitOfMoney != 0) throw new IllegalArgumentException(NOT_VALID_MONEY);
    }

    private void makeLotto(){
        for(int i=0; i<lottoTicketCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minimumLottoNumber, maximumLottoNumber, LOTTO_NUMBER_COUNT);
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            userLottos.add(new Lotto(sortedNumbers));
        }
    }

}
