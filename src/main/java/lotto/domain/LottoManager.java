package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoManager {

    public List<Lotto> createLottoTickets(int lottoQuantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i< lottoQuantity; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void isValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidWinningLottoNumbers(List<Integer> winningLottoNumbers) {
        if(winningLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 당첨 번호는 숫자 6개를 입력해야 합니다.");
        }

        if(hasDuplicateNumbers(winningLottoNumbers)) {
            throw new IllegalArgumentException("로또 당첨 번호에는 중복된 숫자가 없어야 합니다.");
        }
    }

    private static boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (int number : numbers) {
            if (numberSet.contains(number)) {
                return true;
            }
            numberSet.add(number);
        }
        return false;
    }
}
