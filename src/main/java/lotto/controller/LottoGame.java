package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;
import lotto.view.ErrorMessage;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGame {
    public void gameStart(){
        User user = new User();
        int amount = purchaseAmount();
        setAmount(user, amount);
        setLoopCount(user, amount);
        setLottoTickets(user);
        printLottoTickets(user);
        setUserInputNumbers(user);
        setBonusNumber(user);
        lottoCheck(user);
        printResult(user);
        printProfit(user);
    }

    public void printResult(User user){
        System.out.println(Output.WINNING_STATISTICS);
        print(user);
    }

    public void print(User user){
        List<Integer> correctCounts = findCorrectCount(user);
        PrintCorrect[] printCorrects = PrintCorrect.values();
        for(int i = 0; i < correctCounts.size(); i++){
            System.out.println(printCorrects[i].getPrint() + correctCounts.get(i) + "개");
        }
    }

    public void setMoney(User user){
        List<Integer> correctCounts = findCorrectCount(user);
        Money[] monies = Money.values();
        int resultMoney = 0;
        for(int i = 0; i < correctCounts.size(); i++){
            resultMoney += monies[i].getMoney() * correctCounts.get(i);
        }
        user.setResultMoney(resultMoney);
    }

    public void getProfit(User user){
        Long resultMoney = user.getResultMoney();
        double profit = (resultMoney.doubleValue() / user.getMoney()) * 100;
        System.out.printf(Output.PROFIT, profit);
    }

    public void printProfit(User user){
        setMoney(user);
        getProfit(user);
    }

    public List<Integer> findCorrectCount(User user){
        List<Integer> correctCount = user.getCorrectCounts();
        List<Boolean> correctBonusCount = user.getCorrectBonusCounts();
        List<Integer> correctCounts = new ArrayList<>();
        correctCounts.add(threeCorrect(correctCount));
        correctCounts.add(fourCorrect(correctCount));
        correctCounts.add(fiveCorrect(correctCount, correctBonusCount));
        correctCounts.add(fiveCorrectAndBonusCorrect(correctCount, correctBonusCount));
        correctCounts.add(sixCorrect(correctCount));
        return correctCounts;
    }

    public int threeCorrect(List<Integer> correctCounts){
        int Correct = 0;
        for(int i = 0; i < correctCounts.size(); i++){
            if(correctCounts.get(i) == 3){
                Correct++;
            }
        }
        return Correct;
    }

    public int fourCorrect(List<Integer> correctCounts){
        int Correct = 0;
        for(int i = 0; i < correctCounts.size(); i++){
            if(correctCounts.get(i) == 4){
                Correct++;
            }
        }
        return Correct;
    }

    public int fiveCorrect(List<Integer> correctCounts, List<Boolean> correctBonusCount){
        int Correct = 0;
        for(int i = 0; i < correctCounts.size(); i++){
            if(correctCounts.get(i) == 5 && !correctBonusCount.get(i)){
                Correct++;
            }
        }
        return Correct;
    }

    public int fiveCorrectAndBonusCorrect(List<Integer> correctCounts, List<Boolean> correctBonusCount){
        int Correct = 0;
        for(int i = 0; i < correctCounts.size(); i++){
            if(correctCounts.get(i) == 5 && correctBonusCount.get(i)){
                Correct++;
            }
        }
        return Correct;
    }

    public int sixCorrect(List<Integer> correctCounts){
        int Correct = 0;
        for(int i = 0; i < correctCounts.size(); i++){
            if(correctCounts.get(i) == 6){
                Correct++;
            }
        }
        return Correct;
    }

    // 로또 번호 확인
    public void lottoCheck(User user){
        for(int i = 0; i < user.getLottoTickets().size(); i++){
            Lotto lotto = user.getLottoTickets().get(i);
            int count = lottoNumbersCheck(user.getUserInputNumbers(), lotto);
            boolean bonusNumberCheck = bonusNumberCheck(user.getBonusNumber(), lotto.getNumbers());
            user.setCorrectCounts(count);
            user.setCorrectBonusCounts(bonusNumberCheck);
        }
    }

    public boolean bonusNumberCheck(int bonusNumber, List<Integer> numbers) {
        boolean bonusCheck = false;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bonusNumber) {
                bonusCheck = true;
                break;
            }
        }
        return bonusCheck;
    }

    public int lottoNumbersCheck(List<Integer> userNumbers, Lotto lottoTicket){
        int count = 0;
        for(int i = 0; i < userNumbers.size(); i++){
            if(lottoInNumber(lottoTicket.getNumbers(), userNumbers.get(i))){
                count++;
            }
        }
        return count;
    }

    public boolean lottoInNumber(List<Integer> numbers, int number){
        boolean inNumber = false;
        for(int i = 0; i < numbers.size(); i++){
            if(number == numbers.get(i)){
                inNumber = true;
                break;
            }
        }
        return inNumber;
    }


    // 로또 번호 출력(랜덤 로또 번호)
    public void printLottoTickets(User user){
        for(int i = 0; i < user.getLoopCount(); i++){
            System.out.println(user.getLottoTickets().get(i).toString());
        }
    }

    // 로또 번호 생성 및 정렬 후 리스트 반환
    public List<Integer> randomSortNumbers(){
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(1, 45, 6));
        // 오름차순 정렬
        randomNumbers.sort(Comparator.naturalOrder());
        return randomNumbers;
    }

    // 로또 리스트 user 클래스 추가
    public void setLottoTickets(User user){
        System.out.println(user.getLoopCount() + Output.LOOP_COUNT_MESSAGE);
        for(int i = 0; i < user.getLoopCount(); i++){
            List<Integer> randomLotto = randomSortNumbers();
            Lotto lotto = new Lotto(randomLotto);
            user.setLottoTicket(lotto);
        }
    }

    // 들어온 돈이 1000원 단위인지 확인
    public boolean loopCountCheck(int amount){
        if(amount % 1000 != 0){
            return false;
        }
        return true;
    }

    // 로또 횟수 저장
    public void setLoopCount(User user, int amount){
        if(loopCountCheck(amount)){
            user.calculationLoopCount();
        }
    }

    // 돈 입력 받기
    public int purchaseAmount(){
        System.out.println(Input.PURCHASE_AMOUNT_MESSAGE);
        int amount = 0;
        while (amount == 0){
            try {
                amount = amountInput();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }

    // 가격 설정
    public void setAmount(User user, int amount){
        user.setMoney(amount);
    }

    // 입력한 값을 숫자로 변경
    public int amountInput(){
        String beforeAmount = Console.readLine();
        if(!isNumber(beforeAmount)){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
        int afterAmount = Integer.parseInt(beforeAmount);
        return afterAmount;
    }

    // 들어온 값이 숫자 인지 확인
    public boolean isNumber(String number){
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    // 로또 번호 저장
    public void setUserInputNumbers(User user){
        List<Integer> userInputNumbers = null;
        while(userInputNumbers == null){
            String numbers = inputNumbers();
            String[] splitNumbers = userNumbers(numbers);
            try {
                userInputNumbers = userInputNumbers(splitNumbers);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        user.setUserInputNumbers(userInputNumbers);
    }

    // 로또 번호 입력
    public String inputNumbers(){
        System.out.println(Input.INPUT_NUMBERS_MESSAGE);
        String numbers = Console.readLine();
        return numbers;
    }

    // 로또 번호 배열로 변경
    public String[] userNumbers(String numbers){
        String[] userNumbers = numbers.split(",");
        return userNumbers;
    }

    // 배열을 리스트 로 변경
    public List<Integer> userInputNumbers(String[] userNumbers){
        List<Integer> userInputNumbers = new ArrayList<>();
        for(int i = 0; i < userNumbers.length; i++){
            if(!isNumber(userNumbers[i])){
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
            }
            int number = Integer.parseInt(userNumbers[i]);
            if(number > 45 || number < 1){
                throw new IllegalArgumentException("[ERROR] 숫자가 이상합니다.");
            }
            userInputNumbers.add(Integer.parseInt(userNumbers[i]));
        }
        return userInputNumbers;
    }

    // 보너스 번호 입력 받기
    public String inputBonus(){
        System.out.println(Input.INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    // 보너스 번호 숫자로 변환
    public int inputBonusNumber(String bonusNumber){
        if(!isNumber(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
        int inputBonusNumber = Integer.parseInt(bonusNumber);
        return inputBonusNumber;
    }

    public void setBonusNumber(User user){
        int bonusNumber = 0;
        while(bonusNumber == 0){
            String inputBonusNumber = inputBonus();
            try {
                bonusNumber = inputBonusNumber(inputBonusNumber);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        user.setBonusNumber(bonusNumber);
    }
}
