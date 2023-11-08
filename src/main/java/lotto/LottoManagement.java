package lotto;

import java.util.List;
import java.util.ArrayList;

public class LottoManagement {
    static final int prize1=2000000000;
    static final int prize2=30000000;
    static final int prize3=1500000;
    static final int prize4=50000;
    static final int prize5=5000;
    final static int pricePerPiece=1000;
    private int verifiedMoney;
    private int bonusNumber;
    List<Integer> winningLottoNumbers;
    private final List<Lotto> lottos;
    List<Integer>winningDetails = new ArrayList<>(6);

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
            int prize=lotto.lottoScore(winningLottoNumbers,bonusNumber);
            setDetails(prize);
            System.out.print(lotto.lottoScore(winningLottoNumbers,bonusNumber));
            lottos.add(lotto);
        }
    }

    public void setDetails(int prize){
        if(prize==prize1)winningDetails.set(1,winningDetails.get(1)+1);
        if(prize==prize2)winningDetails.set(2,winningDetails.get(2)+1);
        if(prize==prize3)winningDetails.set(3,winningDetails.get(3)+1);
        if(prize==prize4)winningDetails.set(4,winningDetails.get(4)+1);
        if(prize==prize5)winningDetails.set(5,winningDetails.get(5)+1);
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
