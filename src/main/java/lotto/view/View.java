package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class View {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";

    private static final String OUTPUT_PURCHASED_LOTTO_NUMBERS = "개를 구매했습니다.";

    public void request_InputMoney(){
        System.out.println(INPUT_MONEY);
    }

    public void request_InputWinLottoNumbers(){
        System.out.println(INPUT_WIN_LOTTO_NUMBERS);
    }

    public void request_InputBonusNumbers(){
        System.out.println(INPUT_BONUS_NUMBERS);
    }


    public void print_PurchasedLottoNumbers(int purchasedLottoNum){
        System.out.println(purchasedLottoNum + OUTPUT_PURCHASED_LOTTO_NUMBERS);
    }

    public void print_purchasedLotto(List<Lotto> purchasedLotto){
        purchasedLotto.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public void print_Exception(String errorMessage){
        System.out.println(errorMessage);
    }
}
