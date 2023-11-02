package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int lottoQuantity;
    private List<Lotto> lottos;
    private List<Integer> winNumber;

    public LottoGame(String amount) throws IllegalArgumentException{
        char[] money = amount.toCharArray();
        for(char c : money)
        {
            validateDigit(c);
        }
        int inputMoney = Integer.parseInt(amount);
        validateRemainder(inputMoney);
        inputMoney = Math.floorDiv(inputMoney,1000);
        this.lottoQuantity = inputMoney;
        lottos = new ArrayList<>();
        winNumber = new ArrayList<>();
    }

    public void printLottoQuantity() {
        System.out.println(this.lottoQuantity+"개를 구매했습니다.");
    }

    private void validateDigit(char c){
        if(!Character.isDigit(c)){
            throw new IllegalArgumentException("[ERROR] 숫자로만 입력해 주세요.");
        }
    }
    private void validateRemainder(int money) throws IllegalArgumentException{
        if((money%1000) != 0){
            throw new IllegalArgumentException("[ERROR] 금액이 1000원으로 나누어 떨어지지 않아요.");
        }
    }

    public void createLottos() throws IllegalArgumentException {
        List<Integer> numbers;
        validateLottoQuantity();
        while(true){
            if(this.lottoQuantity == 0)
                break;
            numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            lottos.add(new Lotto(numbers));
            this.lottoQuantity--;
        }
    }
    public List<Lotto> getLottos() {
        final List<Lotto> printingLottos = new ArrayList<>();
        for(Lotto lotto : this.lottos){
            printingLottos.add(lotto);
        }
        return printingLottos;
    }
    private void validateLottoQuantity() throws IllegalArgumentException{
        if(this.lottoQuantity == 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액이 0이면 로또번호를 생성할 수 없습니다.");
    }
    public void setWinNumber(List<Integer> input){
        this.winNumber = input;
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }
}

