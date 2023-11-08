package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.security.PublicKey;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private static List<Lotto> lottoNumbers = new ArrayList<>();
    private static int[] result = new int[8];
    private static String[] errorCode = new String[1];
    private static double totalMoney = 0;
    private static Lotto catchNumbers;
    private static int bonusNumber;
    public static void main(String[] args) {
        int inpMoney = getInputMoney();
        BuyLotto(inpMoney/1000);

        getCatchNumber();
        getBonusNumber();

        getResultInfo();
        printResult(inpMoney);
    }
    public static void printResult(int inpMoney){
        System.out.println("당첨 통계\n---");
        int idx = 0;
        for(int i = 3; i <= 7; i++){
            MatchNumber tmp = MatchNumber.getMatchNumber(i);
            totalMoney += tmp.getValue() * result[i];
            idx = tmp.getCount();
            if(idx >= 6) idx--;
            if(i == 6){
                System.out.println(idx + "개 일치, 보너스 볼 일치 (" + tmp.getName() + "원) - " + result[i] +"개");
                continue;
            }
            System.out.println(idx + "개 일치 (" + tmp.getName() + "원) - " + result[i] +"개");
        }
        System.out.println("총 수익률은 "+ getEarnResult(inpMoney) +"%입니다.");
    }

    public static String getEarnResult(int inpMoney){
        return String.format("%.1f",(totalMoney/(double)inpMoney)*100).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
    }

    public static void getResultInfo(){
        for(int i = 0; i < lottoNumbers.size(); i++){
            int idx = lottoNumbers.get(i).compareNumber(catchNumbers,bonusNumber);
            result[idx]++;
        }
    }
    public static void getCatchNumber() {
        while(true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String userInput = Console.readLine();
            String[] catchNumber = userInput.split(",");
            try{
                catchNumbers = new Lotto(validateCatchNumber(catchNumber,errorCode),errorCode);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(errorCode);
            }
        }
    }

    public static List<Integer> validateCatchNumber(String[] catchNumber,String errorCode[]){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < catchNumber.length; i++){
            int num = isInteger(catchNumber[i],errorCode);
            if(!checkInRange(num,"catchNumber",errorCode)){
                throw new IllegalArgumentException();
            }
            result.add(num);
        }
        return result;
    }

    public static void getBonusNumber(){
        while(true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                bonusNumber = isInteger(Console.readLine(),errorCode);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(errorCode[0]);
            }
        }
        System.out.println("당첨번호: " + catchNumbers);
    }

    public static void checkDuplicateNumber(Lotto lotto){
        if(lottoNumbers.contains(lotto)) throw new IllegalArgumentException();
    }
    public static void BuyLotto(int num){
        System.out.println(num + "개를 구매했습니다.");
        while(lottoNumbers.size() < num){
            try {
                Lotto lotto = new Lotto(createLotto(),errorCode);
                checkDuplicateNumber(lotto);
                lotto.printNumber();
                lottoNumbers.add(lotto);
            }catch(IllegalArgumentException e) {
                System.out.println(errorCode);
            }
        }
    }

    public static List<Integer> createLotto(){
        List<Integer> lottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumber);

        return lottoNumber;
    }

    public static int getInputMoney(){
        int inputMoney = 0;
        errorCode[0] = null;
        while(true) {
            System.out.println("구입금액을 입력해 주세요.");
            String userInput = Console.readLine();
            try{
                inputMoney = isInteger(userInput,errorCode);
                validateInputMoney(inputMoney);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(errorCode[0]);
            }
        }
        return inputMoney;
    }

    public static void validateInputMoney(int inputMoney){
        if(!checkInRange(inputMoney,"purchaseMoney",errorCode) || !divideThousand(inputMoney,errorCode)) {
            throw new IllegalArgumentException();
        }
    }
    public static int isInteger(String userInput,String[] errorCode){
        try{
           return Integer.parseInt(userInput);
        }catch(NumberFormatException e){
            errorCode[0] = "[ERROR] 입력은 숫자이어야 합니다.";
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkInRange(int num,String inputTypeName,String[] errorCode){
        InputType inputType = InputType.valueOf(inputTypeName);
        if(inputType.getValue() == 0 && num <= 0){
            errorCode[0] = "[ERROR] 입력은 양수이어야 합니다.";
            return false;
        }

        if(inputType.getValue() == 1 && (num < 1 || num > 45)){
            errorCode[0] = "[ERROR] 입력은 1~45 사이의 숫자이어야 합니다.";
            return false;
        }
        return true;
    }

    public static boolean divideThousand(int num,String[] errorCode){
        if(num % 1000 != 0){
            errorCode[0] = "[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.";
            return false;
        }
        return true;
    }

}