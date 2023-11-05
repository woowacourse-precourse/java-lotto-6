package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.GetLottoPurchase;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

public class LottoController {
    public LottoController(){
    }

    private static GetLottoPurchase getLottoPurchase;
    private boolean isGetCost = false;
    private boolean isGetLotto = false;
    private boolean isGetBonus = false;
    private static List<Lotto> lottoList;
    private static List<Integer> lotto = new ArrayList<>();
    private static Lotto winningLotto;


    public void run(){
        start();
    }

    public void start() {
        int lottoCount = purchaseAmount();
        OutputMessage.printLottoCount(lottoCount);
        lottoList = makeLottoList(lottoCount);
        winningLotto = makeWinningLotto();
    }

    public int purchaseAmount(){
        while(!isGetCost){
            getLottoPurchase = new GetLottoPurchase(InputMessage.inputPurchase());
            if(getLottoPurchase.getCost() != 0)
                isGetCost = true;
        }
        return getLottoPurchase.computeLottoCount();
    }

    private static List<Lotto> makeLottoList(int lottoCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();
        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    public Lotto makeWinningLotto(){
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();
        while(!isGetLotto){
            String num = InputMessage.inputPrizeLotto();
            lotto = lottoNumbers.setPrizeNumbers(num);

            if(lottoNumbers.validateRange() && lottoNumbers.validateDuplicate() && lottoNumbers.validateSize()){
                winningLotto = new Lotto(lotto);
                isGetLotto = true;
            }
        }
        return winningLotto;
    }

}
