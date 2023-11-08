package lotto;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input.setTotalPrice();
        Output.printLottoQuantity(Input.totalPrice);

        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<Input.totalPrice/1000; i++){
            lottoList.add(new Lotto(RandomNum.createRandomNum()));
        }
        Output.printAllLotto(lottoList);

        Input.setWinningNumber();
        Input.setBonusNumber();

        for(Lotto lotto : lottoList) {
            int countOfMatch = Score.checkWinningNumber(lotto, Input.winningNumber);
            boolean bonusCheck = Score.checkBonusNumber(lotto, Input.bonusNumber);
            Rank.calculateEachLottoResult(countOfMatch, bonusCheck);
        }

        Output.printWinResult(Rank.result);
        Rank.calculateReturnRate();
        Output.printReturnRate(Rank.returnRate);
    }
}