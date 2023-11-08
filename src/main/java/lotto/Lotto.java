package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static int[] counts = new int[Input.lottoQuantity];
    public static int[] rank = new int[5];
    public static int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try{
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("6");
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 6개만 입력 받을 수 있습니다.");
            Input.InputLottoNumbers();
        }
    }

    public void InputBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());

        Compare();
    }

    public void Compare(){
        for (int i = 0; i < Input.lottoQuantity; i++){
            for (int j = 0; j < 6; j++){
                counts[i] += CompareNumber(i, j);
            }
        }
        ResultCounts(counts);
    }

    public int CompareNumber(int i, int j){
        for (int k = 0; k < 6; k++){
            if (Input.lottoAllNumbers[i][j] == numbers.get(k)){
                return 1;
            }
        }
        return 0;
    }

    public void ResultCounts(int[] counts){
        for (int i = 0; i < Input.lottoQuantity; i++){
            if(counts[i] == 6){
                rank[4]++;
            }
            if(counts[i] == 5){
                IsBonus(i);
            }
            if(counts[i] == 4){
                rank[1]++;
            }
            if(counts[i] == 3){
                rank[0]++;
            }
        }
        System.out.println("3개 일치 (5,000원) - " + rank[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + rank[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rank[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rank[4] + "개");
        Sum();
    }
    public int IsBonus(int num) {
        for (int k = 0; k < 6; k++){
            if (Input.lottoAllNumbers[num][k] == bonusNumber){
                return rank[3]++;
            }
        }
//        return false;
        return rank[2]++;
    }

    public void Sum(){
        int sum = 0;
        float result = 0;

        sum = (rank[0] * 5000) + (rank[1] * 50000)
                + (rank[2] * 1500000) + (rank[3] * 30000000) + (rank[4] * 2000000000);

        result = ((float) sum / Input.money) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", result) + "%입니다.");
    }
}
