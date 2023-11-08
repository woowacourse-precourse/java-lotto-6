package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoWinningCase;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.constant.DefinedNumber.PERCENT;
import static lotto.constant.ErrorMessage.*;

public class LottoService {

    public List<Integer> reshapeWinningNumber(String inputNumbersWithComma) {
        String[] splitedInputNumbers = getSplitedInputNumbers(inputNumbersWithComma);
        return convertInputType(splitedInputNumbers);
    }

    private static List<Integer> convertInputType(String[] splitedInputNumbers) {
        List<Integer> toBeReturnedInputNumbers = new ArrayList<>();
        for (String splitedInputNumber : splitedInputNumbers) {
            toBeReturnedInputNumbers.add(Integer.parseInt(splitedInputNumber.trim()));
        }
        if(toBeReturnedInputNumbers.contains("")){
            throw new IllegalArgumentException(CONTAINS_EMPTY_NUMBER);
        }
        return toBeReturnedInputNumbers;
    }

    private static String[] getSplitedInputNumbers(String inputNumbersWithComma) {
        String[] splitedInputNumbers = new String[0];
        try {
            splitedInputNumbers = inputNumbersWithComma.split(",");
        } catch (NumberFormatException e) {
            throw new NumberFormatException(CONTAINS_STRING_IN_LOTTO_NUMBER);
        }
        return splitedInputNumbers;
    }

    public int calculateAvailableNumberOfLotteryTickets(int spentAmount) {
        return spentAmount / 1000;
    }

    public List<Lotto> generateRandomLottoNums(int availableTicketsCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < availableTicketsCount; i++) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(integers);
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public LottoWinningCase compareMyNumberWithWinningNumber(Lotto myLottoNumbers, List<Integer> winningNumber, int bonusNumnber) {
        return LottoWinningCase.compareWhichCaseItIs(myLottoNumbers, winningNumber, bonusNumnber);
    }

    public int calculateTotalIncome(Map<LottoWinningCase, Integer> winStatisticMap) {
        int totalIncome = 0;
        for (LottoWinningCase lottoWinningCase : winStatisticMap.keySet()) {
            int winCaseCount = winStatisticMap.get(lottoWinningCase);
            totalIncome += winCaseCount * lottoWinningCase.getReward();
        }
        return totalIncome;
    }

    public String typeConvertIncomeRate(float incomeRate) {

    }

    public String calculateIncomeRate(int totalIncomde, int spentAmount) {return "A";}
}
