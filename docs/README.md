# 미션 - 로또

## 🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 입출력 요구 사항

#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000
```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6
```

- 보너스 번호를 입력 받는다.

```
7
```

#### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

- 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```
총 수익률은 62.5%입니다.
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

#### 실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

---

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

### 추가된 요구 사항

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console`
  API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

```java
List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
```

### Lotto 클래스

- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- `numbers`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- `Lotto`의 패키지 변경은 가능하다.

```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
```

---

# 요구사항 구현 및 회고 

## 🚨️  필요기능 목록 정의
1. 로또 구입 금액을 입력 받는다.
   1. "구입금액을 입력해 주세요." 안내 메세지를 구매자에게 보여준다.
   2. 구매자에게 입력 값을 받는다.
  

2. 구매자에게 입력받은 값이 숫자인지 검증한다.
   1. 구입 금액은 1,000원 단위로 입력 받는다.
   2. 예외처리 : 입력한 값이 숫자가 아니면 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.  

    
3. 입력 받은 금액을 계산하여 구매한 로또 개수를 정한다.
   1. 입력받은 금액을 1,000원 단위로 나누어 개수를 정한다 (예 : 10,000 = 10개)
   2. 예외처리 : 1,000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  

4. 구매한 로또 개수 만큼 로또를 발행한다.
   1. n개를 구매했습니다. 안내 메세지를 구매자에게 보여준다.
   2. Lotto 클래스를 활용하여 로또를 n개 발행한다.
  
   
6. 발행한 로또 n개의 로또 번호를 구매자에게 보여준다.
  

7. 당첨 번호를 입력 받는다.
   1. "당첨 번호를 입력해 주세요." 안내 메세지를 구매자에게 보여준다.
   2. 쉼표(,)를 기준으로 6개의 숫자를 입력받습니다.
  

8. 당첨 번호를 쉼표(,)를 기준으로 구분하여 한다.
   1. 번호는 쉼표(,)를 기준으로 구분한다.
   2. 입력 받은 값이 쉼표(,)를 기준으로 구분하지 못하면 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  

9. 구분된 당첨번호를 검증한다.
   1. 예외처리 : 입력 받은 값이 6개의 숫자가 아니면 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
   2. 검증 된 번호는 오름차순으로 저장한다.
  

10. 보너스 번호를 입력 받는다. 
    1. "보너스 번호를 입력해 주세요." 안내 메세지를 구매자에게 보여준다.
    2. 예외처리 : 입력 받은 값이 1자리의 숫자가 아니면 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  

11. 입력 받은 보너스 번호가 숫자인지 검증합니다.
    1. 예외처리 : 입력 받은 값이 숫자가 아니면 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  

12. 입력받은 보너스번호가 1~45사이의 숫자인지 검증한다.
    1. 예외처리 : 입력 받은 값이 숫자가 1~45 범위가 아니면 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  

13. 입력받은 보너스번호가 당첨번호와 중복되는지 검증한다.
    1. 예외처리 : 입력 받은 값이 당첨번호와 중복되면 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  

14. 당첨 금액을 계산한다.
    1. 3개 일치 : 5,000원
    2. 4개 일치 : 50,000원
    3. 5개 일치 : 1,500,000원
    4. 5개 일치 보너스 볼 일치 : 30,000,000원
    5. 6개 일치 : 2,000,000,000원
  

15. 총 수익률을 계산한다.
    1. 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%) 
  

16. 구매자에게 당첨 내역을 보여준다.

---

## 📮 필요기능 구현
####  검색의 도움 없이 내가 구현 할 수 있는 방법으로 구현을 해 보았습니다.

### 1. inputPurchaseAmount()
````
 public static String inputPurchaseAmount(){
    System.out.println("구입금액을 입력해 주세요.");
    String inputPurchaseAmount = Console.readLine();
    return inputPurchaseAmount;
}
````
1. inputPurchaseAmount() 메서드에서 사용자에게 값을 입력받습니다.
2. Console.readLine()을 활용하여 콘솔창에서 사용자에 값을 입력받습니다. 

### 2. inputPurchaseAmountValidation()
````
public static int inputPurchaseAmountValidation(String inputPurchaseAmount){
    try {
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        return purchaseAmount;
    }catch (NumberFormatException e){
        throw new IllegalArgumentException("[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000 ");
    }
}
````
1. inputPurchaseAmountValidation() 메서드에서 사용자가 입력한 값이 숫자인지 검증합니다.
2. 입력받은 값(String)을 Integer.parseInt()로 파싱하여 int로 형변환을 합니다.
3. 형변환에 실패할 경우 NumberFormatException 예외가 발생하고 발생한 예외를 catch에서 IllegalArgumentException 발생하고, **"[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000"** 메세지를 사용자에게 표시합니다.

