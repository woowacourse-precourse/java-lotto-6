package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int buyMoney = Lotto.inputBuyMoney();
            List<Lotto> lottoList = new ArrayList<>();

            createLottos(buyMoney, lottoList);
            printLottos(lottoList);

            List<Integer> correctNumbers = Lotto.inputCorrectNumbers();
            Integer bonusNumber = Lotto.inputBonusNumber(correctNumbers);



        } catch (NumberFormatException ex) {
            System.out.println("[ERROR] 입력은 숫자로 입력되어야 합니다.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void createLottos(int buyMoney, List<Lotto> lottoList) {
        for(int i = 0; i < buyMoney / 1000; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Lotto lotto = new Lotto(numbers);

            lottoList.add(lotto);
        }
    }


    private static void printLottos(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }
}
