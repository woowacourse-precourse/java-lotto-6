package lotto.Model;

import static lotto.Global.Constants.LOTTO_NUMBER_MAX_RANGE;
import static lotto.Global.Constants.LOTTO_NUMBER_MIN_RANGE;
import static lotto.Global.Constants.LOTTO_SALES_AMOUNT_MONEY;
import static lotto.Global.Exception.LOTTO_BONUS_NUMBER_INPUT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Global.LottoAmount;
import lotto.Global.LottoNumberMatch;
import lotto.Global.LottoResult;
import lotto.Global.MatchType;

public class LottoResultGenerator {
    private WinningLotto winningLotto;
    private List<Lotto> selledLottos;

    private static String WINNING_NUMBER_MATCHES = "winning";
    private static String BONUS_NUMBER_MATCHES = "bonus";

    public LottoResultGenerator() {
        this.selledLottos = new ArrayList<>();
    }

    private class WinningLotto {
        private Lotto winningLotto;
        private int bonusNumber;

        public WinningLotto(Lotto winningLotto, int bonusNumber) {
            this.winningLotto = winningLotto;
            if (isBonusNumberValid(bonusNumber)) {
                this.bonusNumber = bonusNumber;
            }
        }

        private boolean isBonusNumberValid(int bonusNumber) {
            if (bonusNumber < LOTTO_NUMBER_MIN_RANGE || bonusNumber > LOTTO_NUMBER_MAX_RANGE
                    || winningLotto.matchesSingleNumber(bonusNumber) == 1) {
                throw new IllegalArgumentException(LOTTO_BONUS_NUMBER_INPUT.getErrorPhrase());
            }
            return true;
        }

        public HashMap<String, Integer> matchesResult(Lotto lotto) {
            HashMap<String, Integer> result = new HashMap<>();
            result.put(WINNING_NUMBER_MATCHES, lotto.matchesNumberList(winningLotto));
            result.put(BONUS_NUMBER_MATCHES, lotto.matchesSingleNumber(bonusNumber));
            return result;
        }
    }

    public void getSelledLotto(Lotto lotto) {
        selledLottos.add(lotto);
    }

    public void putWinningLottoNumber(Lotto winningLottoValue, int bonusNumber) {
        winningLotto = new WinningLotto(winningLottoValue, bonusNumber);
    }

    public HashMap<String, Integer> getLottosResult() {
        HashMap<String, Integer> result = new HashMap<>();
        for (LottoResult lottoResult : LottoResult.values()) {
            MatchType matchType = LottoNumberMatch.valueOf(lottoResult.name()).getMatchType();
            result.put(lottoResult.getName(), getTotalResultNumber(lottoResult.name(), matchType));
        }
        return result;
    }

    public float getLottoRateOfResult(HashMap<String, Integer> lottoResult) {
        float result = 0;
        for (LottoResult lotto : LottoResult.values()) {
            result += lottoResult.get(lotto.getName()) * LottoAmount.valueOf(lotto.name()).getAmount();
        }
        result = (result / (selledLottos.size() * LOTTO_SALES_AMOUNT_MONEY)) * 100;
        return result;
    }

    private int getTotalResultNumber(String name, MatchType matchType) {
        if (matchType.equals(MatchType.NO)) {
            return getResultNumber(LottoNumberMatch.valueOf(name).getWinningNumber());
        }
        return getResultNumber(LottoNumberMatch.valueOf(name).getWinningNumber(), matchType.getNumber());
    }

    private int getResultNumber(int winningMatchNumber) {
        HashMap<String, Integer> lottoMatchResult = new HashMap<>();
        int result = 0;
        for (Lotto lotto : selledLottos) {
            lottoMatchResult = winningLotto.matchesResult(lotto);
            if (checkWinningNumber(lottoMatchResult, winningMatchNumber)) {
                result += 1;
            }
        }
        return result;
    }

    private int getResultNumber(int winningMatchNumber, int bonusMatchNumber) {
        HashMap<String, Integer> lottoMatchResult = new HashMap<>();
        HashMap<String, Integer> criteriaMatchNumber = getCriteriaMatchNumber(winningMatchNumber, bonusMatchNumber);
        int result = 0;
        for (Lotto lotto : selledLottos) {
            lottoMatchResult = winningLotto.matchesResult(lotto);
            if (checkNumbers(lottoMatchResult, criteriaMatchNumber)) {
                result += 1;
            }
        }
        return result;
    }

    private HashMap<String, Integer> getCriteriaMatchNumber(int winningMatchNumber, int bonusMatchNumber) {
        HashMap<String, Integer> criteriaMatchNumber = new HashMap<>();
        criteriaMatchNumber.put(WINNING_NUMBER_MATCHES, winningMatchNumber);
        criteriaMatchNumber.put(BONUS_NUMBER_MATCHES, bonusMatchNumber);
        return criteriaMatchNumber;
    }

    private Boolean checkNumbers(HashMap<String, Integer> result, HashMap<String, Integer> criteriaNumber) {
        return checkWinningNumber(result, criteriaNumber.get(WINNING_NUMBER_MATCHES)) && checkBonusNumber(result,
                criteriaNumber.get(BONUS_NUMBER_MATCHES));
    }

    private Boolean checkWinningNumber(HashMap<String, Integer> result, int winningMatchNumber) {
        return result.get(WINNING_NUMBER_MATCHES) == winningMatchNumber;
    }

    private Boolean checkBonusNumber(HashMap<String, Integer> result, int bonusMatchNumber) {
        return result.get(BONUS_NUMBER_MATCHES) == bonusMatchNumber;
    }


}
