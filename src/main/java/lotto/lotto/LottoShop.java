package lotto.lotto;

import lotto.player.Wallet;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.constants.ErrorConstants.*;
import static lotto.constants.MessageConstant.*;
import static lotto.constants.NumConstant.*;

public class LottoShop {
    public Lotto randomLotto() {
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(MIN_VALUE.getValue(), MAX_VALUE.getValue(), DIGIT.getValue());

        return new Lotto(lottoNumbers);
    }

    public void buy(Wallet wallet) {
        while(true) {
            try {
                wallet.inputBuyMoney();

                int buyCount = wallet.getBuyMoney() / PRICE.getValue();
                System.out.println(BUYCOMPLETE.addString(buyCount));

                List<Lotto> buyLotto = new ArrayList<>();
                for (int i = 0; i < buyCount; i++) {
                    Lotto lotto = randomLotto();
                    buyLotto.add(lotto);
                }
                wallet.setLottos(buyLotto);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private Lotto inputLottoNum(){
        while(true) {
            System.out.println();
            System.out.println(INPUTWINNUM);
            List<Integer> winnerLottoNums = new ArrayList<>();
            String inputWinnerLottoNum = readLine();
            String[] lottoNums = inputWinnerLottoNum.split(",");
            try {
                for (String lottoNum : lottoNums) {
                    validateInputNum(lottoNum);
                    winnerLottoNums.add(Integer.parseInt(lottoNum));
                }
                Lotto lotto = new Lotto(winnerLottoNums);
                return lotto;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void validateInputNum(String input) {
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9'){
                throw new IllegalArgumentException(NOTNUMBERERROR.toString());
            }
        }
    }
    private int inputBonusNum() {
        System.out.println();
        System.out.println(INPUTBONUS);
        int bonusNum = Integer.parseInt(readLine());
        return bonusNum;

    }

    public WinnerLotto pickWinnerLotto() {
        WinnerLotto winnerLotto;
        Lotto lotto;
        while(true){
            try{
                lotto = inputLottoNum();
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while(true){
            try{
                int bonusNum = inputBonusNum();
                winnerLotto = new WinnerLotto(lotto,bonusNum);
                return winnerLotto;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
