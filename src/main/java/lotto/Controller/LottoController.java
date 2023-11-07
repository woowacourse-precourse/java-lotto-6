package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.View.ExceptionView;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.*;

public class LottoController {
    private List<Integer> numbers;
    private List<List<Integer>> lottos;

    private int[] prizes = new int[5];

    private int bonusMatchCount;

    private int matchedNumbers;

    public LottoController(){
        numbers = new ArrayList<>();
        lottos = new ArrayList<>();
    }
    //갯수만큼 돌려라~

    public void start(){
        String amount = InputView.inputPlayerAmount();
        while (true) {
            if (isNumeric(amount)) {
                break; // 숫자로 변환 가능하면 입력 반복 종료
            } else {
                ExceptionView.typeException();
                System.out.println("다시 입력해 주세요.");
                amount = InputView.inputPlayerAmount();
            }
        }


        OutputView.prinfln();

        OutputView.printTicketCount(Integer.parseInt(amount) / 1000);

        RandomNumbers(Integer.parseInt(amount) / 1000);

        OutputView.prinfln();
        List<Integer> prize = InputView.inputLottoWinningNum(); // 여기서 당첨번호 저장해야함

        Lotto lotto = new Lotto(prize);

        OutputView.prinfln();
        String bonus = InputView.inputBonusNumber();

        lotto.setBonus(Integer.parseInt(bonus));

        CheckWinning(lotto.getNumbers());
        CheckBonus(lotto.getBonus());


        OutputView.prinfln();
        OutputView.printSuccessResult();

        printResult();
        rate(Integer.parseInt(amount));
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
    public void RandomNumbers(int roof){
        for(int i = 0; i < roof; i++) {
            List<Integer> numbers = new ArrayList<>(); // 변경 가능한 리스트로 초기화
            numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            System.out.println(numbers);
            lottos.add(numbers);
        }
    }


    public void CheckWinning(List<Integer> prize) {
        for (List<Integer> lottoNumbers : lottos) {
            int matchedNumbers = countMatchingNumbers(lottoNumbers, prize);
            checkPrize(matchedNumbers);
        }
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> prizeNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (prizeNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void checkPrize(int matchedNumbers) {
        if (matchedNumbers == 3) {
            prizes[0]++;
        } else if (matchedNumbers == 4) {
            prizes[1]++;
        } else if (matchedNumbers == 5) {
            prizes[2]++;
        } else if (matchedNumbers == 5 && bonusMatchCount == 1) {
            prizes[3]++;
        } else if (matchedNumbers == 6) {
            prizes[4]++;
        }
    }


    public void printResult(){
        for(int i = 0; i < 5; i++){
            if(i == 0){
                OutputView.printFifthMessage(prizes[0]);
            }else if(i == 1){
                OutputView.printFourthMessage(prizes[1]);
            }else if(i == 2){
                OutputView.printThirdMessage(prizes[2]);
            }else if(i == 3){
                OutputView.printSecondMessage(prizes[3]);
            }else if(i == 4){
                OutputView.printFirstMessage(prizes[4]);
            }
        }
    }

    public void rate(int amount) {
        int totalPrize = 0;
        for (int i = 0; i < 5; i++) {
            totalPrize += prizes[i] * getPrizeAmount(i);
        }
        double rate = ((double) totalPrize / amount) * 100;
        OutputView.printRevenueRate(rate);
    }

    public void CheckBonus(int bonus) {
        for (List<Integer> lottoNumbers : lottos) {
            int bonusMatchCount = countMatchingBouns(lottoNumbers, bonus);
            checkBonusPrize(bonusMatchCount);
        }
    }

    public void checkBonusPrize(int bonusMatchCount) {
        if (matchedNumbers == 5 && bonusMatchCount == 1) {
            prizes[3]++;
        }
    }

    public int countMatchingBouns(List<Integer> lottoNumbers, int bouns){
        int count = 0;
        for(int number : lottoNumbers){
            if (bouns == number) {
                count++;
            }
        }
        return count;
    }

    public int getPrizeAmount(int index) {
        int[] prizeAmounts = {5000, 50000, 1500000, 30000000, 2000000000};
        return prizeAmounts[index];
    }
}
