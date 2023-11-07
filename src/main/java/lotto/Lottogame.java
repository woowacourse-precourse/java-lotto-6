package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lottogame {
    public void lottogame(){
        System.out.println("구입금액을 입력해 주세요");
        String strbuynumber = Console.readLine();
        int buynumber = Integer.parseInt(strbuynumber);
        if(buynumber%1000!=0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위로 입력받습니다");
        }
        int count = buynumber/1000;
        System.out.println(count+"개를 구매했습니다");
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            List<Integer> lottoNumbers= lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
        Admin admin = new Admin();
        String[] winumber= admin.winumbers();
        int bounsnumber =admin.bounsnumber();
        System.out.println(Arrays.toString(winumber));
        System.out.println(bounsnumber);
    }
}