### 3. inputPurchaseAmountValidation()
````
public static int lottoQuantity(int lottoPurchaseAmount){
    int lottoPurchaseAmountRemain = lottoPurchaseAmount % 1000;
    if(lottoPurchaseAmountRemain != 0){
        throw new IllegalArgumentException("[ERROR] 구입금액을 1,000원 단위로 입력하세요.");
    }
    int lottoQuantity = lottoPurchaseAmount / 1000;
    return lottoQuantity;
}
````
1. lottoQuantity() 메서드에서 inputPurchaseAmountValidation()에서 검증된 구입금액이 1,000원 단위인지 검증합니다.
2. 검증된 입력금액을 나머지연선자(%)를 활용하여 1,000원단위 인지 검증 하였습니다.
3. 1,000원 단위가 검증 된 후 나누기연산자(/)를 활용하여 로또 구매 수량을 계산하였습니다.

### 4. createLottos()
````
public static List<Lotto> createLottos(int lottoQuantity){
    List<Lotto> lottos= new ArrayList<>();

    for(int quantity = 1; quantity <= lottoQuantity ; quantity++){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbers);
        lottos.add(lotto);
    }
    return lottos;
}
````
1. createLottos() 메서드에서 입력받은 개수 만큼 로또를 생성합니다.
2. Randoms.pickUniqueNumbersInRange()를 활용하여 1~45 범위의 6개의 숫자를 랜덤으로 List에 저장합니다.
3. 저장된 6개의 로또 번호를 Collections.sort()를 활용하여 오름차순 정렬을 하였습니다.
4. 정렬된 로또번호를 Lotto 클래스의 생성자를 활용하여 Lotto 클래스의 인스턴스를 생성후 List<Lotto>에 추가하여 n개의 로또를 생성합니다.

### 4. purchaseLottoNumbersDisplay()
````
public static void purchaseLottoNumbersDisplay(List<Lotto> lottos){
    int lottoQuantity = lottos.size();
    System.out.println(lottoQuantity+"개를 구매했습니다.");
    for (int quantity = 1 ; quantity <= lottoQuantity ; quantity++){
        lottos.get(quantity-1).lottoNumberDisplay();
    }
    System.out.println("");
}
````
1. purchaseLottoNumbersDisplay() 메서드에서 구매한 로또 번호를 사용자에게 보여줍니다.
2. Lotto.lottoNumberDisplay() 인스턴스 메서드를 구현하여 Lotto 인스턴스의 로또번호를 사용자에게 보여줍니다.
    ````
    public void lottoNumberDisplay(){
        List<Integer> lottoNumbers = getNumbers();
        StringJoiner displayLottoNumber = new StringJoiner(", ","[","]");
        for(int i = 0 ; i < lottoNumbers.size() ; i ++){
            String number = String.valueOf(lottoNumbers.get(i));
            displayLottoNumber.add(number);
        }
        System.out.println(displayLottoNumber);
    }
    ````
   1. StringJoiner를 활용하여 **"[1, 2, 3, 4, 5, 6]"** 의 형식으로 사용자에게 보여줍니다. 

### 5. inputWinningNumber()
````
public static String inputWinningNumber(){
    System.out.println("당첨 번호를 입력해 주세요.");
    String inputWinningNumber = Console.readLine();
    return inputWinningNumber;
}
````
1. inputWinningNumber() 메서드에서 당첨번호를 입력 받습니다. 

### 6. inputWinningNumberSplit()
````
public static String[] inputWinningNumberSplit(String inputWinningNumber){
    String[] inputWinningNumberSplit = inputWinningNumber.split(",");
    if(inputWinningNumberSplit.length != 6){
        throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉼표(,)를 기준으로 6자리를 입력해주세요.");
    }
    return inputWinningNumberSplit;
}
````
1. inputWinningNumberSplit() 메서드에서 입력받은 당첨번호가 쉼표(,) 구분자로 6개의 숫자인지 검증합니다.
2. String.split()을 활용하여 쉼표(,) 구분자로 나누어 String[]를 만들고 String[]의 length가 6이 아니면 IllegalArgumentException 예외를 발생하여 검증하였습니다. 

### 7. inputWinningNumberValidation()
````
public static List<Integer> inputWinningNumberValidation(String[] inputWinningNumberSplit){
    try {
        List<Integer> winningNumber = new ArrayList<>();
        for (int i = 0 ; i < inputWinningNumberSplit.length ; i++){
            int number = Integer.parseInt(inputWinningNumberSplit[i]);
            winningNumber.add(number);
        }
        Collections.sort(winningNumber);
        return winningNumber;
    }catch (NumberFormatException e){
        throw new IllegalArgumentException("[ERROR] 당첨 번호를 숫자로 입력해주세요.");
    }
}
````
1. inputWinningNumberValidation() 메서드에서 쉼표(,) 구분자로 나뉜 String[]의 각각의 값이 숫자인지 검증합니다.
2. 검증된 당첨번호를 Collections.sort()를 활용하여 오름차순 정렬하였습니다.

