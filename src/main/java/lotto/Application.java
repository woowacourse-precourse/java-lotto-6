package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Application {
    public static void main(String[] args) {
//        String inputPurchaseAmount = inputPurchaseAmount();
//        int purchaseAmount = inputPurchaseAmountValidation(inputPurchaseAmount);
//        int lottoQuantity = lottoQuantity(purchaseAmount);
//
//        List<Lotto> lottos = createLottos(lottoQuantity);
//        purchaseLottoNumbersDisplay(lottos);
//
//        String inputWinningNumber = inputWinningNumber();
//        String[] inputWinningNumberSplit = inputWinningNumberSplit(inputWinningNumber);
//        List<Integer> winningNumber = inputWinningNumberValidation(inputWinningNumberSplit);
//
//        String inputBonusNumber = inputBonusNumber();
//        int inputBonusNumberValidation = inputBonusNumberValidation(inputBonusNumber);
//        int bonusNumber = inputBonusNumberRangeValidation(inputBonusNumberValidation);
//
//        lottoWinningResult(lottos,winningNumber,bonusNumber);
    }


    public static int inputPurchaseAmountValidation(String inputPurchaseAmount){
        try {
            int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
            return purchaseAmount;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000 ");
        }
    }

    public static int lottoQuantity(int lottoPurchaseAmount){
        int lottoPurchaseAmountRemain = lottoPurchaseAmount % 1000;
        if(lottoPurchaseAmountRemain != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액을 1,000원 단위로 입력하세요.");
        }
        int lottoQuantity = lottoPurchaseAmount / 1000;
        return lottoQuantity;
    }

    public static List<Lotto> createLottos(int lottoQuantity){
        List<Lotto> lottos= new ArrayList<>();

        for(int quantity = 1; quantity <= lottoQuantity ; quantity++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }





    public static String[] inputWinningNumberSplit(String inputWinningNumber){
        String[] inputWinningNumberSplit = inputWinningNumber.split(",");
        if(inputWinningNumberSplit.length != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉼표(,)를 기준으로 6자리를 입력해주세요.");
        }
        return inputWinningNumberSplit;
    }

    public static List<Integer> inputWinningNumberValidation(String[] inputWinningNumberSplit){
        try {
            List<Integer> winningNumber = new ArrayList<>();
            for (int i = 0 ; i < inputWinningNumberSplit.length ; i++){
                int number = Integer.parseInt(inputWinningNumberSplit[i]);
                winningNumber.add(number);
            }
            Collections.sort(winningNumber);
            return winningNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 숫자로 입력해주세요.");
        }
    }



    public static int inputBonusNumberValidation(String inputBonusNumber){
        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            return bonusNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 숫자로 입력해주세요.");
        }
    }

    public static int inputBonusNumberRangeValidation(int inputBonusNumberValidation){
        if(inputBonusNumberValidation < 1 || inputBonusNumberValidation > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해 주세요.");
        }
        return inputBonusNumberValidation;
    }






}
