package domain;

import util.CreateRandomNumberUtil;
import util.InputUtil;
import util.MessageUtil;
import util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    private final InputUtil inputUtil = new InputUtil();
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();

    private List<Lotto> lottos;
    private int lottoAmount;
    public LottoPurchase getLottoPurchaseInfo(){
        List<Lotto> lottos = new ArrayList<>();
        int lottoPurchaseAmount = getPurchaseLottoAmount();
        int lottoAmount = getLottoAmount(lottoPurchaseAmount);
        for(int i = 0; i < lottoAmount; i++){
            Lotto lotto = getRandomLottoNum();
            lottos.add(lotto);
        }
        this.lottos = lottos;
        this.lottoAmount = lottoAmount;
        return this;
    }
    public List<Lotto> getUserLottos(){
        return lottos;
    }
    public int getUserLottoAmount(){
        return lottoAmount;
    }

    public int getPurchaseLottoAmount(){
        // 금액 입력받기, 8000원 리턴, 1000으로 나누기 전은 purchase
        String lottoAmount = inputUtil.userInput();
        return validationUtil.validPurchaseLottoAmount(lottoAmount);
    }
    private int getLottoAmount(int lottoPurchaseAmount) {
        // 8개 이런식으로 리턴.
        int lottoAmount = lottoPurchaseAmount / 1000;
        messageUtil.printPurchase(lottoAmount);
        return lottoAmount;
    }
    private Lotto getRandomLottoNum(){
        // 로또 넘버 하나! 랜덤 생성 하고 lotto 객체 반환
        List<Integer> randomLottoNums = CreateRandomNumberUtil.getNumbers();
        Lotto lotto = new Lotto(randomLottoNums);
        messageUtil.printPurchaseInfo(lotto.getLottoNumbers());
        return lotto;
    }



}
