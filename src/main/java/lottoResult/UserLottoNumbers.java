package lottoResult;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottoNumbers {
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