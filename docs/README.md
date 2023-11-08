<div align="center">

# 로또 미션 🎰
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/><br>

</div>

## 👩🏻‍💻 구현할 기능 목록
1. 로또 구입 금액을 입력 받는다. (View) <br><br>
2. 구입 금액에 해당하는 만큼 로또를 발행한다. (Service) <br>
   ✦ 로또 1장의 가격은 1,000원이다. <br>
   ✦ 로또 번호의 숫자 범위는 1~45까지이다. <br>
   ✦ 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.<br><br>
3. 발행한 로또 수량 및 번호를 출력한다. (View) <br>
   ✦ 로또 번호는 오름차순으로 정렬한다. <br><br>
4. 당첨 번호를 입력 받는다. (View) <br>
   ✦ 번호는 쉼표(,)를 기준으로 구분한다. <br><br>
5. 보너스 번호를 입력 받는다. (View) <br><br>
6. 당첨 내역을 계산한다. (Service) <br>
   ✦ `1등`: 6개 번호 일치 / 2,000,000,000원 <br>
   ✦ `2등`: 5개 번호 + 보너스 번호 일치 / 30,000,000원 <br>
   ✦ `3등`: 5개 번호 일치 / 1,500,000원 <br>
   ✦ `4등`: 4개 번호 일치 / 50,000원 <br>
   ✦ `5등`: 3개 번호 일치 / 5,000원 <br><br>
7. 당첨 내역을 출력한다. (View) <br><br>
8. 수익률을 계산한다. (Service) <br><br>
9. 수익률을 출력한다. (View) <br><br>

## 🚨 예외 처리
사용자가 잘못된 값을 입력할 경우 `Exception`를 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
1. 모든 입력 값은 대응되는 자료형(`Integer`)으로 변환 가능해야 한다.<br><br>
2. 로또 구입 금액은 1,000원으로 나누어 떨어져야 한다.<br><br>
3. 당첨 번호와 보너스 번호는 1부터 45까지의 중복되지 않는 수이다.<br><br>
4. 당첨 번호와 보너스 번호 사이에더 중복되는 수가 있어서는 안된다.<br><br>
5. 당첨 번호는 ',' 기준으로 분리되지만, 양옆 공백은 무시된다.<br><br>
   `예시`
      ```
      1️⃣ 1, 2, 3, 4, 5, 6
      2️⃣ 1 , 2, 3, 4 ,5, 6  
      ```
<br>

## 🏛️ 프로젝트 패키지 구조
### ✦ Domain <br><br>
`Lotto` <br><br>
로또의 6자리 번호를 가진다. 당첨 번호와 발행 받은 로또 번호 모두 이 도메인이다.<br><br>

`LottoTicketMachine` <br><br>
로또발권기이다. 로또를 구입 PurchaseNumber 만큼 발행한다.<br><br>

`PurchaseNumber`<br><br>
구입한 로또의 개수이다. 금액으로부터 계산된다.<br><br>

`IssuedLottos`<br><br>
구입한 개수만큼 발행된 로또들이다. 이 로또들 각각 당첨번호와의 비교를 통해 등수가 결정된다.<br><br>

`BonusNumber`<br><br>
입력 받은 보너스 번호이다.<br><br>

`Rank`<br><br>
로또 당첨 등수를 관리하고 일치 개수를 통해 등수를 산출한다.<br><br>

`WinningRanks`<br><br>
발행된 로또의 등수를 산정한 결과이다.<br><br>

`Profit`<br><br>
수익률을 계산한다.<br><br>

### ✦ Controller <br><br>
`LottoController`<br><br>
`View`와 `Domain`을 관리하여 프로그램을 제어한다. <br><br>

### ✦ Value Object <br>
요청과 응답을 주고 받을 때 쓰이는 값 객체로 입•출력 형식을 담당하고 유효한 값으로 변환한다.<br><br>

`BonusNumberRequest` : 보너스 번호 입력 요청<br>

`PurchaseAmountRequest` : 구매 금액 입력 요청<br>

`WinningNumberRequest` : 당첨 번호 입력 요청<br><br>

`LottoResponse`: 발행된 로또 번호 출력 응답<br>

`WinningResponse` : 당첨 결과 출력 응답<br>

`ProfitResponse` : 수익률 출력 응답<br><br>

### ✦ Utility <br><br>
#### Validation
여러 도메인 클래스의 `validation` 을 담당하는 클래스들이다.<br><br>

`LottoNumberChecker`<br><br>
로또 번호의 유효성을 검사한다.<br><br>

`WinningNumberChecker`<br><br>
당첨 번호와 보너스 번호 간의 중복을 검사한다.<br><br>
#### IO
입•출력 도구이다.

## 📩 커밋 메세지
아래와 같은 형식을 지킨다.
```
유형(범위): 제목

- WHY: 사용한 이유
- ISSUE: 고민한 부분
```
1. **유형**: 커밋의 유형이다. <br><br>
2. **범위**: 변경된 부분이다. 주로 메서드명과 클래스명이다.<br><br>
3. **제목**: 커밋 사항의 핵심 내용이다.<br><br>
4. **내용**:
   1. **WHY**: 해당 구현 방식을 사용한 이유이다.
   2. **ISSUE**: 추가적으로 고민한 부분이다.

## 📑 로그
1. **첫 번째 구현 (2023.11.4)** <br><br>
   1. 도메인 중심의 개발을 계획한다. <br>
   이번 미션에서는 객체를 분리하고 도메인에 집중하기 위해 프로젝트의 계층보다 객체를 중점적으로 생각하며 설계하기로 했다. <br><br>
      ✦ 지난 미션들처럼 레포지토리를 사용하지 않고 도메인 자체에 집중한다. 도메인 만으로 데이터를 저장하고 관련 기능을 수행한다.<br>
      ✦ 도메인 계층부터 개발하고 단위 테스트를 진행한다.<br>
      ✦ 해당 도메인에 책임이 있는 것이 확실하다면, 서비스 계층 말고 도메인에 서비스 로직을 작성한다.<br><br>
   2. 입력값을 검증 및 변환하는 클래스를 도입한다. <br>
   프로그램이 콘솔에서 입력을 받기에 입력값은 모두 `String` 이다. 이를 `List` 나 `Integer` 와 같은 올바른 자료형으로 변환하는 클래스를 사용한다.<br><br>
      ✦ `View` 와 `Domain` 로직을 확실히 분리할 수 있다. 예를 들어 6자리의 로또 당첨 번호를 입력 받았다면, 이를 `List<Integer>`로 변환하면서 정수가 아닌 값은 `View` 에서 예외 처리하고(즉, 입력 자체가 잘못됨) '서로 다른 6개의 숫자가 아니다'라는 로또 번호만의 특징은 `Domain` 에서 예외 처리한다.<br>
      ✦ 도메인에 더 집중할 수 있다. <br>