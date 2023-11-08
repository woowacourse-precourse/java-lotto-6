package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Consumer;
import lotto.domain.Lotto;
import lotto.domain.PrizeLotto;
import lotto.exception.DuplicatedNumber;
import lotto.exception.NotRangeException;
import lotto.utils.RandomUtils;
import lotto.view.LottoPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    final int amount = 1000;
    final int size = 6;
    final int start = 1;
    final int end = 45;
    RandomUtils randomUtils = new RandomUtils();
    LottoPrint lottoPrint = new LottoPrint();
    Consumer consumer;
    PrizeLotto prizeLotto = new PrizeLotto();
    Map<Integer, Integer> winning = new HashMap<>();
    double winningRate = 0;

    /**
     * 로또 구입하기
     */
    public void purchaseLotto(){
        int money = inputMoney();
        int quantity = money / amount;

        ArrayList<Lotto> lotto = new ArrayList<>();
        for(int i = 0; i < quantity; i++){
            lotto.add(purchaseOneLotto());
        }
        consumer = new Consumer(lotto);
        lottoPrint.purchaseLottoPrint(quantity, consumer.getPurchasedLotto());
    }

    // 로또 한 개 구입하기
    private Lotto purchaseOneLotto(){
        List<Integer> numbers = randomUtils.randomNumber(size, start, end);
        return new Lotto(numbers);
    }

    // 구입 금액 입력
    public int inputMoney() {
        String input = Console.readLine();
        int money = 0;
        try{
            money = Integer.parseInt(input);
            try{
                if(money % 1000 != 0) throw new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 천원 단위로 입력해주세요.");
                money = inputMoney();
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            money = inputMoney();
        }
        return money;
    }

    /**
     * 당첨 번호 추출
     */
    // 주요 6개 번호 추출
    public void inputPrimaryNumber() {
        String[] input = Console.readLine().split(",");
        List<Integer> primaryNumber = new ArrayList<>();
        try{
            for(String s : input){
                int num = Integer.parseInt(s);
                if(num < 1 || num > 45) throw new NotRangeException();
                primaryNumber.add(num);
            }
            if(primaryNumber.size() != 6){
                System.out.println("[ERROR] 6개의 숫자를 입력해주세요.");
                inputPrimaryNumber();
            }
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            inputPrimaryNumber();
        }catch (NotRangeException e){
            System.out.println("[ERROR] 범위 내의 숫자를 입력해주세요.");
            inputPrimaryNumber();
        }
        prizeLotto.setPrimaryNumbers(new Lotto(primaryNumber));
    }

    // 보너스 번호 추출
    public void inputBonusNumber() {
        String input = Console.readLine();
        int bonusNum = -1;
        try {
            bonusNum = Integer.parseInt(input);
            if (bonusNum < 1 || bonusNum > 45) throw new NotRangeException();
            if(prizeLotto.getPrimaryNumbers().getNumbers().contains(bonusNum)) throw new DuplicatedNumber();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            inputBonusNumber();
        } catch (NotRangeException e) {
            System.out.println("[ERROR] 범위 내의 숫자를 입력해주세요.");
            inputBonusNumber();
        } catch (DuplicatedNumber e){
            System.out.println("[ERROR] 주요 당첨 번호에 없는 숫자를 입력해주세요.");
            inputBonusNumber();
        }
        prizeLotto.setBonusNumber(bonusNum);
    }


}
