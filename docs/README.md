## 패키지 구조

<div>
<table>
    <tr>
        <th style="text-align: center;">📂 패 키 지</th>
        <th style="text-align: center;">✏️ 클 래 스</th>
        <th style="text-align: center;">📝 설 명</th>
    </tr>
    <tr>
        <td><b>🕹 Controller️</b></td>
        <td><b>📓 Game</b></td>
        <td>게임 로직을 메인으로 동작하는 컨트롤러 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="3"><b>🌤️ condition</b></td>
        <td><b>📙 LottoCondition</b></td>
        <td>로또 게임에 사용되는 조건을 설정하는 enum 클래스</td>
    </tr>
    <tr>
        <td><b>📙 Reward</b></td>
        <td>맞힌 개수별 가격을 설정하는 enum 클래스</td>
    </tr>
    <tr>
        <td><b>📙 Symbols</b></td>
        <td>로또 게임에 사용되는 기호를 설정하는 enum 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td><b>⌨️ console</b></td>
        <td><b>📗 Console</b></td>
        <td>게임 전역에 사용되는 입/출력 콘솔 모음</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="6"><b>🙍‍ domain</b></td>
        <td><b>📗 Answer</b></td>
        <td>당첨 번호를 저장하는 당첨번호 클래스</td>
    </tr>
    <tr>
        <td><b>📗 Lotto</b></td>
        <td>로또 번호 리스트를 가지는 로또 클래스</td>
    </tr>    
    <tr>
        <td><b>📗 Bonus</b></td>
        <td>중복을 검사한 보너스 번호를 가지는 클래스</td>
    </tr>
    <tr>
        <td><b>📗 Prize</b></td>
        <td>번호 일치 개수를 확인하여 당첨 금액을 반환하는 클래스</td>
    </tr>
    <tr>
        <td><b>📗 Profit</b></td>
        <td>수익률을 계산하여 반환하는 클래스</td>
    </tr>
    <tr>
        <td><b>📗 UserLotto</b></td>
        <td>사용자의 로또 번호를 저장하는 일급 컬렉션 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="6"><b>📭‍ dto</b></td>
        <td><b>📔 AnswerResponse</b></td>
        <td>당첨 번호를 정렬하여 전달하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b>📔 BonusResponse</b></td>
        <td>보너스 번호를 전달하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b>📔 LottoResponse</b></td>
        <td>로또 1장의 번호를 전달하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b>📔 LottoResponses</b></td>
        <td>구매한 모든 로또의 번호를 전달하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b>📔 ProfitResponse</b></td>
        <td>총 수익률을 전달하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b>📔 ResultResponse</b></td>
        <td>당첨 결과를 담은 Map을 전달하는 DTO 레코드</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b>🚧‍ exception</b></td>
        <td><b>📙 ErrorMessage</b></td>
        <td>(Enum)예외 발생 시 사용되는 에러 메시지 클래스</td>
    </tr>
    <tr>
        <td><b>⚡ LottoException</b></td>
        <td>에러를 관리하는 커스텀 예외</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b>✂️‍ parser</b></td>
        <td><b>📗 Parser</b></td>
        <td>입력을 형식에 맞게 파싱하는 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b>👨‍⚖️ validator</b></td>
        <td><b>📗 InputValidator</b></td>
        <td>입력 값에 대한 유효성 검사를 진행하는 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b>📺️ view</b></td>
        <td><b>📗 InputView</b></td>
        <td>입력을 담당하는 클래스</td>
    </tr>
    <tr>
        <td><b>📗 OutputView</b></td>
        <td>출력을 담당하는 클래스</td>
    </tr>
</table>
</div>

## 게임 진행

1. 로또 구입을 금액 입력을 받는다.
    - 파서를 이용해 구입 금액에 해당하는 로또 개수를 반환한다.
2. 번호를 입력 받는다.
    1. 당첨 번호를 입력 받는다.
       - 파서를 이용해 로또 배열을 저장한다.
       - 구매 개수만큼 반복해서 입력받는다.
    2. 보너스 번호를 입력 받는다.
       - 당첨 번호에 포함된 번호라면 예외를 발생시킨다.
4. 발행한 로또 수량 및 번호를 출력한다.
    - 출력은 오름차순으로 출력한다.
5. 당첨 내역을 출력한다.
    - 번호 일치 개수를 확인하여 일치 개수와 당첨 금액, 로또 개수를 출력한다.
6. 수익률은 소수점 둘째 자리에서 반올림한다.
7. 예외 상황 시 에러 문구를 출력해야 한다.
    - 잘못된 값 입력시 IllegalArgumentException을 발생시킨다.
    - "\[ERROR\]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
