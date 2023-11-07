package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoException;
import lotto.LottoRank;
import lotto.domain.Lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LottoGameService {

    public List<Lotto> createLotto(int lottoQuantity){
        List<Lotto> lottos= new ArrayList<>();

        for(int quantity = 1; quantity <= lottoQuantity ; quantity++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Integer> createWinningNumber(String inputWinningNumber){
        List<Integer> winningNumber = new ArrayList<>();
        String[] inputWinningNumberSplit = inputWinningNumber.split(",");

        for (int i = 0 ; i < inputWinningNumberSplit.length ; i++){
            int number = Integer.parseInt(inputWinningNumberSplit[i]);
            winningNumber.add(number);
        }

        Collections.sort(winningNumber);

        return winningNumber;
    }

    public boolean inputPurchaseAmountValidation(String inputPurchaseAmount){
        try {
            isDigit(inputPurchaseAmount);
            isThousandUnits(inputPurchaseAmount);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<LottoRank> lottoWinningResult(List<Lotto> lotto , List<Integer> winningNumber, int bonusNumber){
        List<LottoRank> lottoRanks = new ArrayList<>();

        int lottoQuantity = lotto.size();

        for (int quantity = 0 ; quantity < lottoQuantity ; quantity ++){
            LottoRank lottoRank = getLottoRank(lotto.get(quantity).getNumbers(), winningNumber, bonusNumber);
            lottoRanks.add(lottoRank);
        }
        return lottoRanks;
    }

    public BigDecimal totalReturnRateCalculation (List<LottoRank> lottoRanks){
        BigDecimal totalLottoPurchase = BigDecimal.ZERO;
        BigDecimal totalWinningAmount = BigDecimal.ZERO;
        BigDecimal totalReturnRate;

        for (LottoRank lottoRank : lottoRanks){
            totalLottoPurchase = totalLottoPurchase.add(BigDecimal.valueOf(1000)) ;
            totalWinningAmount = totalWinningAmount.add(BigDecimal.valueOf(Double.valueOf(lottoRank.getWinningMoney())));
        }

        totalReturnRate = totalWinningAmount.divide(totalLottoPurchase,1, RoundingMode.HALF_UP);
        totalReturnRate = totalReturnRate.multiply(BigDecimal.valueOf(100));

        return totalReturnRate;
    }

    public boolean inputWinningNumberValidation(String inputWinningNumber){
        try {
            String[] inputWinningNumberSplit = inputWinningNumberSplit(inputWinningNumber);
            isWinningNumberDigit(inputWinningNumberSplit);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean inputBonusNumberValidation(List<Integer> winningNumber, String inputBonusNumber){
        try {
            isDigit(inputBonusNumber);
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            isRange(bonusNumber,1,45);
            isDuplicationNumber(winningNumber,bonusNumber);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int lottoQuantity(int lottoPurchaseAmount){
        int lottoQuantity = lottoPurchaseAmount / 1000;
        return lottoQuantity;
    }

    private boolean isDuplicationNumber(List<Integer> winningNumber, int bonusNumber){
        if(winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(LottoException.INPUT_DUPLICATION_NUMBER.getMessage());
        }
        return true;
    }

    private LottoRank getLottoRank(List<Integer> lotto ,List<Integer> winningNumber, int bonusNumber){
        int matchCount = 0;
        boolean matchBonusNumber = false;

        for(int i = 0 ; i < winningNumber.size() ; i++){
            if(lotto.contains(winningNumber.get(i))){
                matchCount++;
            }
        }

        if(matchCount == 5){
            if(lotto.contains(bonusNumber)){
                matchBonusNumber = true;
            }
        }

        LottoRank lottoRank = LottoRank.getLottoRank(matchCount,matchBonusNumber);

        return lottoRank;
    }

    private boolean isDigit(String input){
        try {
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_DiGIT.getMessage());
        }
    }

    private boolean isThousandUnits(String inputPurchaseAmount){
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        int lottoPurchaseAmountRemain = purchaseAmount % 1000;
        if(lottoPurchaseAmountRemain != 0){
           throw new IllegalArgumentException(LottoException.INPUT_NOT_THOUSAND_UNITS.getMessage());
        }
        return true;
    }

    private String[] inputWinningNumberSplit(String inputWinningNumber){
        String[] inputWinningNumberSplit = inputWinningNumber.split(",");
        if(inputWinningNumberSplit.length != 6){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_SPLIT.getMessage());
        }
        return inputWinningNumberSplit;
    }

    private boolean isWinningNumberDigit(String[] inputWinningNumberSplit){
        try {
            for (int i = 0 ; i < inputWinningNumberSplit.length ; i++){
                isDigit(inputWinningNumberSplit[i]);
            }
            return true;
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private boolean isRange(int inputBonusNumber,int start , int end){
        if(inputBonusNumber < start || inputBonusNumber > end){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_RANGE.getMessage());
        }
        return true;
    }

}
