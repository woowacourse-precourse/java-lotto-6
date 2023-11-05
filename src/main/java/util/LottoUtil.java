package util;

import camp.nextstep.edu.missionutils.Randoms;

import static config.LottoConst.*;
import config.CountMessage;

import domain.Lotto;
import domain.WinningLotto;

import VO.UserLottoVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtil {

    private static final int COUNT_ARR_SIZE = 8;
    private static final double DEFAULT_SUM = 0d;
    private static final int PERCENT = 100;

    // 금액 계산기
    public static int countLotto(int pay) {
        return pay / PRICE_MIN_UNIT.getNumber();
    }

    // 로또 생성기
    public static List<Lotto> makeLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        while(count-- > 0) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(
                            RANGE_START.getNumber(), RANGE_END.getNumber(), LOTTO_SIZE.getNumber()));
            Collections.sort(numbers);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    // 당첨금 정산
    public static int[] countWinLotto(WinningLotto winningLotto, UserLottoVO userLottoVO) {
        int[] winCountArr = new int[COUNT_ARR_SIZE];
        for(Lotto lotto : userLottoVO.getLottoList()) {
            winCountArr[winningLotto.countWinNumber(lotto)]++;
        }
        return winCountArr;
    }

    public static Double calculateRate(int[] winCountArr, int pay) {
        double sum = DEFAULT_SUM;
        for(CountMessage count : CountMessage.values()) {
            sum += count.getPrice() * winCountArr[count.getCount()];
        }
        return sum / pay * PERCENT;
    }


}
