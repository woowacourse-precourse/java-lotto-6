package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final static int FIFTH_PLACE = 3;
    private final static int FORTH_PLACE = 4;
    private final static int THIRD_PLACE = 5;
    private final static int SECOND_PLACE = 7;
    private final static int FIRST_PLACE = 6;

    private int lottoQuantity;
    private List<Lotto> lottos;
    private List<Integer> winNumber;
    private int bonusNumber;

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
        winnerQuantity = new HashMap<>();
        initWinnerQuantity();
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

    private void createLottos() throws IllegalArgumentException {
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
    public List<Lotto> getLottos() throws IllegalArgumentException {
        createLottos();
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
    public void setBonusNumber(int input) throws IllegalArgumentException{
        validateBonusNumber(input);
        this.bonusNumber = input;
    }
    private void validateBonusNumber(int input) throws IllegalArgumentException{
        if(this.winNumber.contains(input))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없어요.");
    }

    private Map<Integer, Integer> winnerQuantity;

    private void initWinnerQuantity(){
        this.winnerQuantity.put(FIRST_PLACE, 0);
        this.winnerQuantity.put(SECOND_PLACE, 0);
        this.winnerQuantity.put(THIRD_PLACE, 0);
        this.winnerQuantity.put(FORTH_PLACE, 0);
        this.winnerQuantity.put(FIFTH_PLACE, 0);
    }
    private void countWithWinNumber(Lotto lotto){
        int winNumberCount = 0;
        List<Integer> currentLotto = lotto.getNumbers();
        for(int number : this.winNumber){
            if(currentLotto.contains(number))
                winNumberCount++;
        }
        this.winnerQuantity.put(winNumberCount,
                winnerQuantity.getOrDefault(winNumberCount,0)+1);
    }
    private void countWithBonusNumber(Lotto lotto){
        int winNumberCount = 0;
        boolean bonusFlag = false;
        List<Integer> currentLotto = lotto.getNumbers();
        for(int number : this.winNumber){
            if(currentLotto.contains(number))
                winNumberCount++;
        }
        if(currentLotto.contains(this.bonusNumber))
            bonusFlag = true;
        if(bonusFlag && winNumberCount == 5) {
            this.winnerQuantity.put(SECOND_PLACE,
                    winnerQuantity.getOrDefault(winNumberCount, 0) + 1);
        }
    }
    public void findWinnersWithWinNumber(){
        for(Lotto lotto : this.lottos){
            countWithWinNumber(lotto);
        }
    }
    public void findWinnersWithBonusNumber(){
        for(Lotto lotto : this.lottos){
            countWithBonusNumber(lotto);
        }
    }
    public String getLottoResult(){
        findWinnersWithWinNumber();
        findWinnersWithBonusNumber();
        StringBuilder printer = new StringBuilder();
        printer.append("3개 일치 (5,000원) - ")
                .append(winnerQuantity.get(FIFTH_PLACE))
                .append("개\n")
                .append("4개 일치 (50,000원) - ")
                .append(winnerQuantity.get(FORTH_PLACE))
                .append("개\n")
                .append("5개 일치 (1,500,000원) - ")
                .append(winnerQuantity.get(THIRD_PLACE))
                .append("개\n")
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
                .append(winnerQuantity.get(SECOND_PLACE))
                .append("개\n")
                .append("6개 일치 (2,000,000,000원) - ")
                .append(winnerQuantity.get(FIRST_PLACE))
                .append("개");
        return printer.toString();
    }
    public String getWinLottoResult(){
        findWinnersWithWinNumber();
        findWinnersWithBonusNumber();
        StringBuilder printer = new StringBuilder();
        printer.append("3개 일치 (5,000원) - ")
                .append(winnerQuantity.get(FIFTH_PLACE))
                .append("개\n")
                .append("4개 일치 (50,000원) - ")
                .append(winnerQuantity.get(FORTH_PLACE))
                .append("개\n")
                .append("5개 일치 (1,500,000원) - ")
                .append(winnerQuantity.get(THIRD_PLACE))
                .append("개\n")
                .append("6개 일치 (2,000,000,000원) - ")
                .append(winnerQuantity.get(FIRST_PLACE))
                .append("개");
        return printer.toString();
    }
    public String getBonusLottoResult(){
        findWinnersWithWinNumber();
        findWinnersWithBonusNumber();
        StringBuilder printer = new StringBuilder();
        printer.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
                .append(winnerQuantity.get(SECOND_PLACE))
                .append("개");
        return printer.toString();
    }
}

