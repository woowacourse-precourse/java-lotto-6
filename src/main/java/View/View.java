package View;

import Input.LottoInput;

import java.util.List;

public class View {
    public static int getPrice() {
        int price;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                price = LottoInput.inputPrice();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000원 단위의 가격을 입력해주세요");
            }
        }
        return price;
    }

    public static List<Integer> getAnswer() {
        List<Integer> answer;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                answer = LottoInput.makeAnswerNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return answer;
    }

    public static int getBonus() {
        int bonus;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonus = LottoInput.makeBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return bonus;
    }
}
