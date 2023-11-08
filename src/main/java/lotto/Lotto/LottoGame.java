package lotto.Lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Input.Input;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static void run(){
        //로또 개수 구하기
        int lottoBuyCount = Input.getLottoBuyCount();
        List<Lotto> paidLottos = LottoGame.getPaidLottoNumbers(lottoBuyCount);
    }

    //구입한 로또 리스트 구하기
    public static List<Lotto> getPaidLottoNumbers(int lottoBuyCount){
        List<Lotto> paidLottoNumbers = new ArrayList<>();
        for(int i=0;i<lottoBuyCount;i++){
            paidLottoNumbers.add(getRandomLottoNumber());
        }
        return paidLottoNumbers;
    }

    //랜덤 로또 번호 구하기
    public static Lotto getRandomLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
