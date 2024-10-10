package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculateParameterTest {

    @Test
    @DisplayName("숫자인 경우 숫자를 반환한다.")
    void 숫자인_경우() {
        CalculateParameter parameter = new CalculateParameter();
        assertThat(parameter.parseNumber("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 경우 exception을 발생한다.")
    void 숫자_아닌경우() {
        CalculateParameter parameter = new CalculateParameter();
        assertThatThrownBy(() -> parameter.parseNumber("a"))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @DisplayName("연산자인 경우 true를 반환한다.")
    @ValueSource(strings = {"+", "*", "/", "-"})
    void 연산자인_경우(String text) {
        CalculateParameter parameter = new CalculateParameter();
        assertThat(parameter.isOperator(text)).isTrue();
    }

    @Test
    @DisplayName("연산자가 아닌 경우 exception을 발생한다.")
    void 연산자_아닌경우() {
        CalculateParameter parameter = new CalculateParameter();
        assertThatThrownBy(() -> parameter.isOperator("_"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("숫자 큐와 연산자 큐의 개수가 1개 차이가 나면 true를 반환한다.")
    void 큐_개수_비교() {
        CalculateParameter parameter = new CalculateParameter();
        parameter.addNumbers(1);
        parameter.addNumbers(2);
        parameter.addOperators("*");
        assertThat(parameter.validateQueueSize()).isTrue();
    }

    @Test
    @DisplayName("숫자 큐와 연산자 큐의 개수가 1개 차이가 나지 않으면 exception을 발생한다.")
    void 큐_개수_비교_exception() {
        CalculateParameter parameter = new CalculateParameter();
        parameter.addNumbers(1);
        parameter.addOperators("*");
        assertThatThrownBy(parameter::validateQueueSize)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("연산자 queue에 값을 넣는다.")
    void 연산자_큐_값삽입() {
        CalculateParameter parameter = new CalculateParameter();
        parameter.addOperators("*");
        assertThat(parameter.operatorsSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 queue에 값을 넣는다.")
    void 숫자_큐_값삽입() {
        CalculateParameter parameter = new CalculateParameter();
        parameter.addNumbers(4);
        assertThat(parameter.numbersSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열이 비어있는 경우 exception을 발생한다.")
    void 문자열_null_또는_공백() {
        CalculateParameter parameter = new CalculateParameter();
        assertThatThrownBy(() -> parameter.split(""))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> parameter.split(null))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("문자열을 공백 기준으로 split 한다.")
    void 문자열_split() {
        CalculateParameter parameter = new CalculateParameter();
        List<String> result = parameter.split("3 + 5");
        assertThat(result).hasSize(3);
    }
}
