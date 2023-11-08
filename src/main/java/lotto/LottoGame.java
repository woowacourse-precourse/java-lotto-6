package lotto;

import static lotto.Lotto.LOTTO_END_NUMBER;
import static lotto.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.Lotto.LOTTO_START_NUMBER;
import static lotto.LottoGameReader.getBonusNumberFromConsole;
import static lotto.LottoGameReader.getMoneyFromConsole;
import static lotto.LottoGameReader.getWinNumberFromConsole;
import static lotto.message.LottoGameAnnouncement.ANNOUNCE_BEFORE_RESULT;
import static lotto.message.LottoGameAnnouncement.COUNT_OF_LOTTO;
import static lotto.message.LottoGameAnnouncement.SECTION;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.message.BonusNumber;
import org.assertj.core.util.VisibleForTesting;

public class LottoGame {

    public static void start() {
        LottoMoney money = getMoneyFromConsole();
        List<Lotto> lottoNumbers = getLottoNumbers(money.getCountForBuyingLotto());
        Lotto winNumber = getWinNumberFromConsole();
        BonusNumber bonusNumber = getBonusNumberFromConsole();
        printResult(money, lottoNumbers, winNumber, bonusNumber);
    }

    private static List<Lotto> getLottoNumbers(int countForBuyingLotto) {
        System.out.println(countForBuyingLotto + COUNT_OF_LOTTO.getMessage());
        List<Lotto> lottoNumbers = generateLottoNumbersByRandom(countForBuyingLotto);
        printLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    @VisibleForTesting
    protected static List<Lotto> generateLottoNumbersByRandom(int count) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        while(count-- > 0) {
            ArrayList<Integer> numbers = new ArrayList<>(
                            Randoms.pickUniqueNumbersInRange(
                                    LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_SIZE));
            Collections.sort(numbers);
            Lotto lottoNumber = new Lotto(numbers);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private static void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getLottoNumbersAsFormat());
        }
    }

    private static void printResult(
            LottoMoney money, List<Lotto> lottoNumbers, Lotto winNumber, BonusNumber bonusNumber) {
        System.out.println(ANNOUNCE_BEFORE_RESULT.getMessage());
        System.out.println(SECTION.getMessage());
        ResultCalculator.printWin(lottoNumbers, winNumber, bonusNumber);
        ResultCalculator.printProfitPercentage(money);
    }
}
