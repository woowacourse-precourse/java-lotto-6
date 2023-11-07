package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class UserInterface {
    enum Message{
        INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.\n"),
        INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요.\n"),
        INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n"),
        OUTPUT_PURCHASED_LOTTO("\n%d개를 구매했습니다.\n"),
        OUTPUT_STATISTICS("\n당첨 통계\n---\n"),
        OUTPUT_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.\n");

        private String consoleMessage;

        Message(String consoleMessage) {
            this.consoleMessage = consoleMessage;
        }
        String getMessage(){
            return consoleMessage;
        }
        }

    private final int LOTTO_PRICE = 1000;

    private int getPurchaseAmount(){
        System.out.printf(Message.INPUT_PURCHASE_AMOUNT.getMessage());
        try {
            int purchaseAmount = Integer.valueOf(Console.readLine());
            if(purchaseAmount%LOTTO_PRICE !=0){
                throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지지 않습니다.\n");
            }
            return purchaseAmount;
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }

    }

    public int getValidatedPurchaseAmount (){
        while(true) {
            try {
                int purchaseAmount = getPurchaseAmount();
                return purchaseAmount;
            }catch (IllegalArgumentException illegalArgumentException){
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers(){
        System.out.printf(Message.INPUT_WINNING_NUMBER.getMessage());
        String[] winningNumbersInput = Console.readLine().split(",");
        List<Integer> winningNumbers =  Arrays.asList(winningNumbersInput)
                .stream()
                .map((i) -> Integer.valueOf(i))
                .collect(Collectors.toList());
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자가 6개가 아닙니다.");
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }

        for(int number: numbers){
            if(number>45 || number<1){
                throw new IllegalArgumentException("[ERROR] 숫자는 1~45까지입니다.");
            }
        }
    }

    public List<Integer> getValidatedWinningNumbers(){
        while(true) {
            try {
                List<Integer> winningNumbers = getWinningNumbers();
                return winningNumbers;
            }catch (IllegalArgumentException illegalArgumentException){
                System.out.println(illegalArgumentException.getMessage());
            }
        }

    }

    private int getBonusNumber(List<Integer> winningNumbers){
        System.out.printf(Message.INPUT_BONUS_NUMBER.getMessage());
        try {
            int bonusNumber = Integer.valueOf(Console.readLine());
            validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }

    }
    
    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers){
        if(bonusNumber>45 || bonusNumber<1){
            throw new IllegalArgumentException("[ERROR] 숫자는 1~45까지입니다.");
        }

        Set<Integer> numSet = new HashSet<>(winningNumbers);
        numSet.add(bonusNumber);
        if (numSet.size() != winningNumbers.size()+1) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자입니다.");
        }
    }

    public int getValidatedBonusNUmber(List<Integer> winningNumbers){
        while(true) {
            try {
                int bonusNumber = getBonusNumber(winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }


    public void printPurchaedLotto(List<Lotto> lottos){
        System.out.printf(Message.OUTPUT_PURCHASED_LOTTO.getMessage(), lottos.size());
        for(Lotto lotto : lottos){
            List<Integer> sortedNumbers = lotto.getNumbers();
            Collections.sort(sortedNumbers);
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(HashMap<Winning, Integer> winningCount, double rate){
        System.out.printf(Message.OUTPUT_STATISTICS.getMessage());


        for(Winning winning : Winning.values()) {
            System.out.printf(winning.getPrintMessage(), winningCount.getOrDefault(winning, 0));
        }

        System.out.printf(Message.OUTPUT_RATE_OF_RETURN.getMessage(),rate);


    }
}
