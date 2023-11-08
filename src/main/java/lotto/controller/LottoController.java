package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public LottoController() {

    }
    private List<Lotto> lottoList;
    public void run() {
        try {
            play();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void play() {
        int buyingPrice = getBuyingPrice();
        int numOfLotto = howManyLotto(buyingPrice);
        for(int i = 0; i < numOfLotto; i++) {
            List<Integer> lottoNumbers = getLottoNumbers();
            lottoList.add(new Lotto(lottoNumbers));
            printLottoNumbers(lottoNumbers);
        }
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        printResult(buyingPrice, winningNumbers, bonusNumber);
    }

    private void printResult(int buyingPrice, List<Integer> winningNumbers, int bonusNumber) {
        System.out.println("당첨 통계\n---");
        printHowManyWin(winningNumbers, bonusNumber);
        printRateOfProfit(buyingPrice);
    }

    private void printRateOfProfit(int buyingPrice) {
    }

    private void printHowManyWin(List<Integer> winningNumbers, int bonusNumber) {
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if(bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        if(input.length != 6) {
            throw new IllegalArgumentException("[Error] 6개의 로또 번호를 입력해야 합니다.");
        }
        for(int i = 0; i < input.length; i++) {
            if(Integer.parseInt(input[i]) < 1 ||  Integer.parseInt(input[i]) > 45) {
                throw new IllegalArgumentException("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for(int i = 0; i < input.length; i++) {
            winningNumbers.add(Integer.parseInt(input[i]));
        }
        return winningNumbers;
    }

    private void printLottoNumbers(List<Integer> lottoNumbers) {
        String print = "[";
        for(int i = 0; i < lottoNumbers.size(); i++) {
            print += lottoNumbers.get(i) + ", ";
        }
        print = print.substring(0, lottoNumbers.size()-2) + "]";
        System.out.println(print);
    }


    private List<Integer> getLottoNumbers() {
        return  Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private int howManyLotto(int buyingPrice) {
        int numOfLotto = buyingPrice / 1000;
        System.out.println(numOfLotto + "개를 구매했습니다.");
        return numOfLotto;
    }

    private int getBuyingPrice() {
        String input = Console.readLine();
        int buyingPrice;
        try {
            buyingPrice = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error] 숫자를 입력해야 합니다.");
        }

        if(buyingPrice % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 1,000 단위의 수를 입력해야 합니다.");
        }
        if(buyingPrice < 0) {
            throw new IllegalArgumentException("[Error] 0 이상의 수를 입력해야 합니다.");
        }
         return buyingPrice;
    }
}
