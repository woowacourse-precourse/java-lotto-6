package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.Messages;
import lotto.service.LottoService;
import lotto.utils.Printer;
import lotto.utils.SystemPrinter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;
    private static final int maxCount = 50;
    private static final int basePrice = 1000;
    private static final int minLottoNum = 1;
    private static final int maxLottoNum = 45;
    private static final int baseLottoCount = 6;
    static Lotto pickedLotto;
    private static final String DELIMETER = ",";
    public LottoController(OutputView outputView, InputView inputView, LottoService lottoService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void process(){
        final LottoGenerator generator = insertMoney();
        buyLottos(generator);

        List<Lotto> myLotto = new ArrayList<>();

        // 기능 2. 당첨 번호 입력

        while (true){
            try{
//                printer.print(String.valueOf(Messages.REQUEST_WINNING_NUMBER));
                List<String> answer = Arrays.stream(Console.readLine().split(DELIMETER)).map(String::trim).toList();
                validatePickedNum(answer);
                pickedLotto = new Lotto(answer.stream().map(Integer::parseInt).toList());
                break;
            }catch (IllegalStateException | IllegalArgumentException e) {
//                System.out.println(e.getMessage());
            }
        }
        // 기능 3. 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber;
        while (true){
            try{
                String notValidatedBonusNumber = Console.readLine().trim();
                validateBonusNum(notValidatedBonusNumber);
                bonusNumber = Integer.parseInt(notValidatedBonusNumber);
                break;
            }catch (IllegalStateException | IllegalArgumentException e) {
//                System.out.println(e.getMessage());
            }
        }
        Console.close();
        int totalReward = 0;
        Map<Integer, String> template = new HashMap<>();
        template.put(1, "6개 일치");
        template.put(2, "5개 일치, 보너스 볼 일치");
        template.put(3, "5개 일치");
        template.put(4, "4개 일치");
        template.put(5, "3개 일치");

        Map<Integer, Integer> reward = new HashMap<>();
        reward.put(1, 2000000000);
        reward.put(2, 30000000);
        reward.put(3, 1500000);
        reward.put(4, 50000);
        reward.put(5, 5000);

        Map<Integer, Integer> result = new HashMap<>();
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);
        Console.close();

        // 4. 결과
        for(Lotto lotto: myLotto){
            Lotto finalPickedLotto = pickedLotto;

            long matchedNumbers = lotto.getLotto().stream().filter(l -> finalPickedLotto.getLotto().stream()
                    .anyMatch(Predicate.isEqual(l))).count();
            if(matchedNumbers == 6){
                if(finalPickedLotto.getLotto().contains(bonusNumber)){
                    result.put(2, result.get(2)+1);
                }else if(!finalPickedLotto.getLotto().contains(bonusNumber)){
                    result.put(1, result.get(1)+1);
                }

            }else if(matchedNumbers == 5){
                result.put(3, result.get(3)+1);
            }else if(matchedNumbers == 4){
                result.put(4, result.get(4)+1);
            }else if(matchedNumbers == 3){
                result.put(5, result.get(5)+1);
            }

        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            totalReward += reward.get(entry.getKey()) * entry.getValue();
        }
//        float profitRate =  ((float)totalReward /(float) money) * 100;

        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i = 5; i>=1; i--){
            System.out.printf("%s (%s원) - %d개%n", template.get(i), giveDot().format(reward.get(i)), result.get(i));
        }

//        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private LottoGenerator insertMoney(){
        while (true){
            try {
                String moneyBeforeValidated = inputView.readMoney();
                return LottoGenerator.createLottoGenerator(moneyBeforeValidated);
            }catch (IllegalStateException | IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
    private void buyLottos(LottoGenerator generator){
        int trial = generator.getTrial();
        outputView.printWithArguments(Messages.ALARM_TRIAL.toString(), trial);
        outputView.printLottos(lottoService.getLottos(generator));
    }
    public static DecimalFormat giveDot(){
        return new DecimalFormat("###,###");
    }

    public static void validatePickedNum(List<String> pickedNum){
        if(containsDuplicateNumber(pickedNum)){
            throw new IllegalStateException("[ERROR] 중복된 숫자가 있습니다.");
        }
        for(String num : pickedNum){
            if(containsLetter(num)){
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 있습니다.");
            }
            if(containsUnderMinNum(num) || containsUpperMaxNum(num)){
                throw new IllegalArgumentException("[ERROR] Min, Max 값 사이여야 합니다.");
            }
        }

    }
    public static void validateBonusNum(String bonusNum){
        if(containsLetter(bonusNum)){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 있습니다.");
        }
        if(containsUnderMinNum(bonusNum) || containsUpperMaxNum(bonusNum)){
            throw new IllegalArgumentException("[ERROR] Min, Max 값 사이여야 합니다.");
        }
        // 이미 가지고 있는 값에 대한 validate 추가
        if(hasAlreadyPicked(bonusNum)){
            throw new IllegalStateException("[ERROR] 보너스 번호가 이미 당첨 번호에 포함되어 있습니다.");
        }
    }

    public static boolean containsLetter(String pickedNum){
        try {
            Integer.parseInt(pickedNum);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    public static boolean containsUnderMinNum(String pickedNum){
        return Integer.parseInt(pickedNum) < minLottoNum;
    }
    public static boolean containsUpperMaxNum(String pickedNum){
        return Integer.parseInt(pickedNum) > maxLottoNum;
    }
    public static boolean containsDuplicateNumber(List<String> pickedNum){
        return pickedNum.stream().distinct().toList().size() != pickedNum.size();
    }
    public static boolean hasAlreadyPicked(String pickedNum){
        return pickedLotto.getLotto().contains(Integer.parseInt(pickedNum));
    }
}
