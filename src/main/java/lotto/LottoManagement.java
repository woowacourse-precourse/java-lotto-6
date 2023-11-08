package lotto;

import java.util.List;
import java.util.ArrayList;

public class LottoManagement {
    final static int pricePerPiece=1000;
    private int verifiedMoney;
    private int bonusNumber;
    List<Integer> winningLottoNumbers;
    private final List<Lotto> lottos;

    LottoManagement(){
        lottos=new ArrayList<>();
    }

    void initMoney(){
        InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
        inputMoneyHandler.init();
        verifiedMoney=inputMoneyHandler.exceptionHandledMoney();
    }

    void initWinningLottoNumbers(){

        NumbersHandler numbersHandler = new NumbersHandler();
        numbersHandler.init();
        winningLottoNumbers = numbersHandler.convertedWinningNumbers();
        bonusNumber=numbersHandler.convertedBounsNumber();
    }

    public void buyLottos(){
        int lottoCount=verifiedMoney/pricePerPiece;
        for (int i=0;i<lottoCount;i++){
            Lotto lotto=new Lotto(LottoGenerator.getLottoNumbers());
            System.out.print(lotto.lottoScore(winningLottoNumbers,bonusNumber));
            lottos.add(lotto);
        }
    }


    public List<Lotto> getLottos(){
        return lottos;
    }
    public int getMoney(){
        return verifiedMoney;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }

}
