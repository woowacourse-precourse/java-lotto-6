package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoNumber;
import lotto.util.InputUtil;
import lotto.util.NumberUtil;
import lotto.util.ValidationUtil;

public class LottoBuy {

    private int amount;
    private List<Lotto> lottos = new ArrayList<>();
    private final InputUtil inputUtil = new InputUtil();
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final NumberUtil numberUtil = new NumberUtil();

    public LottoBuy lottoBuyInfo(){
        int buyAmount = getAmount();
        int buyCount = getCount(buyAmount);
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < buyCount; i++){
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        this.lottos = lottos;
        this.amount = buyAmount;
        return this;
    }

    public int getAmount(){
        String amount = inputUtil.getInput();
        return validationUtil.validateBuy(amount);
    }
    private int getCount(int amount){
        int count = amount / LottoNumber.LEAST_PURCHASE_AMOUNT.getNumber();
        return count;
    }

    private Lotto generateLotto(){
        List<Integer> lottoNums = numberUtil.getLottoNumbers();
        Lotto lotto = new Lotto(lottoNums);
        return lotto;
    }
    public int getUserAmount(){
        return amount;
    }
    public List<Lotto> getUserLottos(){
        return lottos;
    }
}
