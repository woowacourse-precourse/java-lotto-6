package game;

import static constant.ConstantMessage.PURCHASE_QUANTITY_PRINT_MESSAGE;
import static constant.ConstantNumber.PURCHASE_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketDisplay {

    // 1. 구매양을 얻는 메서드
    // 2. 구매양 출력
    // 3. 구매양에 따른 리스트 얻기
    // 4. 리스트를 출력하는 기능
    public int getPurchaseQuantity(int purchaseAmount) {
        return purchaseAmount / PURCHASE_UNIT;
    }

    public void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println(purchaseQuantity + PURCHASE_QUANTITY_PRINT_MESSAGE);
    }

    public void printUserLottoNumbers(int purchaseQuantity, List<List<Integer>> userLottoNumbers) {
        for (int index = 0; index < purchaseQuantity; index++) {
            System.out.println(userLottoNumbers.get(index));
        }
    }

    public List<List<Integer>> getUserLottoNumbers(int purchaseQuantity) {
        List<List<Integer>> userLottoNumbers = new ArrayList<>();

        for (int index = 0; index < purchaseQuantity; index++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(randomNumbers);
            userLottoNumbers.add(randomNumbers);
        }
        return userLottoNumbers;
    }

}
