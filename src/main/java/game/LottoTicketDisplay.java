package game;

import static constant.ConstantMessage.PURCHASE_QUANTITY_PRINT_MESSAGE;
import static constant.ConstantNumber.PURCHASE_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketDisplay {
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
