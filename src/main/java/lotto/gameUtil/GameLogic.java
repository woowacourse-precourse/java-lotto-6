package lotto.gameUtil;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    OutputView outputView;
    public GameLogic(){
        outputView = new OutputView();
    }
    public List<Lotto> lottoNumber(int amount){
        int count = amount / 1000;
        outputView.countMessage(count);
        List<Lotto> lottoList = new ArrayList<>();

        for(int i=0;i<count;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort((o1, o2)->{
                return o1-o2;
            });
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
            outputView.lottoNumberMessage(lotto.toString());
        }
        return lottoList;
    }
    public Lotto winningNumber(String winningNumberStr){
        String[] winningNumberArr = winningNumberStr.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for(String str : winningNumberArr){
            winningNumber.add(Integer.parseInt(str));
        }
        Lotto lotto = new Lotto(winningNumber);
        return lotto;
    }
    public void lottoNumberCompare(Lotto buyingLotto, Lotto winningLotto, int bonusNumber){
        int[] buyingLottoNumber = buyingLotto.toIntegerArr();
        int[] winningLottoNumber = winningLotto.toIntegerArr();


    }
//    public int matchNumber(int[] buyingLottoNumber, int[] winningLottoNumber, int bonus){
//        int count = 0;
//        for(int i=0;i<6;i++){
//            if(buyingLottoNumber[i]==winningLottoNumber[i] || buyingLottoNumber[i]==bonus){
//                count++;
//            }
//        }
//        return count;
//    }
//    public boolean isSecond(int[] buyingLottoNumber, int bonus){
//        for(int number : buyingLottoNumber){
//            if(bonus==number){
//                return true;
//            }
//        }
//        return false;
//    }
}
