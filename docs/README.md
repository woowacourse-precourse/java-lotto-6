#### 구현기능 목록
1. Lotto 구매
- 사용자로부터 구매 금액을 입력받아, 해당 금액에 따라 로또를 구매하는 기능
- 입력된 금액을 기반으로 여러 개의 로또 티켓을 생성
- 생성된 로또 티켓 반환
2. 당첨 번호 입력 및 결과 확인
- 사용자로부터 당첨 번호를 입력 받는 기능
- 사용자로부터 보너스 번호를 입력 받는 기능
- 입력된 당첨 번호와 보너스 번호를 기반으로, 구매한 로또 티켓과 비교하여 당첨 결과 계산
- 당첨 결과 반환
3. 게임 수익률 확인
- 구매한 로또 티켓 수를 기준으로 투자한 금액, 당첨금 등을 계산하여 수익률을 반환하능 기능
4. 예외 처리 및 오류메시지 출력
- 사용자 입력값에 대한 예외 처리 기능
- 입력한 값이 유효하지 않을 때 적절한 오류 메시지 출력
5. 로또 순위 확인
- 각 로또 티켓의 당첨결과를 기반으로 순위를 매기고, 당첨 결과를 표시하는 기능
---
#### 패키지 구조
```
├─main
│  └─java
│      └─lotto
│          ├─common         --- 상수 등이 포함된 패키지
│          ├─controller     --- 애플리케이션의 컨트롤러 클래스를 포함하는 패키지
│          ├─domain         --- 엔티티 클래스를 포함하는 패키지
│          ├─dto            --- 데이터 전송 객체를 포함하는 패키지
│          │  ├─request     --- 요청을 위한 DTO 클래스들이 포함된 패키지
│          │  └─response    --- 응답을 위한 DTO 클래스들이 포함된 패키지
│          ├─exception      --- 커스텀 예외클래스들을 포함하는 패키지
│          ├─service        --- 비즈니스 로직을 처리하는 서비스 클래스들이 포함된 패키지 
│          ├─utils          --- 유틸리티 클래스들이 포함된 패키지
│          └─view           --- 사용자 인터페이스와 관련된 뷰 클래스들이 포함된 패키지
└─test  --- 테스트 코드 관련 패키지
  └─java
    └─lotto
      ├─common
      ├─domain
      ├─service
      └─utils
```
---
<table>
    <thead>
        <tr>
            <th colspan="2">Package</th>
            <th>Class</th>
            <th colspan="2">Description</th>
        </tr>
    </thead>
<tbody>
    <tr>
        <td rowspan="3" colspan="2">common</td>
        <td>ErrorMessges</td>
        <td colspan="2">애플리케이션에서 사용되는 오류 메시지 상수를 포함합니다.</td>
    </tr>
    <tr>
        <td>InputOutputMessages</td>
        <td colspan="2">애플리케이션에서 사용되는 입력 및 출력 메시지 상수를 포함합니다.</td>
    </tr>
    <tr>
        <td>LottoRank</td>
        <td colspan="2">로또 순위를 표현하는 열거형입니다. 로또 게임의 다양한 순위를 포함합니다.(예: 1등, 2등 등..)</td>
    </tr>
    <tr>
        <td rowspan="3" colspan="2">domain</td>
        <td>Lotto</td>
        <td colspan="2">로또를 나타냅니다.</td>
    </tr>
    <tr>
        <td>LottoNumber</td>
        <td colspan="2">로또 번호를 나타냅니다. </td>
    </tr>
    <tr>
        <td>LottoPurchaseCost</td>
        <td colspan="2">로또 구매 비용을 나타냅니다.</td>
    </tr>
    <tr>
        <td colspan="2">controller</td>
        <td>LottoGame</td>
        <td colspan="2">게임의 흐름 제어 역할을 수행합니다.</td>
    </tr>
    <tr>
        <td rowspan="6">dto</td>
        <td rowspan="3">request</td>
        <td>LottoNumberRequest</td>
        <td colspan="2">로또 번호 요청을 나타냅니다.</td>
    </tr>
    <tr>
        <td>LottoPurchaseCostRequest</td>
        <td colspan="2">로또 구매 비용 요청을 나타냅니다.</td>
    </tr>
    <tr>
        <td>LottoRequest</td>
        <td colspan="2">로또 요청을 나타냅니다.</td>
    </tr>
    <tr>
        <td rowspan="3">response</td>
        <td>LottoBuyResponse</td>
        <td colspan="2">로또 구매 응답을 나타냅니다.</td>
    </tr>
    <tr>
        <td>LottoGameResultResponse</td>
        <td colspan="2">로또 게임 결과 응답을 나타냅니다.</td>
    </tr>
    <tr>
        <td>LottoResponse</td>
        <td colspan="2">로또 응답을 나타냅니다.</td>
    </tr>
    <tr>
        <td colspan="2">exception</td>
        <td>InputValidationException</td>
        <td colspan="2">입력 유효성 검사 예외를 나타냅니다.</td>
    </tr>
    <tr>
        <td rowspan="2" colspan="2">service</td>
        <td>LottoGameService</td>
        <td colspan="2">로또 게임 서비스를 나타냅니다.</td>
    </tr>
    <tr>
        <td>LottoGameServiceImpl</td>
        <td colspan="2">로또 게임 서비스 구현체로 게임의 비즈니스 로직, 세부적인 게임 규칙, 결과 계산등을 처리하는 역할을 수행합니다.</td>
    </tr>
    <tr>
        <td rowspan="2" colspan="2">utils</td>
        <td>LottoNumberGenerator</td>
        <td colspan="2">로또 번호 생성기를 나타냅니다.</td>
    </tr>
    <tr>
        <td>StringUtils</td>
        <td colspan="2">문자열 유틸리티를 나타냅니다.</td>
    </tr>
    <tr>
        <td colspan="2">view</td>
        <td>InputOutputView</td>
        <td colspan="2">사용자 입력/출력을 처리하는 역할을 수행합니다.</td>
    </tr>
</tbody>
</table>

---
### 프로세스 흐름 및 클래스 다이어그램
![diagram](../docs/diagram.png)
![diagram_kor](../docs/diagram_kor.png)
