# 미션 - 🍀 로또

---

## 💡 기능 요구 사항


### **핵심 알고리즘 및 구현할 기능**

- "구입금액을 입력해 주세요." 출력 후, 구입 금액 n(0<n<2,147,483,648)을 입력
- 로또 1장의 가격을 1000원으로 책정하고 해당 가격으로 살 수 있는 개수 정수 m을 구하고 "m개를 구매했습니다." 출력
    - 로또 1장 가격인 1000원으로 구입 금액 n이 나누어 떨어지지 않을 경우 최대한 살 수 있는 개수로 예외 처리한다.
- m개 만큼 로또 번호 숫자 6개를 각각 생성하여 "[숫자, 숫자, 숫자, 숫자, 숫자, 숫자]"형태의 오름차순으로 정렬해서 출력
- "당첨 번호를 입력해 주세요." 출력 후, "숫자,숫자,숫자,숫자,숫자,숫자"형태와 같이 사용자의 6개의 수를 쉼표로 구분하여 입력받음
- "보너스 번호를 입력해 주세요." 출력 후, 숫자를 입력받음
- 아래의 조건에 따라 1등부터 5등까지 당첨
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
    - 3등: 5개 번호 일치 / 1,500,000원
- 당첨 내역이 5등이 a개, 4등이 b개, 3등이 c개, 2등이 d개 1등이 e개일 경우 아래와 같이 출력
```
3개 일치 (5,000원) - a개
4개 일치 (50,000원) - b개
5개 일치 (1,500,000원) - c개
5개 일치, 보너스 볼 일치 (30,000,000원) - d개
6개 일치 (2,000,000,000원) - e개
```
- 수익률(소수점 둘째 자리에서 반올림) 을 계산하여 "총 수익률은 62.5%입니다."의 형태로 출력
- 예외 처리 사항(View와 Domain을 따로 검증할 예정, 아래 매직 넘버들은 enum을 통해 상수로 관리될 것이다.)
  - 금액을 입력할 경우
    - (View) 공백 혹은 빈 문자열 입력 시, IllegalArgumentException 발생시키고 "[ERROR] 공백 혹은 빈 문자열을 입력하였습니다." 출력 후 입력 다시 받음
    - (View) 널 입력 시, IllegalArgumentException 발생시키고 "[ERROR] Null을 입력하였습니다." 출력 후 입력 다시 받음
    - (View) 숫자가 아닌 것을 입력할 경우, IllegalArgumentException 발생시키고 "[ERROR] int 범위 안의 숫자를 입력해주세요" 출력 후 입력 다시 받음
    - (Domain) 음수를 입력할 경우, IllegalArgumentException 발생시키고 "[ERROR] 음수가 입력되었습니다." 출력 후 입력 다시 받음
  - 당첨 번호 혹은 보너스 번호를 입력할 경우
    - 공통 부분
      - (View) 공백 혹은 빈 문자열 입력 시, IllegalArgumentException 발생시키고 "[ERROR] 공백 혹은 빈 문자열을 입력하였습니다." 출력 후 입력 다시 받음
      - (View) 널 입력 시, IllegalArgumentException 발생시키고 "[ERROR] Null을 입력하였습니다." 출력 후 입력 다시 받음
      - (View) 숫자가 아닌 것을 입력할 경우, IllegalArgumentException 발생시키고 "[ERROR] int 범위 안의 숫자를 입력해주세요" 출력 후 입력 다시 받음
      - (Domain) 1이상 45이상인 숫자를 입력하지 않을 경우, IllegalArgumentException 발생시키고 "[ERROR] 주어진 수는 1이상 45이하가 아닙니다" 출력 후 입력 다시 받음
      - (Domain) 중복된 번호가 입력될 경우, IllegalArgumentException 발생시키고 "[ERROR] 수가 중복되었습니다." 출력 후 입력 다시 받음
    - 당첨 번호
      - (Domain) 딩첨 번호들의 개수가 6이 아닌 경우, IllegalArgumentException 발생시키고 "[ERROR] 주어진 당첨 번호의 개수는 6개가 아닙니다." 출력 후 입력 다시 받음
    - 보너스 번호
      - (Domain) 보너스 번호들의 개수가 1이 아닌 경우, IllegalArgumentException 발생시키고 "[ERROR] 주어진 보너스 번호의 개수는 1개가 아닙니다." 출력 후 입력 다시 받음

## 개발 전략

이전의 프로젝트에서 TDD와 BDD를 사용해보았다.

해당 방법들을 모두 사용해본 결과 TDD와 달리 BDD는 테스트를 덜 해도되고 설계시 모순점이 무엇인지를 발견할 수 있는 장점이 있었다.

