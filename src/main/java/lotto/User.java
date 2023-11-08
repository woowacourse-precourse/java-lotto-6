package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Stream;

class User {

    public String input() {
        String input = Console.readLine();
        return input;
    }

    public int getMoney(){
        int volume;
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String volumeStr = input();
                int money = parseInputAsInt(volumeStr);
                validateMoney(money);
                volume = money/1000;
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요");
            }
        }
        return volume;
    }


    public Lotto getWinningLotto(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        Lotto winningLotto;
        while (true) {
            try {
                List<Integer>winningNumber = parseInputAsList(input());
                winningLotto = new Lotto(winningNumber);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요");
            }
        }
        return winningLotto;
    }


    public int parseInputAsInt(String string){
        int number = 0;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식의 숫자가 아닙니다.");
        }
        return number;
    }

    public List<Integer> parseInputAsList(String string){
        Integer[] inputNums;
        try {
            inputNums = Stream.of(string.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식의 당첨 숫자가 아닙니다.");
        }
        for (int i : inputNums) {
            if (i > 45 || i < 0) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이에 존재해야 합니다.");
            }
        }
        List<Integer> numbers = new ArrayList<>(Arrays.asList(inputNums));
        return numbers;
    }

    public int getBonusNumber(Lotto winningLotto){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum =0;
        while (true) {
            try {
                bonusNum = parseInputAsInt(input());
                validateBonusNumber(winningLotto, bonusNum);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요");
            }
        }
        return bonusNum;
    }

    public void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 이미 당첨 숫자에 있는 번호는 보너스 번호가 될수 없습니다.");
        }
        if (bonusNumber > 45 || bonusNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1~45 사이에 존재해야 합니다.");
        }
    }

    public void validateMoney(int money) {
        if(money<0){
            throw new IllegalArgumentException("[ERROR] 0원 보다 작은 금액으로 구매할수 없습니다. 합니다.");
        }
        if (money % 1000 != 0 && money < 1000) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 반드시 1000원 단위어야만 합니다.");
        }
    }
}