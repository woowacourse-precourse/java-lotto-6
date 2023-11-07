package view;

import model.LottoObjectManagement;

public class OutputLottoList {
    public static void printLottoList(LottoObjectManagement lottoObjectManagement) {
        lottoObjectManagement.getObjectManagement().forEach(System.out::println);
        System.out.println();
    }
}