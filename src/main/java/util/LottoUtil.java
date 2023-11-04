package util;

import camp.nextstep.edu.missionutils.Randoms;

import config.CountMessage;
import domain.Lotto;
import VO.UserLottoVO;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtil {

    // 금액 계산기
    public static int countLotto(int pay) {
        return pay / 1000; // TODO: 상수 처리 필요
    }

    // 로또 생성기
    public static List<Lotto> makeLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        while(count-- > 0) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6)); // TODO: 상수 처리 필요
            Collections.sort(numbers);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    // 당첨금 정산
    public static int[] countWinLotto(WinningLotto winningLotto, UserLottoVO userLottoVO) {
        int[] winCountArr = new int[8]; // TODO: 상수처리 필요
        for(Lotto lotto : userLottoVO.getLottoList()) {
            winCountArr[winningLotto.countWinNumber(lotto)]++;
        }
        return winCountArr;
    }

    public static Double calculateRate(int[] winCountArr, int pay) { // TODO: 상수 처리 필요
        double sum = 0d;
        for(CountMessage count : CountMessage.values()) {
            sum += count.getPrice() * winCountArr[count.getCount()];
        }
        return sum / pay * 100;
    }


}
