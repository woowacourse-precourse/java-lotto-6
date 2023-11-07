package lotto.manager;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.Statistics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.utility.IntegerUtil.*;
import static lotto.utility.StringUtil.PRINT_WINNING_DETAILS;

public class LottoManager {

    private static LottoManager lottoManager;

    private final Statistics statistics = Statistics.getInstance();

    private int lottoTicketCount;

    private List<Lotto> lottoList;

    private List<Integer> winningNumber;
    private int bonusNumber;
    private int payAmount;

    private LottoManager() {

    }

    public static LottoManager getInstance() {
        if ( lottoManager == null ) {
            lottoManager = new LottoManager();
        }
        return lottoManager;
    }

    public int generateLottoTickets(int payAmount) {
        this.payAmount = payAmount;
        return payAmount / PAY_AMOUNT_UNIT.getValue();
    }

    public List<Lotto> generateLottoList() {
        List<Lotto> lottoList = new ArrayList<>();

        for(int i = 0; i < this.lottoTicketCount; i++ ) {
            Lotto lotto = new Lotto(generateLottoNumber());
            lottoList.add(lotto);
        }

        this.lottoList = lottoList;

        return lottoList;
    }

    public List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START_INCLUSIVE.getValue(),
                LOTTO_NUMBER_END_INCLUSIVE.getValue(),
                LOTTO_NUMBER_COUNT.getValue()
        );
    }

    public void calculateAllLotto() {
        for( Lotto lotto : this.lottoList ) {
            calculateLotto(lotto);
        }
    }

    public void calculateLotto(Lotto lotto) {

        int matchCount = 0;
        int bonusCount = 0;

        for (int number : lotto.getNumbers()) {
            if ( winningNumber.contains(number) ) {
                matchCount++;
            }

            if ( bonusNumber == number ) {
                bonusCount++;
            }
        }

        statistics.integrate(matchCount, bonusCount);
    }

    public double calculateProfit() {
        Statistics statistics = Statistics.getInstance();

        Map<Integer, Integer> winningNumberMatchCount = statistics.getWinningNumberMatchCount();
        Map<Integer, Integer> priceByMatchCount = statistics.getPriceByMatchCount();

        double totalPrice = 0.0;

        for ( int matches : winningNumberMatchCount.keySet() ) {
            totalPrice += priceByMatchCount.get(matches) * winningNumberMatchCount.get(matches);
        }

        double profit = totalPrice / (double) this.payAmount;
        return (Math.round(profit * 10) / 10.0);
    }

    public void setLottoTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
