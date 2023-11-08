package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameMachine {


    public int insertLottoPayment(int insertAmount) {

        while (true) {
            try {
                System.out.println("구입금액을 입력해주세요.");
                // 입력 넣는 거 넣어야함.
                validateLottoPayment(insertAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액은 1000원 단위로 입력해주세요.");
            }
        }

        return insertAmount / 1000;
    }

    public void validateLottoPayment(int insertAmount) {
        if (insertAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해주세요.");
        }
    }

    public List<Lotto> issueLotto(int insertAmount) {
        System.out.println(insertAmount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        // 받은 숫자만큼 로또 발행
        for (int i = 0; i < insertAmount; i++) {
            List<Integer> lottoNumbers = createNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);

        }
        return lottos;
    }

    public void arrangeAscendingOrder(List<Lotto> issuedLottoNumbers) {
        for (Lotto lotto : issuedLottoNumbers) {
            System.out.println(lotto.toString());
        }

    }

    public List<Integer> createNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public void insertWinningNumber() {

    }

    public void insertBonusNumber() {

    }

    public void compareNumbers() {

    }

    public void printResult() {

    }


}
