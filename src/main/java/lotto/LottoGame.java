package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final User user;
    private List<Integer> winningLottoNumbers;
    private int bonusNumber;

    public LottoGame(User user) {
        this.user = user;
    }

    // 당첨 번호 입력
    public void inputLottoNumbers() {
        winningLottoNumbers = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // 보너스 번호 입력
    public void inputBonusNumber() {
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    public void printLottos(List<Lotto> lotts) {
        for (Lotto lo : lotts) {
            System.out.println(lo.getNumbers());
        }
    }

    public void checkNumber(List<Lotto> lottos) {
        System.out.println("----- checkNumber 시작 -----");

        HashMap<Prize, Integer> map = new HashMap<>();
        List<Integer> matches = new ArrayList<>(); // 각 로또별 일치번호 갯수

        for (Prize prize : Prize.values()) {
            map.put(prize, 0);
        }
        
        for (Lotto lotto : lottos) {
            int count = 0;
            boolean bonusMatch = false;
            
            for (int number : lotto.getNumbers()) {
                if(winningLottoNumbers.contains(number)) {
                    count++;
                }
                if(number == bonusNumber) {
                    bonusMatch = true;
                }
                System.out.println("count = " + count);
            }
            matches.add(count);
            Prize prize = Prize.valueOf(count, bonusMatch);
            map.put(prize, map.get(prize) + 1);
//            if(lotto.getNumbers().contains(bonusNumber)) {
//                bonusMatch = true;
//            }
            System.out.println(matches + "\n");
//            System.out.println();
        }
//        System.out.println("matches = " + matches);
        System.out.println("map = " + map);
        // 로또별 일치갯수는 저장되었음
        // TODO 일치 수 출력하고 수익률 계산
//        printCheck(matches, bonusNumber);
    }

    public void printCheck(List<Integer> matches, int bonusNumber) {
        int i = 0;
        for (Integer match : matches) {
            if(match == 3) Prize.THREE.getPrize();
            if(match == 4) Prize.FOUR.getPrize();
            if(match == 5) Prize.FIVE.getPrize();
//            if(match == 5 && bonusNumber) Prize.FIVE.getPrize();
            if(match == 6) Prize.SIX.getPrize();
            i++;
        }
    }

//    public void checkNumber(List<Lotto> lottos) {
//        System.out.println("----- checkNumber 시작 -----");
//        int[] matchcCounts = new int[6];
//
//        System.out.println("winningLottoNumbers = " + winningLottoNumbers);
//        System.out.println("lottos.get(i).getNumbers() = " + lottos.get(0).getNumbers());
//        for(int i=0; i<lottos.size(); i++) {
//            int count = 0;
//
//            for(int j=0; j<lottos.get(i).getNumbers().size(); j++) {
//                System.out.println("lottos.get(i).getNumbers() = " + lottos.get(i).getNumbers());
//                int myLottoNumber = lottos.get(i).getNumbers().get(j);
//                System.out.println("myLottoNumber = " + myLottoNumber);
//
//                if(winningLottoNumbers.contains(myLottoNumber)) {
//                    count++;
////                }
//            }
//            matchcCounts[i] = count;
//        }
//
//        for (Integer matchcCount : matchcCounts) {
//            System.out.println("matchcCount = " + matchcCount);
//        }
//
////        System.out.println("--- lottos.size() = " + lottos.size());
////        System.out.println("--- 로또 객체 하나 길이 = " + lottos.get(0).getNumbers().size());
////        for(int i=0; i<lottos.size(); i++) {
////            List<Integer> matchNumbers = new ArrayList<>();
////
////            int count = 0;
////            System.out.println("2for checkNumber = ");
////            for(int j=0; j<lottos.get(i).getNumbers().size(); j++) {
////                System.out.println("3for checkNumber = ");
////                int myLottoNumber = lottos.get(i).getNumbers().get(j);
////
////                if(winningLottoNumbers.contains(myLottoNumber) || bonusNumber == myLottoNumber) {
////                    System.out.println("4if checkNumber = ");
////                    matchNumbers.add(myLottoNumber);
////                    count++;
////                }
////            }
////            // 일치 갯수, 당첨금 hash에
////        }
//        System.out.println("5 checkNumber = ");
//
//    }
}
