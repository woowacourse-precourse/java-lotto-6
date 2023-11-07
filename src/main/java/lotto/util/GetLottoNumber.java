package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetLottoNumber {
    public static List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> modifiableList = new ArrayList<>(lottoNumber);
        Collections.sort(modifiableList);

        return modifiableList;
    }

    public static Lotto getWinLottoNumber() {
        List<Integer> winNumber = InputView.inputWinNumber();
        Lotto winningTicket = null;

        try {
            winningTicket = new Lotto(winNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("당첨 번호를 6개 입력해주세요.");
            getWinLottoNumber();
        }

        return winningTicket;
    }

    public static int getBonusNumber() {
        int bonusNumber = InputView.inputBonusNumber();

        try {
            Validator.bonusNumberNum(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("1개만 입력하세요.");
            getLottoNumber();
        }

        return bonusNumber;
    }
}
