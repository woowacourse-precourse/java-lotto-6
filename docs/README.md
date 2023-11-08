# 프리코스 3주차 미션 - 💵로또😊

## 패키지 의존 다이어그램

---

![패키지_다이어그램.png](images%2F%ED%8C%A8%ED%82%A4%EC%A7%80_%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8.png)

## 클래스 구조

---

<table style=" margin-left: auto; margin-right: auto;">
<tbody>
<tr style="height: 29px;">
<td style="width: 161px; height: 29px;">패키지</td>
<td style="width: 198.992px; height: 29px;">클래스</td>
<td style="width: 452.008px; height: 29px;">설명</td>
</tr>
<tr style="height: 29px;">
<td style="width: 161px; height: 17.5px;">controller</td>
<td style="width: 198.992px; height: 17.5px;">SystemController</td>
<td style="width: 452.008px; height: 17.5px;">도메인과 뷰를 연결시켜 주는 역할 수행</td>
</tr>
<tr style="height: 29px;">
<td style="width: 161px; height: 232px;" rowspan="8">domain</td>
<td style="width: 198.992px; height: 29px;">Ball</td>
<td style="width: 452.008px; height: 29px;">공의 번호를 멤버 변수로 갖는 클래스, 스스로 값을 검증한다&nbsp;</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">Lotto</td>
<td style="width: 452.008px; height: 29px;">
<p>Ball 리스트를 멤버 변수로 갖는 일급 컬렉션, 스스로 값을 검증한다</p>
<p>당첨 번호에 포함되는 숫자 개수, 보너스 번호 포함여부를 판별하는 기능을 가짐</p>
</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">MatchResult</td>
<td style="width: 452.008px; height: 29px;">번호 일치 개수와 보너스 번호 일치 여부는 멤버 변수로 갖는 클래스</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">Money</td>
<td style="width: 452.008px; height: 29px;">
<p>구입금액을 멤버 변수로 갖는 클래스, 스스로 값을 검증한다</p>
<p>구입한 로또 개수를 반환하는 기능, 총 수익률을 계산하는 기능을 가짐</p>
</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">PurchasedLottos</td>
<td style="width: 452.008px; height: 29px;">로또 리스트를 멤버 변수로 갖는 일급 컬렉션</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">WinningNumbersWithBonus</td>
<td style="width: 452.008px; height: 29px;">
<p>당첨 번호(Lotto)와 보너스 번호(Ball)를 갖는 클래스</p>
<p>메서드 파라미터를 줄이기 위해 만들었으며 DTO와 유사한 역할을 한다&nbsp;</p>
</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">WinningStat</td>
<td style="width: 452.008px; height: 29px;">
<p>등수 상수(LottoRankConstant)와 당첨 횟수 멤버변수를 갖는 클래스</p>
<p>등수별 당첨금을 계산하는 기능을 가짐</p>
</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">WinningStats</td>
<td style="width: 452.008px; height: 29px;">
<p>WinningStat 리스트를 멤버 변수로 갖는 클래스</p>
<p>생성될 때&nbsp;PurchasedLottos와&nbsp;WinningNumbersWithBonus를 입력받아 등수별로 당첨된 횟수를 기록한다</p>
<p>총 당첨금을 계산하는 기능을 가짐</p>
</td>
</tr>
<tr style="height: 29px;">
<td style="width: 161px; height: 17.5px;" rowspan="6">system</td>
<td style="width: 198.992px; height: 29px;">ExceptionMessage</td>
<td style="width: 452.008px; height: 29px;">
<p>예외 메시지를 상수로 저장해둔 enum</p>
<p>호출할 때 [ERROR]를 조립해서 반환한다</p>
</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">LottoNumberConstant</td>
<td style="width: 452.008px; height: 29px;">공 번호 범위, 번호 개수 상수를 저장해둔 enum</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">LottoRankConstant</td>
<td style="width: 452.008px; height: 29px;">
<p>등수와 관련된 데이터 상수를 저장해둔 enum</p>
<p>생성될 때 메시지를 조립해서 저장함</p>
<p>등수로 상수를 찾는 기능</p>
</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">RegexConstant</td>
<td style="width: 452.008px; height: 29px;">정규식, 문자열 패턴을 저장해둔 enum</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">SystemConstant</td>
<td style="width: 452.008px; height: 29px;">범용 상수를 저장해둔 enum</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">SystemMessage</td>
<td style="width: 452.008px; height: 29px;">입출력 상수를 저장해둔 enum</td>
</tr>
<tr style="height: 29px;">
<td style="width: 161px; height: 17.5px;" rowspan="2">view</td>
<td style="width: 198.992px; height: 29px;">InputView</td>
<td style="width: 452.008px; height: 29px;">사용자 입력을 자료형 별로 받고 검증하고 반환하는 클래스</td>
</tr>
<tr style="height: 29px;">
<td style="width: 198.992px; height: 29px;">OutputView</td>
<td style="width: 452.008px; height: 29px;">시스템 메시지, 예외 메시지, 요구사항에 맞는 통계 결과를 콘솔로 출력하는 클래스</td>
</tr>
<tr style="height: 29px;">
<td style="width: 161px; height: 17.5px;">&nbsp;</td>
<td style="width: 198.992px; height: 29px;">Application</td>
<td style="width: 452.008px; height: 29px;">
<p>SystemController 객체를 만들어서 결과를 받아오는 클래스</p>
<p>IllegalstateException이 발생하면 메시지를 출력하고 프로그램을 종료시킨다</p>
</td>
</tr>
</tbody>
</table>

