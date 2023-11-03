package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import utility.Statistic;

import java.math.BigInteger;
import java.util.*;

public class LottoGame {

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
        this.winnerQuantity.put(Statistic.FIRST.getSameNumberCount(), 0);
        this.winnerQuantity.put(Statistic.SECOND.getSameNumberCount(), 0);
        this.winnerQuantity.put(Statistic.THIRD.getSameNumberCount(), 0);
        this.winnerQuantity.put(Statistic.FORTH.getSameNumberCount(), 0);
        this.winnerQuantity.put(Statistic.FIFTH.getSameNumberCount(), 0);
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
            this.winnerQuantity.put(Statistic.SECOND.getSameNumberCount(),
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
                .append(winnerQuantity.get(Statistic.FIFTH.getSameNumberCount()))
                .append("개\n")
                .append("4개 일치 (50,000원) - ")
                .append(winnerQuantity.get(Statistic.FORTH.getSameNumberCount()))
                .append("개\n")
                .append("5개 일치 (1,500,000원) - ")
                .append(winnerQuantity.get(Statistic.THIRD.getSameNumberCount()))
                .append("개\n")
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
                .append(winnerQuantity.get(Statistic.SECOND.getSameNumberCount()))
                .append("개\n")
                .append("6개 일치 (2,000,000,000원) - ")
                .append(winnerQuantity.get(Statistic.FIRST.getSameNumberCount()))
                .append("개");
        return printer.toString();
    }
//    //only for test
//    public String getWinLottoResult(){
//        findWinnersWithWinNumber();
//        findWinnersWithBonusNumber();
//        StringBuilder printer = new StringBuilder();
//        printer.append("3개 일치 (5,000원) - ")
//                .append(winnerQuantity.get(FIFTH_PLACE))
//                .append("개\n")
//                .append("4개 일치 (50,000원) - ")
//                .append(winnerQuantity.get(FORTH_PLACE))
//                .append("개\n")
//                .append("5개 일치 (1,500,000원) - ")
//                .append(winnerQuantity.get(THIRD_PLACE))
//                .append("개\n")
//                .append("6개 일치 (2,000,000,000원) - ")
//                .append(winnerQuantity.get(FIRST_PLACE))
//                .append("개");
//        return printer.toString();
//    }
//    //only for test
//    public String getBonusLottoResult(){
//        findWinnersWithWinNumber();
//        findWinnersWithBonusNumber();
//        StringBuilder printer = new StringBuilder();
//        printer.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
//                .append(winnerQuantity.get(SECOND_PLACE))
//                .append("개");
//        return printer.toString();
//    }
    //todo: big Integer 계산 안나옴 void sum_all_lotto_prizes(){ 해결하기
    private BigInteger calculateSumEach(int sameNumberCount, String quantity){
        ArrayList<String> prizes = Statistic.getPrizeList();
        ArrayList<Integer> counts = Statistic.getSameNumberCountList();

        BigInteger amount = new BigInteger("0");
        BigInteger prize;

        for(int index = 0; index < prizes.size(); index++){
            if(sameNumberCount == counts.get(index)){
                amount = new BigInteger(quantity);
                //System.out.println("current amount is "+amount);
                prize = new BigInteger(prizes.get(index));
                //System.out.println("current prize is "+ prize);
                amount = amount.multiply(prize);
            }
        }
        //System.out.println("return amount is "+amount);
        return amount;
    }

    public BigInteger sumAllPrize(){
        BigInteger result = new BigInteger("0");
        Set<Map.Entry<Integer, Integer>> wonLottos = this.winnerQuantity.entrySet();

        for(Map.Entry<Integer, Integer> lotto : wonLottos){
            if(lotto.getValue() != 0){
                int sameNumberCount = lotto.getKey();
                String quantity = String.valueOf(lotto.getValue());
                result = result.add(calculateSumEach(sameNumberCount, quantity));
            }
        }
        return result;
    }

}

