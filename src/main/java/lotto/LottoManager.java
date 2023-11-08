package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoManager {
    int buyMoney=0;
    int buyLottoAmount=0;
    int bonusNumber=0;
    List<List<Integer>> lottoCandidateSets = new ArrayList<>();
    List<Integer> winLottoCount;
    List<Integer> winLottoMoney;
    Lotto winLotto;
    public void insertMoney() {
        int money=0;

        System.out.println("구입금액을 입력해 주세요.");
        money=Integer.parseInt(Console.readLine());
        insertMoneyErrorHandling(money);
    }

    public void insertMoneyErrorHandling(int money) {
        try {
            checkMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println();
            insertMoney();
        }
    }

    private void checkMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000단위로 입력해주세요.");
        }
        buyMoney=money;
    }

    public void buyLottoAmount(){
        buyLottoAmount=buyMoney/1000;
    }

    public void showBuyAmount(){
        System.out.println();
        System.out.println(buyLottoAmount+"개를 구매했습니다.");
    }

    public void loopCreateLottoCandidateNumbers() {
        for(int i=0; i<buyLottoAmount; i++)
            createLottoCandidateNumbers();
    }

    private void createLottoCandidateNumbers() {
        List<Integer> candidateLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoCandidateSets.add(candidateLottoNumbers);
    }

    public void showAllLottoCandidateSets(){
        for(List<Integer> candidateLottoSet: lottoCandidateSets){
            showLottoCandidateSet(candidateLottoSet);
        }
        System.out.println();
    }

    private void showLottoCandidateSet(List<Integer> candidateLottoSet){
        System.out.print("[");
        for(int i=0; i<candidateLottoSet.size(); i++){
            System.out.print(candidateLottoSet.get(i));
            if(i<candidateLottoSet.size()-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public void insertLottoNumbers(){
        String winLottoNumbers;
        List<String> tempWinLottoSet;
        List<Integer> winLottoSet=new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        tempWinLottoSet= Arrays.asList(Console.readLine().split(","));
        for(String number : tempWinLottoSet){
            winLottoSet.add(Integer.parseInt(number));
        }
        insertLottoNumbersErrorHandling(winLottoSet);
    }

    private void insertLottoNumbersErrorHandling(List<Integer> winLottoSet) {
        try {
            winLotto = new Lotto(winLottoSet);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println();
            insertLottoNumbers();
        }
    }

    public void insertBonusNumber(){
        int number=0;

        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        number=Integer.parseInt(Console.readLine());
        insertBonusNumberErrorHandling(number);
    }

    private void insertBonusNumberErrorHandling(int number){
        try {
            checkBonusNumberRange(number);
            checkBonusNumberInLottoNumbers(number);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println();
            insertBonusNumber();
        }
    }

    private void checkBonusNumberRange(int number){
        if(number<1 || number>45){
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkBonusNumberInLottoNumbers(int number){
        if(winLotto.getNumbers().stream().anyMatch(n->n==number))
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복하면 안됩니다.");
    }

    public void loopJudgeLottoCandidateSetsResult(){
        winLottoCount=Arrays.asList(0, 0, 0, 0, 0);
        winLottoMoney=Arrays.asList(0, 0, 0, 0, 0);

        for(List<Integer> lottoCandidateSet : lottoCandidateSets){
            judgeLottoCandiateSetResult(lottoCandidateSet);
        }
    }

    private void judgeLottoCandiateSetResult(List<Integer> lottoCandidateSet){

    }

    private int countCorrectNumbers(List<Integer> lottoCandidateSet){
        int count=0;
        List<Integer> winNumbers=winLotto.getNumbers();

        for(int number : lottoCandidateSet){
            for(int winNumber : winNumbers){
                if(number==winNumber){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
