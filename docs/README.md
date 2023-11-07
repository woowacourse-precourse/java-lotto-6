# 미션 - 로또

## 🚀 기능
[x] 로또 구입 금액을 입력(로또 1장의 가격은 1,000원이다. / 1,000원 단위로 입력받는다.)
    [x] 예외 처리 Price#checkCondition
        - 1,000원으로 나누어 떨어지지 않는 경우 예외처리
    [x] 로또 수량 계산 //Price#calculateAmount 
    
[x] 발행한 로또 수량 및 번호를 출력
    [x] 로또 발행 //Create#createRandomNumbers
        [x] 로또 수량만큼  //Create#createLottos
    [x] 로또 번호는 오름차순으로 정렬     //Create#sortLottos
    [x] 로또 수량 및 번호 출력    //Lotto#printLottos

[x] 당첨 번호(,기준)와 보너스 번호를 입력   //Lotto#askNumbers
    [x] 예외처리 //Lotto#readNumbers
      [x] 입력 수 에러 
      [x] 1~45 사이의 숫자가 아닌 경우  
      [x] 중복 숫자가 존재하는 경우

[x] 사용자가 구매한 로또 번호와 당첨 번호를 비교
    [x] 3, 4, 5, 5 + 보너스 볼, 6개 일치 중 일치하는 개수 확인   //Lotto#compareTo
    [x] 수익률 계산 (소수점 둘째 자리에서 반올림) //Calculation#calculate

[x] 당첨 내역 및 수익률을 출력 Ranks#printResult 

```
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

### 추가된 요구 사항
[x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.
[x] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
[x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
[x] else 예약어를 쓰지 않는다. (switch/case도 X)
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
[x] Java Enum을 적용한다.
[] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
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

