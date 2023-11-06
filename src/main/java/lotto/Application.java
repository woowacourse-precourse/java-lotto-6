package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.InputParam;
import lotto.print.PrintOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static InputParam inputParam = new InputParam();
    static PrintOutput printOutput = new PrintOutput();
    public static void main(String[] args) {
        game();
    }
    public static void game(){
        printOutput.printMoneyQuestion();
        int money = inputParam.inputMoney();
        printOutput.printPurchasedLottoNumber(money);
        List<Lotto> randomLottos = makeRandomLotto(money / 1000);
        printOutput.printRandomLottosNumbers(randomLottos);
        printOutput.printLottoNumberQuestion();
        int[] inputLottoNumbers = inputParam.inputLottoNumbers();
        int bonusNumber = inputParam.inputBonusNumber();
        int[] stats = compareRandomLottosAndInputLotto(randomLottos, inputLottoNumbers, bonusNumber);
        double profit = calculateProfit(money, stats);
        printOutput.printStats(stats, profit);
    }
    public static List<Lotto> makeRandomLotto(int number){
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            randomLottos.add(new Lotto(numbers));
        }
        return randomLottos;
    }

    public static int[] compareRandomLottosAndInputLotto(List<Lotto> randomLottos, int[] inputNumbers, int bonusNumber){
        int[] results=new int[6];
        for (int i = 0; i < randomLottos.size(); i++) results[compareOneLottoAndInputLotto(randomLottos.get(i), inputNumbers, bonusNumber)]++;
        return results;
    }
    public static int compareOneLottoAndInputLotto(Lotto lotto, int[] inputNumbers, int bonusNumber){
        List<Integer> numbers = lotto.getNumbers();
        int cnt=0;
        int result=0;
        for (int inputNumber : inputNumbers) if(numbers.contains(inputNumber)) cnt++;
        if(cnt==6) result=1;
        if (cnt==5&&numbers.contains(bonusNumber)) result=2;
        if(cnt==5)result=3;
        if(cnt==4)result=4;
        if(cnt==3)result=5;
        return result;
    }
    public static double calculateProfit(int money, int[] stats){
        int totalMoney=0;
        totalMoney+=stats[1]*2000000000;
        totalMoney+=stats[2]*30000000;
        totalMoney+=stats[3]*1500000;
        totalMoney+=stats[4]*50000;
        totalMoney+=stats[5]*5000;
        double profit=((double) totalMoney/(double) money)*100;
        return profit;
    }
}