하지만 해당 프로젝트의 목적은 서비스 구현보다 학습에 가깝고, 특히 테스트 학습에 의의가 있기 때문에 시간이 더 걸리는 TDD를 선택하였다.

이전 프로젝트에서 TDD를 적용했을 때의 문제점이었던 코드 수정 리스크를 보완하고자 기능 요구사항을 보다 세밀하게 작성하였다.

그리고 domain과 view 영역으로 나눠 진행할 예정이다.

### 도메인 소개

> domain
> 1. BonusNumbers extends UserNumbers
>    - 보너스 번호 객체
> 2. Lotto
>    - 로또 하나의 번호 객체
> 3. LottoCompany 
>    - 당첨 번호 객체(WinningNumbers)와 보너스 번호 객체(BonusNumbers)를 갖는 객체 
> 4. SiteUser
>    - 유저가 갖고있는 금액 객체(UserMoney)와 유저가 산 로또들의 객체(UserLotto)를 갖는 객체
> 5. UserLotto
>    - 구매 가능한 랜덤한 로또들의 객체
> 6. UserMoney
>    - 유저가 갖고있는 금액 객체
> 7. UserNumbers
>    - 보너스 번호와 당첨 번호의 공통 부분을 상속해주기 위한 객체
> 8. WinningNumbers extends UserNumbers
>    - 당첨 번호 객체
> 9. WinningStatistics
>    - 당첨 통계를 갖는 객체

사용자가 입력한 것들을 SiteUser와 LottoCompany 객체를 통해 관리할 것이다.

SiteUser에서 UserMoney와 UserLotto를 두어 금액과 랜덤 로또 번호들을 관리할 것이다.

LottoCompany에서 WinningNumbers와 BonusNumbers를 두어 당첨 번호와 보너스 번호를 관리할 것이다.

당첨 번호와 보너스 번호의 공통 부분을 다루기 위해 UserNumbers 클래스를 상속하여 할 것이다.

관련 내용은 코드를 보면 이해하기 쉽다.

또한, 이번 프로젝트의 프로그래밍 요구사항에도 보듯이 Eum을 사용할 것이다.

## Enum 적용 부분

> Enum 사용 부분
> 1. ConstantNum
> 2. ErrorMessage
> 3. Rank
> 4. InputView

1번과 3번까지는 아래와 같이 단순하게 필드를 설정하여 상수를 관리하기 위해 사용하였다.

```java
public enum Rank {
    FIFTH("3개 일치 (5,000원)",5000),
    FOURTH("4개 일치 (50,000원)",50000),
    THIRD("5개 일치 (1,500,000원)",1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    FIRST("6개 일치 (2,000,000,000원)", 2000000000);

    private String desc;
    private int reward;

    Rank(String desc, int reward) {
        this.desc = desc;
        this.reward = reward;
    }

    public String getDesc() {
        return desc;
    }

    public int getReward() {
        return reward;
    }
}
```

하지만, 4번의 InputView에서는 다르게 적용해보았다. enum은 고정된 상수 값이 설정된 데이터 유형이기 떄문에 다른 클래스에 상속하거나 상속받을 수 없다.

그럼으로 인터페이스를 사용해서 확장해보았다.

해당 방법을 통해 상수를 전달해주는 것을 넘어서 높은 확장성을 갖으면서 enum기능을 사용할 수 있음에 유익하였다.

```java
public enum InputView implements CustomView<Object>{
    INPUT_MONEY{
        @Override
        public Integer activateView() {
            System.out.println("구입금액을 입력해 주세요.");
            return InputUtil.enterMoneyWhileVerifying();
        }
    },
    INPUT_WINNING_NUMBER{
        @Override
        public List<Integer> activateView() {
            System.out.println("당첨 번호를 입력해 주세요.");
            return InputUtil.enterNumbersWhileVerifying();
        }
    },
    INPUT_BONUS_NUMBER {
        @Override
        public List<Integer> activateView() {
            System.out.println("보너스 번호를 입력해 주세요.");
            return InputUtil.enterNumbersWhileVerifying();
        }
    }
}
```

```java
package lotto.view;

public interface CustomView<T> {
    T activateView();
}
```

## 확장성

이번 프로젝트에서는 코드를 확장성있게 작성해보았다.

보너스 번호와 당첨 번호의 검증 부분은 공통된 검증 부분이 존재하여 아래와 같이 상속을 통해 관계성과 독립성을 높혔다.

