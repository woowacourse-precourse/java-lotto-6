package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Lotto> lottos;
    private final List<Integer> prizes;
    private final List<Integer> checkCount;
    private final int BONUS_NUMBER_CORRECT;
    private int COUNT_LOTTO;
    private int BONUS_NUMBER;
    private InputView inputView;
    private OutputView outputView;
    private int CHECK_PRIZE;
    private final String ERROR_MESSAGE_1000 = "[ERROR] 1,000단위로 입력해주세요.";
    private final String ERROR_MESSAGE_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    private final String ERROR_MESSAGE_REPEAT = "[ERROR] 숫자가 중복되지 않도록 입력해주세요.";
    private final String ERROR_MESSAGE_OVERLESS = "[ERROR] 숫자가 45보다 크거나 1보다 작지 않도록 입력해주세요.";
    private final String ERROR_MESSAGE_OVERLESS_NUMBERS = "[ERROR] 숫자를 6자리 입력해주세요.";
    private String ERROR_MESSAGE;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
        lottos = new ArrayList<>();
        prizes = new ArrayList<>();
        checkCount = new ArrayList<>();
        BONUS_NUMBER_CORRECT = 7;
    }

    public void run(){
        inputView.purchaseAmountView();
        COUNT_LOTTO = purchaseAmountInput(); //로또 구매 금액 입력

        outputView.purchasesNumberView(COUNT_LOTTO);
        createLotto(COUNT_LOTTO);    //로또 생성 및 출력

        inputView.prizeNumberView();
        prizeNumberInput();   //당첨 번호 입력 및 변환

        inputView.bonusNumberView();
        BONUS_NUMBER = bonusNumberInput(); //보너스 번호 입력 및 변환

        checkPrize(lottos, prizes); //당첨 개수 확인
        outputView.winningStatistics(checkCount, COUNT_LOTTO*1000); //당첨 통계 및 수익률 출력
    }

    public int purchaseAmountInput(){
        int input;
        while(true) {
            try{
                input = validate_Number();  //숫자를 입력하지 않는 경우 예외 처리
                validate_1000(input);   //1,000원이 아닌 경우 예외 처리
                break;
            }catch (IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE);
            }
        }
        return input/1000;
    }

    private int validate_Number(){
        try {
            return Integer.parseInt(Console.readLine());

        }catch (IllegalArgumentException e){
            ERROR_MESSAGE = ERROR_MESSAGE_NUMBER;
            throw new IllegalArgumentException();
        }
    }

    private void validate_1000(int input){
            if (input % 1000 != 0) {
                ERROR_MESSAGE = ERROR_MESSAGE_1000;
                throw new IllegalArgumentException();
            }
    }

    public void createLotto(int AMOUNT){
        for(int i=0; i<AMOUNT; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        outputView.lottosView(lottos);
    }

    public void prizeNumberInput(){
        while(true) {
            try {
                String PRIZE = Console.readLine();
                changePrizeNumber(PRIZE);
                break;
            }catch (IllegalArgumentException e){
                prizes.clear();
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public void changePrizeNumber(String PRIZE){
        changeNumbers(PRIZE.split(","));    // 숫자로 변경
        validate_OverLess_Numbers(prizes);   //7개 이상 입력 예외 처리
        validate_Duplication(prizes); // 중복 예외 처리
        validate_OverLess(prizes); //당첨 번호 45 초과, 1 미만 예외 처리
    }

    public void changeNumbers(String[] prizeNumbers){
        try {
            for (String prizeNumber : prizeNumbers) {
                prizes.add(Integer.parseInt(prizeNumber));
            }
        }catch (IllegalArgumentException e){
            ERROR_MESSAGE = ERROR_MESSAGE_NUMBER;
            throw new IllegalArgumentException();
        }
    }

    private void validate_Duplication(List<Integer> prizes){
        for (int i=0; i<prizes.size(); i++) {
            int prize = prizes.get(i);
            inside_Repeat(prize, prizes, i);
        }
    }

    private void inside_Repeat(int prize, List<Integer> prizes, int i){
        for(int n=0; n<prizes.size(); n++){
            if(prize == prizes.get(n) && n != i){
                ERROR_MESSAGE = ERROR_MESSAGE_REPEAT;
                throw new IllegalArgumentException();
            }
        }
    }

    private void validate_OverLess(List<Integer> prizes){
        for (int prize : prizes) {
            if(prize > 45 || prize < 1){
                ERROR_MESSAGE = ERROR_MESSAGE_OVERLESS;
                throw new IllegalArgumentException();
            }
        }
    }

    public void validate_OverLess_Numbers(List<Integer> prizes){
        if(prizes.size() != 6){
            ERROR_MESSAGE = ERROR_MESSAGE_OVERLESS_NUMBERS;
            throw new IllegalArgumentException();
        }
    }

    public int bonusNumberInput(){
        int bonusNumber;
        while(true) {
            try {
                String PRIZE = Console.readLine();
                bonusNumber = changeBonusNumber(PRIZE);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE);
            }
        }
        return bonusNumber;
    }

    public int changeBonusNumber(String PRIZE){
        int bonus = changeBonusPrize(PRIZE);
        validate_Duplication_Bonus(prizes, bonus); // 중복 예외 처리
        validate_OverLess_Bonus(bonus); //당첨 번호 45 초과, 1 미만 예외 처리

        return bonus;
    }

    private int changeBonusPrize(String PRIZE){
        try{
            return Integer.parseInt(PRIZE);
        }catch (IllegalArgumentException e){
            ERROR_MESSAGE = ERROR_MESSAGE_NUMBER;
            throw new IllegalArgumentException();
        }
    }

    private void validate_Duplication_Bonus(List<Integer> prizes, int bonus){
        for (int prize : prizes) {
            if(prize == bonus){
                ERROR_MESSAGE = ERROR_MESSAGE_REPEAT;
                throw new IllegalArgumentException();
            }
        }
    }

    private void validate_OverLess_Bonus(int bonus){
        if (bonus > 45 || bonus < 1) {
            ERROR_MESSAGE = ERROR_MESSAGE_OVERLESS;
            throw new IllegalArgumentException();
        }
    }

    public void checkPrize(List<Lotto> lottos, List<Integer> prizes){
        for (Lotto lotto : lottos) {
            prizeNumber(lotto, prizes);
        }
    }

    public void prizeNumber(Lotto lotto, List<Integer> prizes){
        List<Integer> numbers = lotto.getNumbers();
        CHECK_PRIZE = 0;

        for (int number : numbers) {
            repetitionPrize(prizes, number);
        }

        int prize = checkBonus(CHECK_PRIZE, lotto);//보너스 확인
        checkCount.add(prize);
    }

    public void repetitionPrize(List<Integer> prizes, int number){
        for (int prize : prizes) {
            if(prize == number){
                CHECK_PRIZE++;
            }
        }
    }

    public int checkBonus(int CHECK_PRIZE, Lotto lotto){
        if(CHECK_PRIZE == 5){
            if(isBonus(lotto)){
                return BONUS_NUMBER_CORRECT;
            }
        }
        return CHECK_PRIZE;
    }

    public Boolean isBonus(Lotto lotto){
        List<Integer> numbers = lotto.getNumbers();

        for (int number : numbers) {
            if(BONUS_NUMBER == number){
                return true;
            }
        }
        return false;
    }
}
