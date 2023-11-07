package lotto;

import java.util.List;

import lotto.controller.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numbergenerator = new NumberGenerator();
        final int num = numbergenerator.inputBuyCost();
        final int num1 = numbergenerator.createUnitLotto(num);
        final List<List<Integer>> num2 = numbergenerator.createLottoNumbers(num1);

        for(List<Integer> st : num2){
            System.out.println(st);
        }

        String[] num3 = numbergenerator.InputCorrectLotto();
        final List<Integer> num4 = numbergenerator.conversionInputToInteger(num3);

        System.out.println(num4);
    }
}