```java
public class UserNumbers {
    private List<Integer> numbers;

    public UserNumbers(List<Integer> numbers) {
        this.numbers = inputNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> inputNumbers(List<Integer> numbers) {
        try {
            validate(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputNumbers(InputUtil.enterNumbersWhileVerifying());
        }
    }

    protected void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            DomainValidate.validateNumberInRange(number);
        }
        DomainValidate.validateDuplicated(numbers);
    }
}
```

```java
public class BonusNumbers extends UserNumbers {
    public BonusNumbers(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    protected void validate(List<Integer> numbers) {
        super.validate(numbers);
        DomainValidate.validateNumberOfBonus(numbers);
    }
}
```

```java
public class WinningNumbers extends UserNumbers {

    public WinningNumbers(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    protected void validate(List<Integer> numbers) {
        super.validate(numbers);
        DomainValidate.validateNumberOfWinningNumbers(numbers);
    }
}
```

## 정적 팩토리 메서드 적극 사용

객체를 만들 때, 생성자로 만드는 것보다 정적 팩토리 메서드를 사용해보았다.

생성자와 달리 이름을 갖을 수 있고, 유연한 설계가 가능하고 메모리도 덜 사용해서 유용하였다.

하지만, 상속이 불가능하고 테스트하기 어려운 부분떄문에 어려웠다. 하지만 적절히 사용한다면 코드의 질이 높아질 것 같다.

아래는 정적 팩토리 메서드를 사용했을 경우의 예제이다.

```java
public class UserLotto {
    private List<Lotto> lottoTickets;

    private UserLotto(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public static UserLotto makeRandomLotto(int cnt) {
        List<Lotto> randomLottoTickets = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            randomLottoTickets.add(new Lotto(makeRandomNumbers()));
        }
        return new UserLotto(randomLottoTickets);
    }

    private static List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
```

## 유틸 및 검증에 대한 고민

View와 Domain은 가능한 엮이지 않는 것이 좋다.

그런데, "검증을 하는데 있어서 두 영역에 어떻게 적용해야할까"라는 생각을 해보았다.

한쪽만 진행하면 분명 다른 방법으로 인해 다른 쪽이 무너질수 있기 떄문이다.

그럼으로 View에서는 간략한 검증을 진행하고 Domain에서는 세밀한 검증을 진행하고자 하였다.

그럼으로 View영역에 적용할 검증 코드와 Domain에 적용할 검증 코드로 나눠 중복을 피하였다.

그리고 객체를 만들 필요가 없어 유틸 메서드로 작성하였다.

아래는 해당 부분을 보여주는 코드이다.

```java
public class ViewValidate {
    private ViewValidate() {
    }

    public static void validateNotSpaceOrEmpty(String content) {
        if (content.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.SPACE_OR_EMPTY.getMessage());
        }
    }

    public static void validateNotNull(String content) {
        if (content == null) {
            throw new NullPointerException(ErrorMessage.NULL.getMessage());
        }
    }

    public static int validateAndConvertString2Int(String content) {
        try {
            return Integer.parseInt(content);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.STRING_IS_NOT_INT.getMessage());
        }
    }
}
```

```java
public class DomainValidate {
    private DomainValidate() {
    }

    public static void validateNumberInRange(int num) {
        if (num < ConstantNum.LOTTO_NUMBER_MIN.getNum() || num > ConstantNum.LOTTO_NUMBER_MAX.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }

    public static void validateNumberOfWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != ConstantNum.WINNING_NUMBER_CNT.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_WINNING_NUMBERS.getMessage());
        }
    }

    public static void validateNumberOfBonus(List<Integer> bonus) {
        if (bonus.size() != ConstantNum.LOTTO_BONUS_NUMBER_CNT.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_BONUS.getMessage());
        }
    }

    public static void validateNegativeMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NEGATIVE_NUMBER.getMessage());
        }
    }

    public static void validateDuplicated(List<Integer> numbers) {
        Set<Integer> result = new HashSet<>();
        for (Integer number : numbers) {
            result.add(number);
        }
        if (result.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }
}
```

## 다이어그램

![img.png](img.png)
---
## 👓 프로그래밍 요구 사항 정리

- 실행 환경 : JDK 17
- build.gradle 변경 및 외부 라이브러리 사용 불가
- Java 코드 컨벤션 가이드 준수
    - 들여쓰기 : +4 스페이스
    - 들여쓰기 지속 : 최소 +8 스페이스
    - 최대 열 : 120
- System.exit() 사용 금지, ApplicationTest 성공 필수
- 요구사항에서 달리 명시하지 않는 파일, 패키지 이름 수정 혹은 이동 불가
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다
- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- `numbers`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- `Lotto`의 패키지 변경은 가능하다.

---

## 💻 과제 진행 요구 사항

- 미션은 [java-lotto-6](https://github.com/woowacourse-precourse/java-lotto-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
