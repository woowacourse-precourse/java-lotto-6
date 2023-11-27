package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;

import java.util.*;

public class Purchase {

    public List<List<Integer>> process() {
        System.out.println("구입금액을 입력해주세요.");
        int money = 0;
        while (true) {
            try {
                money = Integer.parseInt(inputMoney());
                break;
            } catch (NumberFormatException exception) {
                System.out.println(LottoException.getExceptionMessage(String.valueOf(LottoException.INVALID_INPUT_TYPE)));
            }
        }
        int lottoCount = checkLottoCount(money);
        return printLotto(lottoCount);
    }

    public String inputMoney() {
        return Console.readLine();
    }

    public int checkLottoCount(int money) throws NumberFormatException {
        int lottoCount = money / 1000;
        if (money % 1000 != 0) {
            System.out.println(LottoException.getExceptionMessage(String.valueOf(LottoException.INVALID_INPUT_SIZE)));
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public List<List<Integer>> printLotto(int lottoCount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        while (lottoCount > 0) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> newLottoNumber = new ArrayList<>(lottoNumber);
            Collections.sort(newLottoNumber);
            System.out.println(newLottoNumber);
            lottoCount--;
            lottoNumbers.add(newLottoNumber);
        }
        return lottoNumbers;
    }
}
