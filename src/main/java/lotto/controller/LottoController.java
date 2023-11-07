package lotto.controller;

import static lotto.model.Lotto.*;
import static lotto.model.LottoConstantsNumber.*;
import static lotto.view.LottoView.*;

import java.util.*;
import lotto.view.*;
import lotto.model.*;
import lotto.exception.*;
public class LottoController {


    public static String[] strTotalWinningNumbers;
    public static ArrayList<Integer> totalWinningNumbers=new ArrayList<>();
    public static List<Lotto> lottoList;
    public static int bonusNumber;
    public static int[] rankCounts;
    public static int processInputPurchaseAmount() {
        int price;
            while (true) {
                try {
                    price = inputPurchaseAmount();
                    // 입력 금액이 유효하면 종료
                    validateInputPurchaseAmount(price);
                    break; //
                } catch (IllegalArgumentException e) {
                    // 예외 메시지 출력
                    System.out.println(e.getMessage());
                }
            }
            return price;
    }

    public static void processCreateLotto(int price){
        // 구매한 개수 및 로또번호 리스트 출력
        lottoList = createLottoList(price);
        printPurchaseResult(lottoList);
    }

    public static void processInputWinningNumber(){
        String inputWinningNumber;
        while (true) {
            inputWinningNumber= inputWinningNumber();
            try {
                // 입력 당첨 번호가 유효하면 종료
                String[] winningNumberStr=validateInputWinningNumberInRange(inputWinningNumber);
                validateInputWinningNumberSize(winningNumberStr);
                strTotalWinningNumbers=validateInputWinningNumberDuplication(winningNumberStr);
                break; //
            } catch (IllegalArgumentException e) {
                // 예외 메시지 출력
                System.out.println(e.getMessage());
            }
        }
        defineTotalWinningNumber();
    }

    public static void processInputBonusNumber(){
        // validate 후 totalWinningNumbers에 문자열(숫자)를 정수형(숫자로) 바꿀 것
        String inputBonusNumber;
        while (true) {
            inputBonusNumber= inputBonusNumber();
            try {
                // 입력 보너스 번호가 유효하면 종료
                validateInputBonusNumberInRange(inputBonusNumber);
                validateInputBonusNumberDuplication(inputBonusNumber,strTotalWinningNumbers);
                break; //
            } catch (IllegalArgumentException e) {
                // 예외 메시지 출력
                System.out.println(e.getMessage());
            }
        }
        bonusNumber=Integer.parseInt(inputBonusNumber);
    }

    public static void defineTotalWinningNumber(){
        for (String eachNumber : strTotalWinningNumbers) {
            totalWinningNumbers.add(Integer.parseInt(eachNumber));
        }
    }

    public static void processCheckWinningNumbers(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        rankCounts = new int[WinningRank.values().length];

        for (Lotto lotto : lottos) {
            int matchingCount = countMatchingNumbers(lotto, winningNumbers);
            boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);

            WinningRank rank = WinningRank.calculateRank(matchingCount, hasBonusNumber);


            rankCounts[rank.ordinal()]++;
        }

        printWinningResults(rankCounts);
    }

    public static int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public static boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public static double calculateRate(int purchaseAmount, int totalPrizeAmount) {
        double rate = ((double) totalPrizeAmount / (double)purchaseAmount) * 100;
        return (double) Math.round(rate * 100) /100;
    }

    public static void calculateTotalRate() {
        int totalPrizeAmount = 0;
        for (WinningRank rank : WinningRank.values()) {
            if (rank != WinningRank.NONE) {
                totalPrizeAmount += rankCounts[rank.ordinal()] * rank.getPrize();
            }
        }

        double rate = calculateRate(purchaseAmount, totalPrizeAmount);
        printTotalRate(rate);
    }

}
