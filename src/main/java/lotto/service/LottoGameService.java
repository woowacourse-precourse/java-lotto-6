package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoException;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public int inputPurchaseAmountValidation(String inputPurchaseAmount){
        try {
            int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
            return purchaseAmount;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_DiGIT.getMessage());
        }
    }

    public int lottoQuantity(int lottoPurchaseAmount){
        int lottoPurchaseAmountRemain = lottoPurchaseAmount % 1000;
        if(lottoPurchaseAmountRemain != 0){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_THOUSAND_UNITS.getMessage());
        }
        int lottoQuantity = lottoPurchaseAmount / 1000;
        return lottoQuantity;
    }

    public String[] inputWinningNumberSplit(String inputWinningNumber){
        String[] inputWinningNumberSplit = inputWinningNumber.split(",");
        if(inputWinningNumberSplit.length != 6){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_SPLIT.getMessage());
        }
        return inputWinningNumberSplit;
    }

    public List<Integer> inputWinningNumberValidation(String[] inputWinningNumberSplit){
        try {
            List<Integer> winningNumber = new ArrayList<>();
            for (int i = 0 ; i < inputWinningNumberSplit.length ; i++){
                int number = Integer.parseInt(inputWinningNumberSplit[i]);
                winningNumber.add(number);
            }
            Collections.sort(winningNumber);
            return winningNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_DiGIT.getMessage());
        }
    }

    public int inputBonusNumberValidation(String inputBonusNumber){
        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            return bonusNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_DiGIT.getMessage());
        }
    }

    public int inputBonusNumberRangeValidation(int inputBonusNumberValidation){
        if(inputBonusNumberValidation < 1 || inputBonusNumberValidation > 45){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_RANGE.getMessage());
        }
        return inputBonusNumberValidation;
    }

}
