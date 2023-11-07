package lotto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Controller.LottoController;
import lotto.Global.LottoResult;

public class LottoResultGenerator {
    private WinningLotto winningLotto;
    private List<Lotto> selledLottos;

    private static String WINNING_NUMBER_MATCHES = "winning";
    private static String BONUS_NUMBER_MATCHES = "bonus";
    private static int FIFTH_WINNING_NUMBER_MATCH_COUNT = 3;
    private static int FIFTH_WINNING_AMOUNT = 5000;
    private static int FOURTH_WINNING_NUMBER_MATCH_COUNT = 4;
    private static int FOURTH_WINNING_AMOUNT = 50000;
    private static int THIRD_WINNING_NUMBER_MATCH_COUNT = 5;
    private static int THIRD_BONUS_NUMBER_MATCH_COUNT = 0;
    private static int THIRD_WINNING_AMOUNT = 1500000;
    private static int SECOND_WINNING_NUMBER_MATCH_COUNT = 5;
    private static int SECOND_BONUS_NUMBER_MATCH_COUNT = 1;
    private static int SECOND_WINNING_AMOUNT = 30000000;
    private static int FIRST_WINNING_NUMBER_MATCH_COUNT = 6;
    private static int FIRST_WINNING_AMOUNT = 2000000000;

    public LottoResultGenerator() {
        this.selledLottos = new ArrayList<>();
    }

    private class WinningLotto {
        private List<Integer> winningNumber;
        private int bonusNumber;

        public WinningLotto(List<Integer> winningNumber, int bonusNumber) {
            this.winningNumber = winningNumber;
            this.bonusNumber = bonusNumber;
        }

        public HashMap<String, Integer> matchesResult(Lotto lotto) {
            HashMap<String, Integer> result = new HashMap<>();
            result.put(WINNING_NUMBER_MATCHES, lotto.matchesNumberList(winningNumber));
            result.put(BONUS_NUMBER_MATCHES, lotto.matchesSingleNumber(bonusNumber));
            return result;
        }
    }

    public void getSelledLotto(Lotto lotto) {
        selledLottos.add(lotto);
    }

    public void putWinningLottoNumber(List<Integer> winningNumber, int bonusNumber) {
        winningLotto = new WinningLotto(winningNumber, bonusNumber);
    }

    public HashMap<String, Integer> getLottosResult() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put(LottoResult.FIFTH_RESULT.getName(), getResultNumber(FIFTH_WINNING_NUMBER_MATCH_COUNT));
        result.put(LottoResult.FOURTH_RESULT.getName(), getResultNumber(FOURTH_WINNING_NUMBER_MATCH_COUNT));
        result.put(LottoResult.THIRD_RESULT.getName(),
                getResultNumber(THIRD_WINNING_NUMBER_MATCH_COUNT, THIRD_BONUS_NUMBER_MATCH_COUNT));
        result.put(LottoResult.SECOND_RESULT.getName(),
                getResultNumber(SECOND_WINNING_NUMBER_MATCH_COUNT, SECOND_BONUS_NUMBER_MATCH_COUNT));
        result.put(LottoResult.FIRST_RESULT.getName(), getResultNumber(FIRST_WINNING_NUMBER_MATCH_COUNT));
        return result;
    }

    public float getLottoRateOfResult(HashMap<String, Integer> lottoResult) {
        float result = 0;
        result += lottoResult.get(LottoResult.FIFTH_RESULT.getName()) * FIFTH_WINNING_AMOUNT;
        result += lottoResult.get(LottoResult.FOURTH_RESULT.getName()) * FOURTH_WINNING_AMOUNT;
        result += lottoResult.get(LottoResult.THIRD_RESULT.getName()) * THIRD_WINNING_AMOUNT;
        result += lottoResult.get(LottoResult.SECOND_RESULT.getName()) * SECOND_WINNING_AMOUNT;
        result += lottoResult.get(LottoResult.FIRST_RESULT.getName()) * FIRST_WINNING_AMOUNT;
        result = (result / (selledLottos.size() * LottoController.LOTTO_SALES_AMOUNT_MONEY)) * 100;
        return result;
    }

    private int getResultNumber(int winningMatchNumber) {
        HashMap<String, Integer> lottoMatchResult = new HashMap<>();
        int result = 0;
        for (Lotto lotto : selledLottos) {
            lottoMatchResult = winningLotto.matchesResult(lotto);
            if (lottoMatchResult.get(WINNING_NUMBER_MATCHES) == winningMatchNumber) {
                result += 1;
            }
        }
        return result;
    }

    private int getResultNumber(int winningMatchNumber, int bonusMatchNumber) {
        HashMap<String, Integer> lottoMatchResult = new HashMap<>();
        int result = 0;
        for (Lotto lotto : selledLottos) {
            lottoMatchResult = winningLotto.matchesResult(lotto);
            if (lottoMatchResult.get(WINNING_NUMBER_MATCHES) == winningMatchNumber
                    && lottoMatchResult.get(BONUS_NUMBER_MATCHES) == bonusMatchNumber) {
                result += 1;
            }
        }
        return result;
    }


}
