package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputView {
    public InputView(){

    }
    public Money inputMoneyInfo(){
        printInputMessage();
        Money money = new Money(inputMoney());
        printPlayCountMessage(money);
        return money;
    }
    public Lottos LottoListInfo(Money money){
        Lottos lottos = new Lottos(money);
        lottos.addLottoList();
        return lottos;
    }


    public Lotto answerLottoInfo(){
        printInputAnswerLotto();
        Lotto lotto = new Lotto(inputLotto());
        return lotto;
    }
    public BonusNumber bonusNumberInfo(List<Integer> answerLotto) throws IllegalArgumentException{
        printInputBonusNumber();
        String input = Console.readLine();
        BonusNumber bonusNumber = new BonusNumber(answerLotto,Integer.parseInt(input));
        return bonusNumber;
    }

    private int inputMoney() throws IllegalArgumentException {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private void printInputMessage(){
        System.out.println("구입 금액을 입력해 주세요.");
    }
    private void printPlayCountMessage(Money money){
        System.out.println(money.getPlayCount()+"개를 구매했습니다.");
    }

    private void printInputAnswerLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    private void printInputBonusNumber(){
        System.out.println("보너스 번호를 입력해주세요.");
    }



    private List<Integer> inputLotto() throws IllegalArgumentException {
        String answerLotto = Console.readLine();
        String[] answerArr = answerLotto.split(",");
        return listToArray(answerArr);
    }

    private List<Integer> listToArray(String[] answerArr){
        List<Integer> tempList = new ArrayList<>();
        int[] intArr = Stream.of(answerArr).mapToInt(Integer::parseInt).toArray();
        for (int temp : intArr){
            tempList.add(temp);
        }
        return tempList;
    }

}
