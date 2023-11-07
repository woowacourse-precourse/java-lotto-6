package Model;

import Utils.LottoRank;
import Utils.Messages;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoModel{

    private List<Integer> winningLottoNumber;
    private final List<Lotto> lottoNumbers;
    private int payment;
    private int countOfLotto;
    private int bonusNumber;
    private double total;

    public LottoModel() {
        this.lottoNumbers = new ArrayList<>();
    }

    //테스트 실행을 위해 추가 됨
    public LottoModel(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
        this.lottoNumbers = new ArrayList<>();
    }

    public List<Integer> getWinningLottoNumber() {
        return winningLottoNumber;
    }

    public double getTotal() {
        return total;
    }

    public int getPayment() {
        return payment;
    }

    public int getCountOfLotto() {
        return countOfLotto;
    }

    // 이 메서드는 테스트를 위해 추가됨
    public void addLottoTicket(Lotto lotto) {
        this.lottoNumbers.add(lotto);
    }

    public void setPayment(int payment) {
        this.payment = payment;
        this.countOfLotto = calculateCountOfLotto();
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private int calculateCountOfLotto() {
        return payment / 1000;
    }

    public List<Lotto> generateLottoTickets() {
        int countOfLotto = this.getCountOfLotto();
        for (int i = 0; i < countOfLotto; i++) {
            lottoNumbers.add(createLotto());
        }
        return lottoNumbers;
    }

    public void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Messages.LottoNumberOutOfRangeException);
        }
    }

    public Map<LottoRank, Integer> checkWinningStatistics() {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottoNumbers) {
            LottoRank rank = checkLottoNumber(lotto, winningLottoNumber, bonusNumber);
            statistics.merge(rank, 1, Integer::sum);
            total += rank.getPrizeMoney();
        }
        return statistics;
    }

    private LottoRank checkLottoNumber(Lotto lotto, List<Integer> winningNumbers, int bonusNum) {
        int matchCount = (int) lotto.getLottoArray().stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonusMatch = lotto.getLottoArray().contains(bonusNum) && matchCount == 5;

        return LottoRank.valueOf(matchCount, bonusMatch);
    }


    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void updateWinningLottoNumbers(List<Integer> winningLottoNumber) {
        this.winningLottoNumber = winningLottoNumber;
    }

    public void addBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        winningLottoNumber.add(bonusNumber);
    }
}
