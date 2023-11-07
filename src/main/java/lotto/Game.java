package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Prize;
import lotto.input.InputParam;
import lotto.print.PrintOutput;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static InputParam inputParam = new InputParam();
    static PrintOutput printOutput = new PrintOutput();

    //(12줄) 전체 로직 실행 함수()
    public void game(){
        printOutput.printMoneyQuestion();
        int money = inputParam.inputMoney();
        printOutput.printPurchasedLottoNumber(money);
        List<Lotto> randomLottos = makeRandomLotto(money / 1000);
        printOutput.printRandomLottosNumbers(randomLottos);
        printOutput.printLottoNumberQuestion();
        int[] inputLottoNumbers = inputParam.inputLottoNumbers();
        printOutput.printBonusNumberQuestion();
        int bonusNumber = inputParam.inputBonusNumber();
        int[] stats = compareRandomLottosAndInputLotto(randomLottos, inputLottoNumbers, bonusNumber);
        double profit = calculateProfit(money, stats);
        printOutput.printStats(stats, profit);
    }

    //(6줄) 랜덤로또번호 생성함수(개수) -> 랜덤 로또 리스트
    public List<Lotto> makeRandomLotto(int number){
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            randomLottos.add(new Lotto(numbers));
        }
        return randomLottos;
    }

    //(5줄) 구매한 로또들과 입력로또 비교 함수(랜덤로또들, 입력번호, 보너스번호) -> 등수 배열
    public int[] compareRandomLottosAndInputLotto(List<Lotto> randomLottos, int[] inputNumbers, int bonusNumber){
        int[] results=new int[6];
        for (int i = 0; i < randomLottos.size(); i++) {
            results[compareOneLottoAndInputLotto(randomLottos.get(i), inputNumbers, bonusNumber)]++;
        }
        return results;
    }
    //(10줄) 한 개의 랜덤로또와 입력값을 비교하는 함수(랜덤로또, 입력번호, 보너스번호) -> 등수
    public int compareOneLottoAndInputLotto(Lotto lotto, int[] inputNumbers, int bonusNumber){
        List<Integer> numbers = lotto.getNumbers();
        int cnt=0;
        int result=0;
        for (int inputNumber : inputNumbers) if(numbers.contains(inputNumber)) cnt++;
        if(cnt==6) result=1;
        if(cnt==5)result=3;
        if (cnt==5&&numbers.contains(bonusNumber)) result=2;
        if(cnt==4)result=4;
        if(cnt==3)result=5;
        return result;
    }
    //(8줄) 수익률 계산함수(돈, 당첨수) -> 수익률
    public double calculateProfit(int money, int[] stats){
        int totalMoney=0;
        totalMoney+=stats[1]* Prize.MONEYOFFIRST.getMoney();
        totalMoney+=stats[2]*Prize.MONEYOFSECOND.getMoney();
        totalMoney+=stats[3]* Prize.MONEYOFTHIRD.getMoney();
        totalMoney+=stats[4]*Prize.MONEYOFFOURTH.getMoney();
        totalMoney+=stats[5]*Prize.MONEYOFFIFTH.getMoney();
        double profit=((double) totalMoney/(double) money)*100;
        return profit;
    }
}
