package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoException;
import lotto.model.Lotto;

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

    public Map<String,String> lottoWinningResultCalculation(List<Lotto> lotto , List<Integer> winningNumber, int bonusNumber){
        Map<String,String> lottoWinningResult = new HashMap<>();

        int totalWinningAmount = 0;
        String totalReturnRate;
        int lottoQuantity = lotto.size();
        double totalLottoPurchase = 1000 * lottoQuantity;

        int threeMatches = 0;
        int fourMatches = 0;
        int fiveMatches = 0;
        int fiveBonusMatches = 0;
        int sixMatches = 0;

        for (int quantity = 0 ; quantity < lottoQuantity ; quantity ++){

            int winningAmount = lottoWinningAmount(lotto.get(quantity).getNumbers(), winningNumber, bonusNumber);
            totalWinningAmount += winningAmount;

            if(winningAmount == 5000){
                threeMatches++;
            }

            if(winningAmount == 50000){
                fourMatches++;
            }

            if(winningAmount == 1500000){
                fiveMatches++;
            }

            if(winningAmount == 30000000){
                fiveBonusMatches++;
            }

            if(winningAmount == 200000000){
                sixMatches++;
            }

        }
        totalReturnRate = String.valueOf((totalWinningAmount/totalLottoPurchase)*100);

        lottoWinningResult.put("총 수익률",totalReturnRate);
        lottoWinningResult.put("3개일치",String.valueOf(threeMatches));
        lottoWinningResult.put("4개일치",String.valueOf(fourMatches));
        lottoWinningResult.put("5개일치",String.valueOf(fiveMatches));
        lottoWinningResult.put("5개일치_보너스일치",String.valueOf(fiveBonusMatches));
        lottoWinningResult.put("6개일치",String.valueOf(sixMatches));

        return lottoWinningResult;
    }
    private int lottoWinningAmount(List<Integer> lotto ,List<Integer> winningNumber, int bonusNumber){
        int matchCount = 0;
        for(int i = 0 ; i < winningNumber.size() ; i++){
            if(lotto.contains(winningNumber.get(i))){
                matchCount++;
            }
        }

        if(matchCount == 3){
            return 5000;
        }
        if(matchCount == 4){
            return 50000;
        }
        if(matchCount == 5){
            if(lotto.contains(bonusNumber)){
                return 30000000;
            }
            return 1500000;
        }
        if(matchCount == 6){
            return 200000000;
        }
        return 0;
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

    public boolean inputBonusNumberValidation(String inputBonusNumber){
        try {
            isDigit(inputBonusNumber);
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            isRange(bonusNumber,1,45);
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
