package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Input.getValidPurchaseInput;
import static lotto.RandomLottoNumber.randLottoNumbers;

public class Application {
    public static void main(String[] args) {
        int purchaseInputMoney = getValidPurchaseInput(); // 올바른 구매 금액을 입력했는지 확인하고 올바르지 않으면 재입력한다

        ArrayList<List<Integer>> totalLotto = randLottoNumbers(purchaseInputMoney/1000); // 무작위로 생성한 로또를 이중 배열에 담는다

    }
}