### 8. inputBonusNumber()
````
public static String inputBonusNumber(){
    System.out.println("보너스 번호를 입력해 주세요.");
    String inputBonusNumber = Console.readLine();
    return inputBonusNumber;
}
````
1. inputWinningNumberValidation() 메서드에서 보너스 번호를 입력받습니다.

### 9. inputBonusNumberValidation()
````
public static int inputBonusNumberValidation(String inputBonusNumber){
    try {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        return bonusNumber;
    }catch (NumberFormatException e){
        throw new IllegalArgumentException("[ERROR] 보너스 번호를 숫자로 입력해주세요.");
    }
}
````
1. inputBonusNumberValidation() 메서드에서 입력받은 보너스 번호가 숫자인지 검증합니다.


### 10. inputBonusNumberRangeValidation()
````
public static int inputBonusNumberRangeValidation(int inputBonusNumberValidation){
    if(inputBonusNumberValidation < 1 || inputBonusNumberValidation > 45){
        throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해 주세요.");
    }
    return inputBonusNumberValidation;
}
````
1. inputBonusNumberRangeValidation() 메서드에서 입력받은 보너스 번호가 1~45사이의 번호인지 검증합니다.

### 11. lottoWinningAmount()
````
public static int lottoWinningAmount(List<Integer> lotto ,List<Integer> winningNumber, int bonusNumber){
    int matchCount = 0;
    for(int i = 0 ; i < winningNumber.size() ; i++){
        if(lotto.contains(winningNumber.get(i))){
            matchCount++;
        }
    }

    if(matchCount == 3){
        return 5000;
    }
    if(matchCount == 4){
        return 50000;
    }
    if(matchCount == 5){
        if(lotto.contains(bonusNumber)){
            return 30000000;
        }
        return 1500000;
    }
    if(matchCount == 6){
        return 200000000;
    }
    return 0;
}
````
1. lottoWinningAmount() 메서드에서 로또의 당첨금액을 계산합니다.
2. lotto.contains()을 활용하여 winningNumber가 포함되어있는지 확인하고 포함되어있으면 matchCount를 증가시켜 몇개가 일치 하는 지 계산하였습니다.
3. 5개가 일치하는 로또에 추가로 lotto.contains(bonusNumber)을 활용하여 보너스번호가 일치하는지 확인하였습니다.

### 12. lottoWinningAmount()
````
public static void lottoWinningResult (List<Lotto> lottos ,List<Integer> winningNumber, int bonusNumber){
    int totalWinningAmount = 0;
    double totalReturnRate = 0.0;
    int lottoQuantity = lottos.size();
    double totalLottoPurchase = 1000 * lottoQuantity;

    int threeMatches = 0;
    int fourMatches = 0;
    int fiveMatches = 0;
    int fiveBonusMatches = 0;
    int sixMatches = 0;

    for (int quantity = 0 ; quantity < lottoQuantity ; quantity ++){

        int winningAmount = lottoWinningAmount(lottos.get(quantity).getNumbers(), winningNumber, bonusNumber);
        totalWinningAmount += winningAmount;

        if(winningAmount == 5000){
            threeMatches++;
        }

        if(winningAmount == 50000){
            fourMatches++;
        }

        if(winningAmount == 1500000){
            fiveMatches++;
        }

        if(winningAmount == 30000000){
            fiveBonusMatches++;
        }

        if(winningAmount == 200000000){
            sixMatches++;
        }

    }

    totalReturnRate = (totalWinningAmount/totalLottoPurchase)*100;
    String totalRate = String.format("%.1f",totalReturnRate);

    System.out.println("당첨 통계");
    System.out.println("---");
    System.out.println("3개 일치 (5,000원) - " + threeMatches+"개");
    System.out.println("4개 일치 (50,000원) - " + fourMatches+"개");
    System.out.println("5개 일치 (1,500,000원) - " + fiveMatches+"개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonusMatches+"개");
    System.out.println("6개 일치 (2,000,000,000원) - " + sixMatches+"개");
    System.out.println("총 수익률은 "+ totalRate +"%입니다.");
}
````
1. lottoWinningResult() 메서드에서 당첨 통계 총 수익률을 계산하여 사용자에게 보여줍니다.
2. lottoWinningAmount() 메서드를 활용하여 로또번호가 일치한 개수를 계산하였습니다.
3. (totalWinningAmount/totalLottoPurchase)*100 계산식을 사용하여 총 수익률을 계산하였고, String.format()을 활용하여 소수점 첫번째 자리까지 표시하였습니다.


---
## ✏️ 리펙터링
#### 검색의 도움을 받아 MVC 페턴을 적용하고, 객체지향 코드로 리펙터링하여 학습해 보았습니다.

