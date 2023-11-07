package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserOutputView {

    public static  void outputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요");

    }

    public static void getBuyLottoTicketsNum(){
        System.out.println();
        System.out.println(LottoController.getBuyLottoTicketsNum() + "개를 구입했습니다.");
    }

    public static void getBuyLottoTickets(){
        for(Lotto lotto : LottoController.getBuyLottoTickets()){
            System.out.println(getLottoNums(lotto));
        }

    }

    public static void outputWinningNums(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void outputBonusNum(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }




    private static List<Integer> getLottoNums(Lotto lotto){
        List<Integer> lottoNums = new ArrayList<>();
        for(Integer lottoNum : lotto.getNumbers()){
            lottoNums.add(lottoNum);
        }
        return lottoNums;
    }

}
