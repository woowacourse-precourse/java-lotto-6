package lotto.utils;


import static lotto.enums.ErrorMessage.*;
import static lotto.enums.GuideMessage.*;
import static lotto.enums.LottoCalculateNums.*;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResultDTO;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoAmount;

public class LottoPrompt {

    public static Integer inputPurchaseAmount(){
        System.out.println(INPUT_PURCHASE_MONEY);
        Integer purchaseMoney = 0;
        try{
            String inputMoney = Console.readLine();
            purchaseMoney = validatePurchaseMoney(inputMoney);
        }catch (IllegalArgumentException e){
            System.out.println(INVALID_PURCHASE_NUMBER_FORMAT.getType());
            purchaseMoney = inputPurchaseAmount();
        }

        return purchaseMoney;
    }

    private static Integer validatePurchaseMoney(String input){
        if(!isInteger(input)){
            throw new IllegalArgumentException(INVALID_PURCHASE_NUMBER_FORMAT.getType());
        }

        int inputMoney = Integer.parseInt(input);
        if(inputMoney % WON != 0){
            throw new IllegalArgumentException(INVALID_PURCHASE_NUMBER_FORMAT.getType());
        }

        return (inputMoney / WON);
    }

    private static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }


    public static void printLottoList(List<Lotto> lottoList){
        int lottoCount = lottoList.size();
        System.out.println(lottoCount + PURCHASE_LOTTO_COUNT);

        for(Lotto lotto : lottoList){
            lotto.getNumbers().stream().sorted();
            System.out.print(LEFT_BRACKET);
            for(int i=0; i<LOTTO_COUNT - 1; i++){
                System.out.print(lotto.getNumbers().get(i) + COMMA + BLANK);
            }
            System.out.print(lotto.getNumbers().get(LOTTO_COUNT - 1));
            System.out.println(RIGHT_BRACKET);
        }
        System.out.println();
    }

    public static List<Integer> inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBER);
        List<Integer> winningNumbers = new ArrayList<>();

        try{
            String winningInput = Console.readLine();
            validateWinningNumbers(winningInput, winningNumbers);
        }
        catch (IllegalArgumentException e){
            System.out.println(INVALID_WINNING_NUMBER_FORMAT.getType());
            winningNumbers = inputWinningNumbers();
        }

        return winningNumbers;
    }

    private static boolean validateWinningNumbers(String winningInput, List<Integer> winningNumbers){
        String[] split = winningInput.split(COMMA);
        Arrays.stream(split).forEach(x -> winningNumbers.add(Integer.parseInt(x)));

        if(winningNumbers.size() != LOTTO_COUNT){
            return false;
        }
        return true;
    }

    public static int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        Integer bonusNumber = 0;
        try{
            String bonusInput = Console.readLine();
            bonusNumber = validateBonusNumber(bonusInput);
        }
        catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.getType());
            bonusNumber = inputBonusNumber();
        }

        return bonusNumber;
    }

    private static Integer validateBonusNumber(String input){
        if(Integer.parseInt(input) < MIN || Integer.parseInt(input) > MAX){
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.getType());
        }
        return Integer.parseInt(input);
    }

    public static void printLottoResult(LottoResultDTO lottoResultDTO){
        System.out.println(PRINT_RESUlT);

        for(LottoAmount lottoAmount : LottoAmount.values()){
            System.out.print(Integer.parseInt(lottoAmount.getMatchType()) + PRINT_SAME);

            if(lottoAmount.isBonus()){
                System.out.print(PRINT_BONUS_SAME);
            }
            System.out.print(LEFT_RESULT_BRACKET + DecimalFormat.getInstance().format(lottoAmount.getAmount()) + PRINT_WON +RIGHT_RESULT_BRACKET);
            System.out.println(lottoResultDTO.matchMap().get(lottoAmount.getMatchType())+PRINT_COUNT);
        }
        System.out.println(PRINT_TOTAL_REVENUE1 + String.format("%.1f", lottoResultDTO.totalRevenueRate()) +PRINT_TOTAL_REVENUE2);
    }
}
