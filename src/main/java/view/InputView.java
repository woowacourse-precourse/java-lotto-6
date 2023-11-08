package view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static final String PURCHASE_MESSAGE =
            "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_MESSAGE =
            "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE =
            "\n보너스 번호를 입력해 주세요.";

    public static int inputPurchasePrice(){
        System.out.println(PURCHASE_MESSAGE);

        int purchasePrice = Integer.parseInt(readLine());
        checkingPurchaseException(purchasePrice);
        return purchasePrice;
    }

    private static void checkingPurchaseException(int purchasePrice) {
        if(purchasePrice % 1000 != 0 ){
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> inputWinningNumber(){
        System.out.println(WINNING_NUMBER_MESSAGE);

        String[] numbers = readLine().split(",");

        List<Integer> winningNumber = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();

        checkingWinningNumberException(winningNumber);

        return winningNumber;
    }

    private static void checkingWinningNumberException(List<Integer> winningNumber) {
        for(Integer i : winningNumber){
            if(i > 45){
                throw new IllegalArgumentException();
            }
            if(i<1){
                throw new IllegalArgumentException();
            }
        }
        Set<Integer> convertSet = new HashSet<>(winningNumber);
        if(convertSet.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    public static int inputBonusNumber(List<Integer> winningNumber){
        System.out.println(BONUS_NUMBER_MESSAGE);
        int BonusNumber =  Integer.parseInt(readLine());

        checkingBonusNumberException(winningNumber, BonusNumber);

        return BonusNumber;
    }

    private static void checkingBonusNumberException(List<Integer> winningNumber, int BonusNumber) {
        if(BonusNumber > 45){
            throw new IllegalArgumentException();
        }
        if(BonusNumber <1){
            throw new IllegalArgumentException();
        }
        Set<Integer> convertSet = new HashSet<>(winningNumber);
        if(convertSet.contains(BonusNumber)){
            throw new IllegalArgumentException();
        }
    }

}
