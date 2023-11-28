package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.*;

public class Purchase {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public List<List<Integer>> process() {
        System.out.println("구입금액을 입력해주세요.");
        int money = 0;
        while (true) {
            try {
                money = Integer.parseInt(inputView.inputPurchaseMoney());
                break;
            } catch (NumberFormatException exception) {
                System.out.println(LottoException.getExceptionMessage(String.valueOf(LottoException.INVALID_INPUT_TYPE)));
            }
        }
        int lottoCount = checkLottoCount(money);
        return getLottoNumbers(lottoCount);
    }

    public int checkLottoCount(int money) throws NumberFormatException {
        int lottoCount = money / 1000;
        if (money % 1000 != 0) {
            System.out.println(LottoException.getExceptionMessage(String.valueOf(LottoException.INVALID_INPUT_PRICE)));
        }
        outputView.printLottoCount(lottoCount);
        return lottoCount;
    }

    public List<List<Integer>> getLottoNumbers(int lottoCount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        while (lottoCount > 0) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> newLottoNumber = new ArrayList<>(lottoNumber);
            Collections.sort(newLottoNumber);
            outputView.printLottoNumber(newLottoNumber);
            lottoCount--;
            lottoNumbers.add(newLottoNumber);
        }
        return lottoNumbers;
    }
}
