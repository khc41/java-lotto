package calculator;

import calculator.enums.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("입력받은 문자열이 비정상일 떄, exception을 발생시킨다.")
    void 문자열_계산_연산식_exception() {
        assertThatThrownBy(() -> StringCalculator.getInstance().calculate("2 + 3 * 4 /"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("입력받은 문자열이 정상일 떄, 연산한 값을 출력한다.")
    void 문자열_계산() {
        assertThat(StringCalculator.getInstance().calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("연산자가 아닌 문자는 exception 발생")
    void 연산자가_아닌_문자() {
        assertThatThrownBy(() -> StringCalculator.getInstance().calculate(10, 5, Operator.from("_")))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("나눗셈을 연산한다.")
    void 나눗셈() {
        assertThat(StringCalculator.getInstance().calculate(10, 5, Operator.from("/"))).isEqualTo(2);
    }


    @Test
    @DisplayName("곱셈을 연산한다.")
    void 곱셈() {
        assertThat(StringCalculator.getInstance().calculate(3, 5, Operator.from("*"))).isEqualTo(15);
    }

    @Test
    @DisplayName("뺄셈을 연산한다.")
    void 뺄셈() {
        assertThat(StringCalculator.getInstance().calculate(3, 5, Operator.from("-"))).isEqualTo(-2);
    }

    @Test
    @DisplayName("덧셈을 연산한다.")
    void 덧셈() {
        assertThat(StringCalculator.getInstance().calculate(3, 5, Operator.from("+"))).isEqualTo(8);
    }



}
