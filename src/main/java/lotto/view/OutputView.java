package lotto.view;

import java.util.List;
import lotto.service.LottoDto;

public class OutputView {
    public static void printError(String message) {
        System.out.println(message);
    }

    public static void displayLottos(List<LottoDto> lottoDtos) {
        printEmptyLine();
        System.out.println(lottoDtos.size()+"개 구매하셨습니다.");
        for (int i = 0; i < lottoDtos.size(); i++) {
            System.out.println(lottoDtos.get(i).numbers());
        }
    }

    private static void printEmptyLine(){
        System.out.println();
    }

}