# ✏️기능 목록

---

## 입력

- [x] 로또 구입 금액을 입력받는 기능
- [x] 당첨 번호를 입력받는 기능
- [x] 보너스 번호를 입력받는 기능

## 출력

- [x] 발행한 로또 수량 및 번호를 오름차순으로 보여주는 기능
- [x] 당첨 통계를 출력하는 기능
- [x] 수익률을 소수점 둘째 자리에서 반올림 하여 보여주는 기능
- [x] 예외문구를 출력하는 기능

## 도메인

- [x] 로또 구입 금액
    - [x] 1000으로 나누어 떨어지지 않을 경우 예외처리
    - [x] 한 장도 사지 못할 경우 예외처리 (0)
    - [x] 총 수익률을 계산하는 기능
- [x] 보너스 번호
- [x] Lotto
    - [x] 번호가 6개가 아닐 경우 예외처리
    - [x] 중복되는 번호에 대한 예외처리
    - [x] 중복되지 않는 번호 조합을 랜덤 생성하는 기능 (pickUniqueNumbersInRange())
- [x] 구입한 로또 목록
    - [x] 구입 금액 / 1000 만큼 Lotto를 생성하고 저장하는 기능

- [x] 로또 등수별 당첨 횟수
    - [x] 구입한 로또 목록과 당첨 번호를 받아서 등수별 당첨 회수를 기록하는 기능

## 예외처리

- [x] 1~45 범위를 벗어난 숫자에 대한 예외처리

- [x] 숫자가 아닌 입력에 대한 예외처리

- [x] 입력이 없는 경우 예외처리 후 종료

## 상수

- [x] 로또 번호 관련 상수 (범위, 개수)
- [x] 등수 관련 상수 (등수별 조건과 금액)
- [x] 예외 메시지 상수
- [x] 시스템 상수 (로또 가격)
- [x] 시스템 메시지 상수
- [x] 정규식 상수

# 👆3주차 미션 특기할 요구사항

---

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.


- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.


- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.


- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 test/java/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.


- Lotto 클래스
    - 제공된 Lotto 클래스를 활용해 구현해야 한다.
    - numbers의 접근 제어자인 private을 변경할 수 없다.
    - Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
    - Lotto의 패키지 변경은 가능하다.

# 😀 2 주차 반성📕

---

- 2 주차에서는 controller나 service에서 대부분의 로직을 수행했다. 하지만 이를 객체지향적으로 올바른 코드라고
  볼 수 있을까? 이번에는 도메인에서 대부분 수행하기로 결정했다.🤗
    - 또한 도메인에서 로직을 처리하기 때문에 getter를 사용할 일이 적다.


- 2 주차에서는 유효성 검사를 하는 클래스를 따로 만들어서 입력에 대한 유효성 검사를 수행핬다.
  이 또한 객체지향의 장점을 충분히 살리지 못한 방식이다. 가능한 한 유효성 검증 또한 도메인에서 진행하고
  코드가 중복되는 경우에 외부 클래스를 만든다.🥰
    - 추가) 코드가 중복될 일이 없었고 외부 클래스를 만들지 않았다!


- 생성자에서 여러가지 메서드를 불러오고 온갖 처리를 했었는데 이는 생성자의 역할에서 한참 벗어났다.
  생성자는 할당과 검증만 한다. 😊


- 생성자를 다른 클래스에서 그냥 사용했었는데 이 방법보다는 생성자를 private로 하고 정적 팩토리 메서드를 사용하여
  객체를 생성하자. 🫡
    - 추가) 정적 팩토리 메서드를 사용하니 코드를 이해하기 더 쉬워졌고 테스트도 용이했다.


- parseInt대신에 Pattern 클래스의 정규 표현식을 이용해서 유효성 검사를 하자. 💪