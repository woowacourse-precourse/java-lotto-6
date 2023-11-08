package lotto.controller;

import lotto.domain.Calculator;
import lotto.domain.Customer;
import lotto.domain.Lucky;
import lotto.domain.ResultRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoManager {
    private Customer customer;
    private Lucky lucky;
    private InputView inputView=new InputView();
    private OutputView outputView=new OutputView();
    private ResultRepository resultRepository=new ResultRepository();

    public void buyLotto(){

        try {
            int money=inputView.inputMoney();
            customer = new Customer(money);
            customer.pay();
            outputView.printCount(customer.getLottos().size());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLotto();
        }

        showLottoList();
        playLotto();

    }

    private void showLottoList(){
        customer.getLottos().stream()
                .forEach(lotto->outputView.printLotto(lotto));
    }

    private void playLotto(){
        checkLucky();
        saveResult();
        showStatistics();
        solveRateOfReturn();
    }
    private void checkLucky(){

        while(true){
            try{
                List<Integer> luckyNumber=getLuckyNumber();
                int bonus=getBonus();
                validateSize(luckyNumber);
                validateBonus(luckyNumber,bonus);
                lucky=new Lucky(luckyNumber,bonus);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());

            }
        }
    }

    private void saveResult(){
        resultRepository.init();
        customer.getLottos().stream()
                .forEach(lotto->resultRepository.save(lucky.checkWinning(lotto)));
    }

    private int getBonus(){
        while(true){
            try{
                int bonus=inputView.inputBonus();
                validateRange(bonus);
                return bonus;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonus(List<Integer> numbers,int bonus){
        if(numbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    private void validateRange(int n){
        if(n<1 || n>45){
            throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력하세요.");
        }
    }
    private List<Integer> getLuckyNumber(){
        while(true){
            try{
                String lucky= inputView.inputLucky();
                List<Integer> luckyNumber=translateLucky(lucky);
                validateDuplication(luckyNumber);
                return luckyNumber;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> translateLucky(String target){
        return translateToInt(separateNames(target));
    }
    private List<String> separateNames(String names) {
        String[] luckyNumber = names.split(",");
        List<String> lucky = new ArrayList<>(Arrays.asList(luckyNumber));
        return lucky;
    }

    private List<Integer> translateToInt(List<String> target){
        List<Integer> lucky=new ArrayList<>();
        target.stream()
                .forEach(t->lucky.add(Integer.parseInt(t)));
        return lucky;
    }

    private void validateDuplication(List<Integer> numbers){
        if(numbers.size()!=numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자는 불가능합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 당첨 번호를 입력해야 합니다.");
        }
    }

    private void showStatistics(){
        outputView.printWinningStatistics(resultRepository);
    }

    private void solveRateOfReturn(){
        Calculator calculator=new Calculator();
        outputView.printRateOfReturn(calculator.getRateOfReturn());
    }
}
