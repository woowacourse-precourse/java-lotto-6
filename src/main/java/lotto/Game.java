package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Game {
    enum LottoRank{
        FIRST(6, false, 2000000000),
        SECOND(5, true, 30000000),
        THIRD(5, false, 1500000),
        FOURTH(4, false, 50000),
        FIFTH(3, false, 5000),
        NO_MATCHED(0, false, 0);

        private final Integer matchedNumbersCount;
        private final boolean isBonusNumberMatched;
        private final Integer prizeMoney;

        LottoRank(Integer matchedNumbersCount, boolean isBonusNumberMatched, final Integer prizeMoney){
            this.matchedNumbersCount = matchedNumbersCount;
            this.isBonusNumberMatched = isBonusNumberMatched;
            this.prizeMoney = prizeMoney;
        }
        private static LottoRank getRank(Integer matchedNumbersCount, boolean isBonusNumberMatched){
            for (LottoRank rank : LottoRank.values()){
                if (Objects.equals(rank.matchedNumbersCount, matchedNumbersCount) && (rank.isBonusNumberMatched && isBonusNumberMatched)){
                    return rank;
                }
            }
            return NO_MATCHED;
        }
    }
    private InputUser inputUser;
    private OutputUser outputUser;
    private List<Lotto> numberTickets;
    private WinningLotto winningLotto;
    private Integer lottoMoney;
    private Integer totalLottoCount;

    public Game(){
        this.inputUser = new InputUser();
        this.outputUser = new OutputUser();
        this.numberTickets = new ArrayList<>();
    }
    public void play(){
        this.lottoMoney = inputUser.inputLottoMoney();
        makeNumberTicket(lottoMoney);
        outputUser.outputBuyLotto(this.totalLottoCount);
        outputUser.outputBuyLottoNumbers(this.numberTickets);

        List<Integer> winningNumbers = inputUser.inputWinningNumber();
        Integer bonusNumber = inputUser.inputBonusNumber();
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        resultLottoGame(this.numberTickets, this.winningLotto);
    }
    private void makeNumberTicket(Integer lottoMoney){
        this.totalLottoCount = lottoMoney/1000;
        for (int i = 0; totalLottoCount > i; i++){
            this.numberTickets.add(makeNumber());
        }
    }
    private Lotto makeNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortAscNumber(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
    private void sortAscNumber(List<Integer> numbers){
        Collections.sort(numbers);
    }
    private void resultLottoGame(List<Lotto> numberTickets, WinningLotto winningLotto){
        for (Lotto lotto : numberTickets){
            Integer matchedNumbersCount = calculateLottoGame(lotto, winningLotto);
            Boolean isBonusNumberMatched = calculateLottoGameBonus(lotto, winningLotto);
            calculateLottoGameResult(matchedNumbersCount, isBonusNumberMatched);
        }
    }
    private int calculateLottoGame(Lotto lotto, WinningLotto winningLotto){
        List<Integer> resultLotto = new ArrayList<>(lotto.getNumbers());
        resultLotto.retainAll(winningLotto.getLotto().getNumbers());
        return resultLotto.size();
    }
    private boolean calculateLottoGameBonus(Lotto lotto, WinningLotto winningLotto){
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }
    private void calculateLottoGameResult(Integer matchedNumbersCount, Boolean isBonusNumberMatched){
        LottoRank rank = LottoRank.getRank(matchedNumbersCount, isBonusNumberMatched);
    }

}
