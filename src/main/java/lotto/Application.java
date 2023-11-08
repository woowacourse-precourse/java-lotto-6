package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    static int numberOfLotto;
    static int money = 0;
    static enum statistic {
        correct3,
        correct4,
        correct5,
        correct6,

    }
    public static void main(String[] args) {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = new ArrayList<>();
        buyOutput();
        myLottoOutput(lottos);
        winningLottoOutput(winningNumbers);
        statisticsOutput(lottos,winningNumbers);
    }

    public static void buyOutput() {
        System.out.println("구입 금액을 입력해 주세요.");
        money = moneyInput(money);
        System.out.println();
        numberOfLotto = money / 1000;
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public static void myLottoOutput(List<Lotto> lottos) {
        for (int i = 0; i < money; i++) {
            makeLotto(lottos);
            printLotto(lottos.get(i).getNumbers());
            System.out.println();
        }
    }

    public static void winningLottoOutput(List<Integer> winningNumbers){
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbersInput(winningNumbers);
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumberInput(winningNumbers);
        System.out.println("당첨 번호를 입력해 주세요.");
        System.out.println();
    }

    public static void statisticsOutput(List<Lotto> lottos, List<Integer> winningNumbers) {
        List<Integer> lottohaveWinningNumList = new ArrayList<>();

        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i=0;i<lottos.size();i++)
            lottohaveWinningNumList.add(findCorrectNums(lottos.get(i),winningNumbers));

    }

    public static int moneyInput(int money) {
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000원 단위로 입력하여야 합니다.");
        }
        if ((money % 1000) != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하여야 합니다. ");
        return money;
    }

    public static void makeLotto(List<Lotto> lottos) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        Lotto firstLottoList = new Lotto(numbers);
        lottos.add(firstLottoList);
    }

    public static void printLotto(List<Integer> lotto) {
        System.out.print(lotto);
    }

    public static void winningNumbersInput(List<Integer> winningNumbers) {
        String userInput = Console.readLine();
        String[] numbers = userInput.split(",");
        if (numbers.length != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력하여야 합니다.");
        try {
            int num = compareWinning(numbers);
            winningNumbers.add(num);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호 6개를 입력하여야 합니다.");
        }
    }

    public static int compareWinning(String[] numbers) {
        int num = 0;
        for (String number : numbers) {
            num = Integer.parseInt(number.trim());
            if (!(1 <= num && num <= 45))
                throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력하여야 합니다.");
        }
        return num;
    }

    public static void bonusNumberInput(List<Integer> winningNumbers) {
        String userInput = Console.readLine();
        if (userInput.length() != 1)
            throw new IllegalArgumentException("[Error] 보너스 번호 1개를 입력하여야 합니다.");
        try {
            int num = compareBonus(userInput);
            winningNumbers.add(num);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 보너스 번호 1개를 입력하여야 합니다.");
        }
    }


    public static int compareBonus(String number) {
        int num = Integer.parseInt(number.trim());
        if (!(1 <= num && num <= 45))
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력하여야 합니다.");
        return num;
    }


    public static int findCorrectNums(Lotto lotto, List<Integer> winningNumbers){
        int winningLottoNums = 0;
        for(int element : winningNumbers){
            winningLottoNums = winningLottoNums + onewinnningNum(lotto,element);
        }
        return winningLottoNums;
    }

    public static int onewinnningNum(Lotto lotto, int winningNum){
        for(int element : lotto.getNumbers())
            if(element == winningNum)
                return 1;
        return 0;
    }

    public static

}