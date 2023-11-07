package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            UserInput userInput = new UserInput();

            int price = userInput.inputPrice();
            int myCount = price/1000;

            MyNumGenerator myNumGenerator = new MyNumGenerator(myCount);
            List<List<Integer>> myNums = myNumGenerator.generateNums();

            PrintResult printResult = new PrintResult();
            System.out.println();
            printResult.printMyNums(myCount, myNums);
            System.out.println();

            List<Integer> answerNums = userInput.inputAnswer();
            Lotto lotto = new Lotto(answerNums);

            int bonusNum = userInput.inputBonus(answerNums);

            List<Integer> myRank = lotto.DetermineRank(myNums, bonusNum);

            printResult.printResult(myRank);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] Illegal Argument.");
        }

    }
}
