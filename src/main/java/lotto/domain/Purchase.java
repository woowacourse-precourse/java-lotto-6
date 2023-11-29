package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.ErrorMessage;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.*;

public class Purchase {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
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
                System.out.println(ErrorMessage.getExceptionMessage(String.valueOf(ErrorMessage.INVALID_INPUT_TYPE)));
            }
        }
        int lottoCount = checkLottoCount(money);
        return getLottoNumbers(lottoCount);
    }

    public int checkLottoCount(int money) throws NumberFormatException {
        int lottoCount = money / LOTTO_PRICE;
        if (money % LOTTO_PRICE != 0) {
            System.out.println(ErrorMessage.getExceptionMessage(String.valueOf(ErrorMessage.INVALID_INPUT_PRICE)));
        }
        outputView.printLottoCount(lottoCount);
        return lottoCount;
    }

    public List<List<Integer>> getLottoNumbers(int lottoCount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        while (lottoCount > 0) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
            List<Integer> newLottoNumber = new ArrayList<>(lottoNumber);
            Collections.sort(newLottoNumber);
            outputView.printLottoNumber(newLottoNumber);
            lottoCount--;
            lottoNumbers.add(newLottoNumber);
        }
        return lottoNumbers;
    }
}
