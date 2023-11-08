package lotto;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input.setTotalPrice();
        Output.printLottoQuantity(Input.getTotalPrice());

        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<Input.getTotalPrice()/1000; i++){
            lottoList.add(new Lotto(RandomNum.createRandomNum()));
        }
        Output.printAllLotto(lottoList);

        Input.setWinningNumber();
        Input.setBonusNumber();

        List<Integer> winningNumber = Input.getWinningNumber();
        int bonusNumber = Input.getBonusNumber();
        for(Lotto lotto : lottoList) {
            int countOfMatch = Score.checkWinningNumber(lotto, winningNumber);
            boolean bonusCheck = Score.checkBonusNumber(lotto, bonusNumber);
            Rank.calculateEachLottoResult(countOfMatch, bonusCheck);
        }

        Output.printWinResult(Rank.result);
        Rank.calculateReturnRate();
        Output.printReturnRate(Rank.returnRate);
    }
}
