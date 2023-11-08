package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;
import lotto.domain.UserNumberInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = amountValidate();

        int lottoCount = purchaseAmount / 1000;
        Lottos lottos = new Lottos(new UserNumberInput());
        lottos.lottoTicketsNum(lottoCount); //가격에 맞춰 로또 번호 추출
    }

    public static int amountValidate() {
        int amount = Integer.parseInt(Console.readLine());
        try{
            if(amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하셔야 합니다.");
            }else if(amount == 0){
                throw new IllegalArgumentException("[ERROR] 1000원 이상 입력하셔야 합니다.");
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return amountValidate();
        }
        return amount;
    }
}

