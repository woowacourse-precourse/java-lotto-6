package lotto.Controller;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Viewer.lottoViewer;

import java.util.List;
import java.util.ArrayList;

public class LottoController {
    List<Lotto> totalLottoList;

    // 입력받은 금액 값 체크
    private void checkPrice(int price) {
        if(price%1000 != 0) throw new IllegalArgumentException();
    }

    // 로또 구매
    private void lottoPurchase(int price){
        int countLotto = price/1000;
        System.out.println(countLotto+"개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < countLotto; i++){
            Lotto lotto = generateLotto();
        }
    }

    // 로또 생성
    private Lotto generateLotto(){
        List<Integer> sixNumberList = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(sixNumberList);
    }
    // 시작
    public void start(){

    }
}
