package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static int numberOfLotto;
    static int money = 0;

    enum Statistic {
        correct3(3, 5000),
        correct4(4, 50000),
        correct5(5, 150000),
        correct5Andbonus(5, 30000000),
        correct6(6, 2000000000);

        int correctNums;
        long prize;

        Statistic(int correctNums, long prize) {
            this.correctNums = correctNums;
            this.prize = prize;
        }

        public int getCorrectNums() {
            return correctNums;
        }

        public long getPrize() {
            return prize;
        }

    }

    public static void main(String[] args) {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = new ArrayList<>();
        List<Integer> bonusNumber = new ArrayList<>();
        List<Integer> winningBonusNumber = new ArrayList<>();
        buyOutput();
        myLottoOutput(lottos);
        winningLottoOutput(winningNumbers, bonusNumber);
        statisticsOutput(lottos, winningNumbers, bonusNumber,winningBonusNumber);
    }

    public static void buyOutput() {
        System.out.println("구입 금액을 입력해 주세요.");
        money = moneyInput(money);
        System.out.println();
        numberOfLotto = money / 1000;
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public static void myLottoOutput(List<Lotto> lottos) {
        for (int i = 0; i < numberOfLotto; i++) {
            makeLotto(lottos);
            printLotto(lottos.get(i).getNumbers());
            System.out.println();
        }
    }

    public static void winningLottoOutput(List<Integer> winningNumbers, List<Integer> bonusNumber) {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbersInput(winningNumbers);
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumberInput(bonusNumber);
        System.out.println();
    }

    public static void statisticsOutput(List<Lotto> lottos, List<Integer> winningNumbers, List<Integer> bonusNumber, List<Integer> winningBonusNumber) {
        List<Integer> lottohaveWinningNumList = new ArrayList<>();
        List<Integer> lottohaveWinningBonusNumList = new ArrayList<>();
        int prize;

        System.out.println("당첨 통계");
        System.out.println("---");
        for (Lotto lotto : lottos) {
            lottohaveWinningNumList.add(findCorrectNums(lotto, winningNumbers));
            lottohaveWinningBonusNumList.add(findCorrectBonusNum(lotto, bonusNumber, winningBonusNumber));
        }
        List<Integer> staticList = makeStaticList(lottohaveWinningNumList, lottohaveWinningBonusNumList);
        prize = totalPrize(staticList);
        totalPrint(staticList,prize);

    }

    public static void totalPrint(List<Integer> staticList,int prize) {
        System.out.println("3개 일치 (5,000원) - " + staticList.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + staticList.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + staticList.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + staticList.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + staticList.get(4) + "개");
        double rate = (double)prize / money * 100;
        rate = Math.round(rate * 100.0) / 100.0;
        System.out.println("총 수익률은 " + rate + "%입니다.");
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
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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
            int num = compareWinning(numbers,winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호 6개를 입력하여야 합니다.");
        }
    }

    public static int compareWinning(String[] numbers,List<Integer> winningNumbers) {
        int num = 0;
        for (String number : numbers) {
            num = Integer.parseInt(number.trim());
            winningNumbers.add(num);
            if (!(1 <= num && num <= 45))
                throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력하여야 합니다.");
        }
        return num;
    }

    public static void bonusNumberInput(List<Integer> bonusNumber) {
        String userInput = Console.readLine();
        if (userInput.length() != 1)
            throw new IllegalArgumentException("[Error] 보너스 번호 1개를 입력하여야 합니다.");
        try {
            int num = compareBonus(userInput);
            bonusNumber.add(num);
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


    public static int findCorrectNums(Lotto lotto, List<Integer> winningNumbers) {
        int winningLottoNums = 0;
        for (int element : winningNumbers) {
            winningLottoNums = winningLottoNums + onewinnningNum(lotto, element);
        }
        return winningLottoNums;
    }

    public static int onewinnningNum(Lotto lotto, int winningNum) {
        for (int element : lotto.getNumbers())
            if (element == winningNum)
                return 1;
        return 0;
    }

    public static int findCorrectBonusNum(Lotto lotto, List<Integer> bonusNumber, List<Integer> winningBonusNumber) {
        int winningLottoNum = bonusNumber.get(0);
        for (int element : lotto.getNumbers())
            if (element == winningLottoNum)
                return 1;
        return 0;
    }

    public static List<Integer> makeStaticList(List<Integer> lottohaveWinningNumList,
                                               List<Integer> lottohaveWinningBonusNumList) {
        List<Integer> staticList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++)
            staticList.add(0);
        for (int i = 0; i < numberOfLotto; i++) {
            int number = lottohaveWinningNumList.get(i) + lottohaveWinningBonusNumList.get(i);
            if (number == 3) staticList.set(0, staticList.get(0) + 1);
            else if (number == 4) staticList.set(1, staticList.get(1) + 1);
            else if (number == 5) {
                if (lottohaveWinningBonusNumList.get(i) == 1)
                    staticList.set(2, staticList.get(2) + 1);
                else if (lottohaveWinningBonusNumList.get(i) == 0)
                    staticList.set(3, staticList.get(3) + 1);
            } else if (number == 6) staticList.set(4, staticList.get(4) + 1);
        }
        return staticList;
    }



    public static int totalPrize (List<Integer> staticList){
        int prize=0;
        for(int i =0 ; i<staticList.size();i++) {
            if(i==0)
                prize = prize + staticList.get(i) * 5000;
            else if(i==1)
                prize = prize + staticList.get(i) * 50000;
            else if(i==2)
                prize = prize + staticList.get(i) * 1500000;
            else if(i==3)
                prize = prize + staticList.get(i) * 30000000;
            else if(i==4)
                prize = prize + staticList.get(i)* 2000000000;
        }
        return prize;
    }

}