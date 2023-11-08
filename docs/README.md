### 다이어 그램
<img src="https://github.com/OiKimiO/java-lotto-6/assets/53805469/23fbc637-b184-4390-9852-04a85ab00c5f" style="width:70%;" />

### 패키지 구조
<table>
    <thead>
        <tr>
            <th>Package</th>
            <th>SubPackage</th>
            <th>Class</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan="6">config</td>
            <td rowspan="2">exception</td>
            <td>ExceptionType</td>
            <td>에러 메시지들의 내용을 관리합니다.</td>
        </tr>
        <tr>
            <td>InputException</td>
            <td>입력 예외를 처리합니다.</td>
        </tr>
        <tr>
            <td rowspan="2">output</td>
            <td>MessageType</td>
            <td>모든 출력 메시지들의 내용을 관리합니다.</td>
        </tr>
        <tr>
            <td>OutputMessage</td>
            <td>출력 메시지들을 처리합니다.</td>
        </tr>
        <tr>
            <td rowspan="2">X</td>
            <td>AppConfig</td>
            <td>전반적인 실행에 있어 필수 의존성을 관리합니다.
                <br/>
                (<b>MVC는 싱글턴, 일부 필수 클래스(*)는 생성자로 관리</b>)
            </td>
        </tr>
        <tr>
            <td>LottoProcess</td>
            <td>로또 실행 절차를 가지고 있습니다.
                <br />
                (<b>AppConfig 생성자로 관리*</b>)
            </td>
        </tr>
        <tr>
            <td>controller</td>
            <td>X</td>
            <td>LottoController</td>
            <td>View의 요청을 받아 Domain, Model에게 행동을 지시합니다.</td>
        </tr>
        <tr>
            <td rowspan="9">domain</td>
            <td rowspan="2">constant</td>
            <td>LottoConstant</td>
            <td>도메인 중 상수로 처리되는 클래스의 모음입니다.</td>
        </tr>
        <tr>
            <td>PrizeAmount</td>
            <td>당첨 수익금을 관리합니다.
                <br />
                (<b>AppConfig 생성자로 관리*</b>)    
            </td>
        </tr>
        <tr>
            <td>util</td>
            <td>RandomNumber</td>
            <td>외부 랜덤 숫자를 관리합니다.</td>
        </tr>
        <tr>
            <td rowspan="6">X</td>
            <td>Lotto</td>
            <td>로또 당첨 번호를 관리합니다.</td>
        </tr>
        <tr>
            <td>LottoSet</td>
            <td>로또 당첨번호, 보너스 번호를 관리합니다.</td>
        </tr>
        <tr>
            <td>Returns</td>
            <td>로또 수익률을 관리합니다.</td>
        </tr>
        <tr>
            <td>Ticket</td>
            <td>로또 복권을 관리합니다.</td>
        </tr>
        <tr>
            <td>Tickets</td>
            <td>로또 복권들을 관리합니다.</td>
        </tr>
        <tr>
            <td>WinRecord</td>
            <td>당첨 내역을 관리합니다.</td>
        </tr>
        <tr>
            <td>model</td>
            <td>X</td>
            <td>LottoModel</td>
            <td>Domain 객체를 저장하거나 조회하는 역할을 합니다.</td>
        </tr>
        <tr>
            <td rowspan="4">view</td>
            <td rowspan="2">convert</td>
            <td>ConvertToInt</td>
            <td>String을 Int로 바꾸는 역할을 합니다.</td>
        </tr>
        <tr>
            <td>ConvertToList</td>
            <td>String을 List로 변환하는 역할을 합니다.</td>
        </tr>
        <tr>
            <td rowspan="2">X</td>
            <td>LottoBuyer</td>
            <td>로또 구매자의 입력 인터페이스를 관리합니다.</td>
        </tr>
        <tr>
            <td>LottoDrawer</td>
            <td>로또 추첨자의 입력 인터페이스를 관리합니다.</td>
        </tr>
    </tbody>
</table>

### 기능 구현 목록
1. 로또를 발행한다. 
```text
로또 번호의 숫자 범위: 1 ~ 45
로또 발행: 중복되지 않는 6개의 숫자 뽑기
```

2. 로또 당첨 번호를 뽑고, 담청 등수를 확인한다.
```text
로또 번호의 숫자 범위: 1 ~ 45
당첨 번호 뽑기: 중복되지 않은 숫자 6개 + 보너스 번호 1개
당첨 등수: 1~5등
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
```

3. 구입한 금액 만큼 로또를 발행한다.
```text
로또 1장 가격: 1,000원
```

4. 로또 구매자의 담청 내역과 수익률을 출력한다.
```text
사용자가 구매한 로또 번호와 추첨번호를 비교
```

5. 로또 티켓을 발행한다.
```text
로또 구매 횟수: 로또 구매 금액 / 1,000
 - 나누어 떨어지지 않는 경우 예외 처리
로또 티켓: 로또 구매 횟수만큼 발행
```

6. 담청 번호를 입력 받는다.
```text
로또 담청 번호: 번호를 쉼표(,) 기준으로 구분
보너스 번호: 7
```

7. 출력시 로또 번호는 오름차순으로 정렬해 보여준다.
```text
출력 예시:
3개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
``` 

8. 담청 내역을 출력한다.
```text
출력 예시:
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

9. 수익률은 소수점 둘째 자리에서 반올림한다.
```text
출력 예시: 총 수익률은 62.5%입니다.
```

10. 예외 상황시 에러 문구를 출력, 단 에러 문구는 `[ERROR]`로 시작해야 한다.
```text
출력 예시: [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

### 3차 과제 적용 
1. MVC 패턴 적용

    이번 3차 과제에선 MVC 패턴을 적용해보았습니다.

    제가 생각한 MVC 패턴은 각 역할을 맡고 있는 Model, View, Controller
    
     

<br />

2. 필수 의존성 관리 클래스

<br />

3. 도메인 최소 단위로

<br />

4. 메서드명은 15자 이하

<br />

5. Custom Exception 관리

<br />

6. 디미터 법칙 적용

<br />

7. 랜덤 숫자 클래스 분리

### 생각해보기
1. 또 다시 어려운 테스트.. ㅠㅜ

