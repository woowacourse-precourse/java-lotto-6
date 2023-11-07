# 🚀 기능 요구 사항    


## ❗ 목표 : 로또 게임 기능을 구현 하기

## 🗨️ 실행 결과예시
```java
part 1
        구입금액을 입력해 주세요.
        8000

        8개를 구매했습니다.
        
part 2
        [8, 21, 23, 41, 42, 43]
        [3, 5, 11, 16, 32, 38]
        [7, 11, 16, 35, 36, 44]
        [13, 14, 16, 38, 42, 45]
        [7, 11, 30, 40, 42, 43]
        [1, 8, 11, 31, 41, 42]
        [2, 13, 22, 32, 38, 45]
        [1, 3, 5, 14, 22, 45]
        
part 3
        당첨 번호를 입력해 주세요.
        1,2,3,4,5,6

        보너스 번호를 입력해 주세요.
        7
        
part 4
        당첨 통계
        ---
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        5개 일치 (1,500,000원) - 0개
        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        6개 일치 (2,000,000,000원) - 0개
        총 수익률은 62.5%입니다.

```

## 🎯 프로그래밍 요구 사항
```java
1. JDK 17 버전에서 실행 가능해야 한다. JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.
2. 프로그램 실행의 시작점은 Application의 main()이다.
3. build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
4. Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
5. 프로그램 종료 시 System.exit()를 호출하지 않는다.
6. 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
7. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
8. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
9. 3항 연산자를 쓰지 않는다.
10. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
11. JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
```



## 🤦‍♂ ️추가된 요구 사항

```java
1. 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
2. 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
3. else 예약어를 쓰지 않는다.
힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
4. Java Enum을 적용한다.
5. 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
6. 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
7. 단위 테스트 작성이 익숙하지 않다면 test/java/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.
```
## 🌐 라이브러리 
```java
1. camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
2. Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
```
```java
                                        ❗사용예시 
                List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
```



## 🧐 Lotto 클래스
```java
1. 제공된 Lotto 클래스를 활용해 구현해야 한다.
2. numbers의 접근 제어자인 private을 변경할 수 없다.
3. Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
4. Lotto의 패키지 변경은 가능하다.
```

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



## ⛏️ 구현할 기능 목록

- [ ] 로또 구입 
    -  로또 번호는 오름 차순 으로 정렬 해야 한다.
    -  로또 1장 가격은 1000원 (1000원 단위 로 구입 가능).
- [ ] 로또 발행
    - 로또 구입후 구입한 가격 만큼 로또 발행.
- [ ] 당첨 번호 입력 받기(,를 기준 으로 구분 하기).
- [ ] 보너스 번호를 입력 받기
- [ ] 당첨 내역 출력하기.
    - Enum 을 이용 하여 Rank 만들기. 
    - 수익률 은 소수점 둘째 자리 에서 반 올림 하기 (ex. 100.0%, 51.5%, 1,000,000.0%)




## 🤬 에러 출력
    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - 에러메세지 앞에는 [ERROR]를 붙혀서 출력해야한다.

- [ ] [ERROR] 로또 구입 금액은 1000원 단위 입니다.
- [ ] [ERROR] 당첨 번호는 번호는 쉼표(,)로 구분 하여 입력 해야 합니다.
- [ ] [ERROR] 당첨 번호는 숫자만 입력 가능 합니다.
- [ ] [ERROR] 당첨 번호에 중복된 번호를 입력할 수 없습니다.
- [ ] [ERROR] 보너스 번호는 숫자만 입력 가능 합니다.
- [ ] [ERROR] 보너스 번호는 한자리 숫자 입니다.
- [ ] [ERROR] 로또 번호는 1부터 45 사이의 숫자 여야 합니다.
- [ ] [ERROR] 로또 번호는 중복이 나오지 않아야 합니다.








