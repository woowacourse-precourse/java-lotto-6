package lotto.controller;

import static lotto.model.Lotto.*;
import static lotto.model.LottoConstantsNumber.*;
import static lotto.view.LottoView.*;

import java.util.*;
import lotto.view.*;
import lotto.model.*;
import lotto.exception.*;
public class LottoController {

    static String[] strTotalWinningNumbers;
    public static ArrayList<Integer> totalWinningNumbers=new ArrayList<>();;
    public static List<Lotto> lottoList;
    public static int bonusNumber;
    public int processInputPurchaseAmount() {
        int price;

            while (true) {
                price = inputPurchaseAmount();
                try {
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

    public void processCreateLotto(int price){
        // 구매한 개수 및 로또번호 리스트 출력
        lottoList = createLottoList(price);
        printPurchaseResult(lottoList);
    }

    public void processInputWinningNumber(){
        String inputWinningNumber;
        while (true) {
            inputWinningNumber= inputWinningNumber();
            try {
                // 입력 당첨 번호가 유효하면 종료
                String[] winningNumberStr=validateInputWinningNumberInRange(inputWinningNumber);
                strTotalWinningNumbers=validateInputWinningNumberDuplication(winningNumberStr);
                break; //
            } catch (IllegalArgumentException e) {
                // 예외 메시지 출력
                System.out.println(e.getMessage());
            }
        }
        defineTotalWinningNumber();
    }

    public void processInputBonusNumber(){
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

    public void defineTotalWinningNumber(){
        for (String eachNumber : strTotalWinningNumbers) {
            totalWinningNumbers.add(Integer.parseInt(eachNumber));
        }
    }

    public void processCheckWinningNumbers(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] rankCounts = new int[WinningRank.values().length];

        for (Lotto lotto : lottos) {
            int matchingCount = countMatchingNumbers(lotto, winningNumbers);
            boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);

            WinningRank rank = WinningRank.calculateRank(matchingCount, hasBonusNumber);

            rankCounts[rank.ordinal()]++;
        }

        printWinningResults(rankCounts);
    }

    private int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

}
