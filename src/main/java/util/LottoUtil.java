package util;

import static config.LottoConst.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import config.CountMessage;

import domain.Lotto;
import domain.WinningLotto;

import VO.UserLottoVO;

public class LottoUtil {

    private static final int COUNT_ARR_SIZE = 8;
    private static final double DEFAULT_SUM = 0d;
    private static final int PERCENT = 100;

    public static int countLotto(int pay) {
        return pay / PRICE_MIN_UNIT.getNumber();
    }

    public static List<Lotto> makeLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        while (count-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    RANGE_START.getNumber(), RANGE_END.getNumber(), LOTTO_SIZE.getNumber());
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    public static int[] countWinLotto(WinningLotto winningLotto, UserLottoVO userLottoVO) {
        int[] rankCount = new int[COUNT_ARR_SIZE];
        for (Lotto lotto : userLottoVO.getLottoList()) {
            rankCount[winningLotto.countWinNumber(lotto)]++;
        }
        return rankCount;
    }

    public static Double calculateRate(int[] rankCount, int pay) {
        double sum = DEFAULT_SUM;
        for (CountMessage count : CountMessage.values()) {
            sum += count.getPrice() * rankCount[count.getCount()];
        }
        return sum / pay * PERCENT;
    }


}
