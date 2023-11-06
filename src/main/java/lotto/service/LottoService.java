package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WiningRank;

public class LottoService {

    private static final int DEFAULT_COUNT = 0;
    private static final int BONUS_CHECK_CRITERIA = 1;
    private static final int ADD_COUNT = 1;

    private HashMap<WiningRank, Integer> winingDetails = new LinkedHashMap<>();
    private List<Integer> matchNumbers = new ArrayList<>();
    private List<Integer> notMatchNumbers = new ArrayList<>();
    private boolean bonusMatch;

    public LottoService() {
        winingDetails.put(WiningRank.FIFTH, DEFAULT_COUNT);
        winingDetails.put(WiningRank.FOURTH, DEFAULT_COUNT);
        winingDetails.put(WiningRank.THIRD, DEFAULT_COUNT);
        winingDetails.put(WiningRank.SECOND, DEFAULT_COUNT);
        winingDetails.put(WiningRank.FIRST, DEFAULT_COUNT);
        bonusMatch = false;
    }

    public HashMap<WiningRank, Integer> getWiningDetails() {
        return winingDetails;
    }

    public List<Integer> getMatchNumbers() {
        return matchNumbers;
    }

    public List<Integer> getNotMatchNumbers() {
        return notMatchNumbers;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }

    public void compareLottoNumber(Buyer buyer, LottoNumber lottoNumber) {
        for (Lotto lotto : buyer.getLottoTickets()) {
            setMacthNumbers(lotto, lottoNumber);
            setNotMacthNumbers(lotto, lottoNumber);
            confirmMatchBonusNumber(lottoNumber);
            applyWiningResult();
        }
    }

    private void setMacthNumbers(Lotto lotto, LottoNumber lottoNumber) {
        matchNumbers = lotto.getNumbers().stream()
                .filter(n -> lottoNumber.getWinningNumbers().contains(n))
                .collect(Collectors.toList());
    }

    private void setNotMacthNumbers(Lotto lotto, LottoNumber lottoNumber) {
        notMatchNumbers = lotto.getNumbers().stream()
                .filter(n -> !(lottoNumber.getWinningNumbers().contains(n)))
                .collect(Collectors.toList());
    }

    private void confirmMatchBonusNumber(LottoNumber lottoNumber) {
        if (notMatchNumbers.size() == BONUS_CHECK_CRITERIA) {
            bonusMatch = notMatchNumbers.contains(lottoNumber.getBonusNumber());
        }
    }

    private void applyWiningResult() {
        for (WiningRank rank : winingDetails.keySet()) {
            if (matchNumbers.size() == rank.getMatchCount() && bonusMatch == rank.isBonusMatch()) {
                winingDetails.replace(rank, winingDetails.get(rank) + ADD_COUNT);
            }
        }
    }
}
