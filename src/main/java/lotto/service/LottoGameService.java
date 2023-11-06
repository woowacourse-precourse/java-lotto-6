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

    public boolean isDigit(String input){
        try {
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_DiGIT.getMessage());
        }
    }

    public boolean isThousandUnits(String inputPurchaseAmount){
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        int lottoPurchaseAmountRemain = purchaseAmount % 1000;

        if(lottoPurchaseAmountRemain != 0){
           throw new IllegalArgumentException(LottoException.INPUT_NOT_THOUSAND_UNITS.getMessage());
        }
        return true;
    }

    public int lottoQuantity(int lottoPurchaseAmount){
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

    public boolean isWinningNumberDigit(String[] inputWinningNumberSplit){
        try {

            for (int i = 0 ; i < inputWinningNumberSplit.length ; i++){
                isDigit(inputWinningNumberSplit[i]);
            }
            return true;
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean isRange(int inputBonusNumber,int start , int end){

        if(inputBonusNumber < start || inputBonusNumber > end){
            throw new IllegalArgumentException(LottoException.INPUT_NOT_RANGE.getMessage());
        }
        return true;
    }

}
