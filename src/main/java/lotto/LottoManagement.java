package lotto;

import java.util.List;
import java.util.ArrayList;

public class LottoManagement {
    static final int prize1 = 2000000000;
    static final int prize2 = 30000000;
    static final int prize3 = 1500000;
    static final int prize4 = 50000;
    static final int prize5 = 5000;
    final static int pricePerPiece = 1000;
    private int verifiedMoney;
    private int bonusNumber;
    List<Integer> winningLottoNumbers;
    private final List<Lotto> lottos;
    List<Integer> winningDetails = new ArrayList<>(6);
    public long reward=0;

    LottoManagement() {
        lottos = new ArrayList<>();
        for(int i=0; i<6; i++)winningDetails.add(0);
    }

    void initMoney() {
        InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
        inputMoneyHandler.init();
        verifiedMoney = inputMoneyHandler.exceptionHandledMoney();
    }

    void initWinningLottoNumbers() {

        NumbersHandler numbersHandler = new NumbersHandler();
        numbersHandler.init();
        winningLottoNumbers = numbersHandler.convertedWinningNumbers();
        bonusNumber = numbersHandler.convertedBounsNumber();
    }

    public void buyLottos() {
        int lottoCount = verifiedMoney / pricePerPiece;
        System.out.println(lottoCount+"개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(LottoGenerator.getLottoNumbers());
            lotto.printNumbers();
            lottos.add(lotto);
        }
    }

    public void setScore(){
        for (Lotto lotto:lottos){
            int prize = lotto.lottoScore(winningLottoNumbers, bonusNumber);
            reward += prize;
            setDetails(prize);
        }
    }


    public void setDetails(int prize) {
        if (prize == prize1) winningDetails.set(1, winningDetails.get(1) + 1);
        if (prize == prize2) winningDetails.set(2, winningDetails.get(2) + 1);
        if (prize == prize3) winningDetails.set(3, winningDetails.get(3) + 1);
        if (prize == prize4) winningDetails.set(4, winningDetails.get(4) + 1);
        if (prize == prize5) winningDetails.set(5, winningDetails.get(5) + 1);
    }

    public void printDetails(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ winningDetails.get(5)+"개");
        System.out.println("4개 일치 (50,000원) - "+ winningDetails.get(4)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ winningDetails.get(3)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ winningDetails.get(2)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ winningDetails.get(1)+"개");
    }

    public void printRate(){
        double rate= (double)reward/(double)verifiedMoney;
        rate*=100;

        String print=String.format("총 수익률은 %.1f%%입니다.",rate);
        System.out.println(print);
    }
}
