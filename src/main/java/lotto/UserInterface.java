package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserInterface {
    // 구입금액을 입력받기
    // -> 구입금액을 문자열로 입력받음 -> 이거를 정수로 바꿈 -> 천단위인지 검사 -> 천단위 아니면 예외 -> 맞으면 정수로 저장 -> 이 정수횟수만큼 로또를 발행 -> 이거를 커스토머의 포켓에 저장
    //    Input.buyLottoInput   |                                                               |                                                |
    public static Integer buyLottoInput() {
        try {
            System.out.println("구입금액을 입력해 주세요");
            Integer money = Integer.parseInt(Console.readLine());
            return money;
        }catch(NumberFormatException t){
            System.out.println("[ERROR] 숫자를 입력해 주세요");
            return buyLottoInput();
        }
    }
    public static Integer moneyValidate(Integer money){
        try {
            if (money == 0) {
                throw new IllegalArgumentException("[ERROR] 0은 입력할 수 없습니다.");
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 천원 단위의 금액만 입력가능합니다.");
            }
            System.out.println((money /1000) +"개를 구매했습니다.");
            return (money / 1000);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return moneyValidate(buyLottoInput());
        }
    }
    // 당첨번호를 입력받기
    public static List<Integer> winningNumberInput() {
        try {
            System.out.println("당첨 번호를 입력해 주세요");
            List<String> input = Arrays.asList(Console.readLine().split(","));
            List<Integer> winningNumbers = new ArrayList<>();
            for(int i=0; i<input.size(); i++){
                winningNumbers.add(Integer.parseInt(input.get(i)));
            }
            return winningNumbers;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
    public static List<Integer> winningValidate(List<Integer> winningNumber){
        try {
            if (winningNumber.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
            }
            if (Collections.max(winningNumber) > 45 || Collections.min(winningNumber) < 1){
                throw new IllegalArgumentException("[ERROR] 1 ~ 45의 숫자를 입력해 주세요.");
            }
            return winningNumber;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return winningValidate(winningNumberInput());
        }
    }

    public static Integer bonusInput() {
        try {
            Integer bonus = Integer.parseInt(Console.readLine());
            return bonus;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 한개의 숫자를 입력해 주세요");
        }
    }
    public static Integer bonusValidate(Integer bonus){
        try {
            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45의 숫자를 입력해 주세요.");
            }
            return bonus;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return bonusValidate(bonusInput());
        }
    }
    // 당첨 내역을 출력하기
    public void printJudgment(List<LottoResults> judgeresult){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + judgeresult.get(4).getCounts() + "개");
        System.out.println("4개 일치 (50,000원) - " + judgeresult.get(3).getCounts() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + judgeresult.get(2).getCounts() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + judgeresult.get(1).getCounts() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + judgeresult.get(0).getCounts() + "개");
    }
    // 수익률을 출력하기
    public void printPrizeRate(Double prizeRate){
        System.out.println("총 수익률은 " + prizeRate + "%입니다.");
    }


}
