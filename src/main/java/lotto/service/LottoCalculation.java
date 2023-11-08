package lotto.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.View.OutputView;
import lotto.constant.LottoRank;
import lotto.constant.constant;
import lotto.domain.IssuedLottos;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class LottoCalculation {
    private Map<Integer, Integer> lottoResultstat = new LinkedHashMap<>();
    private static final String PATTERN = "#,##0.0";
    private static final int PERCENT = 100;
    private static final int MATCHBONUSNUMBER = 10;

    public LottoResult lottoResult(List<Integer> countWinningLotto){
        InputLottoResultKey(lottoResultstat);
        for(Entry<Integer, Integer> lottoResultentry : lottoResultstat.entrySet()){
            if(countWinningLotto.contains(lottoResultentry.getKey())){
                int count = lottoResultentry.getValue();
                count++;
                lottoResultentry.setValue(count);
            }
        }
        OutputView.pirntWinningStatistics(lottoResultstat);
        return new LottoResult(lottoResultstat);
    }

    public List<Integer>  CountWinningLottos(IssuedLottos issuedLottos, Lotto lotto){
        List<Integer> countWinningNumbers = new ArrayList<>();
        for(int i = 0 ; i < issuedLottos.size() ; i++){
            List<Integer> issuedLotto = issuedLottos.find_issued_lotto_by_index(i);
            int count = CountCorrectNumber(issuedLotto, lotto.getLottoNumbersWithoutBonusNumber());
            if(count == constant.BEFOREBONUSNUMBERSIZE && isBonusNumber(issuedLotto, lotto.getBonusNumber())){
                count *= MATCHBONUSNUMBER;
            }
            countWinningNumbers.add(count);
        }
        return countWinningNumbers;
    }


    public String getYield(int purchaseAmount) {
        int Lotto_Earning = add_Lotto_Earnings();
        if (Lotto_Earning == 0) {
            return "0.0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(PATTERN);
        return decimalFormat.format(((double) Lotto_Earning / purchaseAmount)*PERCENT);
    }

    private int add_Lotto_Earnings(){
        int Lotto_Earnings = 0;
        List<Integer> result = new ArrayList<>(lottoResultstat.values());
        List<Integer> allPrices = Arrays.stream(LottoRank.values())
                .map(LottoRank::getPrice)
                .toList();

        for(int i = 0 ; i < result.size() ; i++){
            Lotto_Earnings += (result.get(i) * allPrices.get(i));
        }
        return Lotto_Earnings;
    }

    private int CountCorrectNumber(List<Integer> issuedLotto, List<Integer> lotto_numbers){
        int count = 0;
        for (Integer number : issuedLotto) {
            if (lotto_numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBonusNumber(List<Integer> issuedLotto, int BonusNumber){
        if(issuedLotto.contains(BonusNumber)){
            return true;
        }
        return false;
    }

    public void InputLottoResultKey(Map<Integer, Integer> lottoresult) {
        int[] allRanks = Arrays.stream(LottoRank.values())
                .mapToInt(LottoRank::getCount_correct_number)
                .toArray();
        for(int i = 0; i < constant.BEFOREBONUSNUMBERSIZE ; i++){
            lottoresult.put(allRanks[i], 0);
        }
    }
}
