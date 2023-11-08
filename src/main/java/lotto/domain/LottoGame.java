package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Constant.*;

public class LottoGame {

    public void start() {
        //구입금액 입력
        int price = 0;
        boolean redo = true;
        while(redo) {
            boolean error = false;
            try {
                price = InputView.getPrice();
            } catch (IllegalArgumentException e) {
                error = true;
                System.out.println(e.getMessage());
            }
            if (!error) redo = false;
        }

        //구매한 로또 갯수
        int lottoNum = InputView.getLottoNum(price);

        List<Lotto> lottos = getLottos(lottoNum);

        //구매한 로또들의 번호 출력
        OutputView.printLottos(lottos);

        //당첨번호 입력
        Lotto myLotto = null;
        redo = true;
        List<Integer> pickedNums = null;
        while (redo){
            boolean error = false;
            try {
                pickedNums = InputView.getPickedNums();
                myLotto = new Lotto(pickedNums);
            } catch (IllegalArgumentException e) {
                error = true;
                System.out.println(e.getMessage());
            }
            if (!error) redo = false;
        }

        //보너스 번호 입력
        int bonusNum = InputView.getBonusNum();


        //당첨 통계
        LottoResult lottoResult = countNums(lottos, myLotto, bonusNum);

        double profit = getProfit(price, lottoResult);
        OutputView.printResult(lottoResult, profit);
    }

    private static double getProfit(int price, LottoResult lottoResult) {
        int earnedMoney = (prize5 * lottoResult.getThree()) + (prize4 * lottoResult.getFour()) + (prize3 * lottoResult.getFive()) + (prize2 * lottoResult.getFiveB()) + (prize1 * lottoResult.getSix());
        return ((double) (earnedMoney) / price) * 100;
    }

    private static LottoResult countNums(List<Lotto> lottos, Lotto myLotto, int bonusNum) {

        LottoResult lottoResult = new LottoResult();

        List<Integer> pickedNums = myLotto.getNumbers();

        for (int i = 0; i < lottos.size(); i++) {
            int count = 0;
            Lotto lotto = lottos.get(i);
            for (Integer number : lotto.getNumbers()) {
                if (pickedNums.contains(number)) {
                    count++;
                }
            }

            if (count == 3) lottoResult.increaseThree();
            if (count == 4) lottoResult.increaseFour();
            if (count == 5) lottoResult.increaseFive();
            if (count == 5 && pickedNums.contains(bonusNum)) lottoResult.increaseFiveB();
            if (count == 6) lottoResult.increaseSix();
        }

        return lottoResult;
    }

    private static ArrayList<Lotto> getLottos(int lottoNum) {
        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

}

