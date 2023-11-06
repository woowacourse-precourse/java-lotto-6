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
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] clientInput;
        while (true) {
            clientInput = Console.readLine().split(",");
            try {
                return new Lotto(Arrays.stream(clientInput)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
            } catch (NumberFormatException e){
                System.out.println("[ERROR] 숫자만 입력해주세요.");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void validateBonusNum(String tmp) {
        try{
            Integer.parseInt(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        if (Integer.parseInt(tmp) < 1 || Integer.parseInt(tmp) > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력해주세요.");
        } else if (this.lotto.getNumbers().contains(Integer.parseInt(tmp))) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
