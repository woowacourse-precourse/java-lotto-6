package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Client {
    private Lotto lotto;
    private int bonusNum;

    public Lotto getLotto() {
        return this.lotto;
    }

    public void setLotto() {
        this.lotto = getCilentLotto();
    }

    public int getBonusNum() {
        return this.bonusNum;
    }

    public void setBonusNum() {
        System.out.println("보너스 번호를 입력해주세요.");
        String tmp;
        while (true) {
            tmp = Console.readLine();
            try {
                validateBonusNum(tmp);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.bonusNum = Integer.parseInt(tmp);
    }

    public Lotto getCilentLotto() {
        System.out.println("구매할 로또를 입력해주세요.");
        String[] tmp;
        while (true) {
            tmp = Console.readLine().split(",");
            try {
                validate(tmp);
                break;
            } catch (IllegalArgumentException e) {
                getCilentLotto();
            }
        }
        return new Lotto(Arrays.stream(tmp).map(Integer::parseInt).collect(Collectors.toList()));
    }

    private void validate(String[] clientInput) {
        if (clientInput.length != 6) {
            System.out.println("[ERROR] 로또 번호는 6개만 입력해주세요.");
            throw new IllegalArgumentException();
        } else if (Arrays.stream(clientInput).distinct().count() != 6) {
            System.out.println("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
        try{
            if(Arrays.stream(clientInput).anyMatch(x -> Integer.parseInt(x) < 1 || Integer.parseInt(x) > 45)){
                System.out.println("[ERROR] 1~45 사이의 숫자만 입력해주세요.");
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }


    private void validateBonusNum(String tmp) {
        try{
            Integer.parseInt(tmp);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(tmp) < 1 || Integer.parseInt(tmp) > 45) {
            System.out.println("[ERROR] 1~45 사이의 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        } else if (this.lotto.getNumbers().contains(Integer.parseInt(tmp))) {
            System.out.println("[ERROR] 로또 번호와 중복된 숫자는 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
