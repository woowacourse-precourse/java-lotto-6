package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cunsumer;
import lotto.domain.Lotto;
import lotto.domain.PrizeLotto;
import lotto.exception.NotRangeException;
import lotto.utils.RandomUtils;
import lotto.view.LottoPrint;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    final int amount = 1000;
    final int size = 6;
    final int start = 1;
    final int end = 45;
    RandomUtils randomUtils = new RandomUtils();
    LottoPrint lottoPrint = new LottoPrint();
    Cunsumer consumer;
    PrizeLotto prizeLotto;
    List<Integer> primaryNumber;


    public void purchaseLotto(){
        int money = inputMoney();
        int quantity = money / amount;

        ArrayList<Lotto> lotto = new ArrayList<>();
        for(int i = 0; i < quantity; i++){
            lotto.add(purchaseOneLotto());
        }
        consumer = new Cunsumer(lotto);
        lottoPrint.purchaseLottoPrint(quantity, consumer.getPurchasedLotto());
    }

    private Lotto purchaseOneLotto(){
        List<Integer> numbers = randomUtils.randomNumber(size, start, end);
        return new Lotto(numbers);
    }
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

    public void inputPrimaryNumber() {
        String[] input = Console.readLine().split(",");
        primaryNumber = new ArrayList<>();
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
    }

    public void inputBonusNumber() {
        String input = Console.readLine();
        try{
            int num = Integer.parseInt(input);

            if(num < 1 || num > 45) throw new NotRangeException();
            primaryNumber.add(num);
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            inputBonusNumber();
        }catch (NotRangeException e){
            System.out.println("[ERROR] 범위 내의 숫자를 입력해주세요.");
            inputBonusNumber();
        }
        prizeLotto = new PrizeLotto(primaryNumber);
    }

}
