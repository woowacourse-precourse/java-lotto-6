package lotto.view;


import lotto.domain.Lottos;

public class OutputViewLotto {
    public static void printLotto(Lottos lottos){
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
