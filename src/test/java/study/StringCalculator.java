package study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculator {

    public int calculate(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            return 0;
        }

        String[] splits = userInput.split(" ");

        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        for (String split : splits) {
            if (Character.isDigit(split.charAt(0))) {
                numbers.add(Integer.parseInt(split));
                continue;
            }

            if (split.equals("+")) {
                operators.add("+");
                continue;
            }
            if (split.equals("-")) {
                operators.add("-");
                continue;
            }
            if (split.equals("*")) {
                operators.add("*");
                continue;
            }
            if (split.equals("/")) {
                operators.add("/");
            }
        }

        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals("+")) {
                result += numbers.get(i + 1);
                continue;
            }
            if (operators.get(i).equals("-")) {
                result -= numbers.get(i + 1);
                continue;
            }
            if (operators.get(i).equals("*")) {
                result *= numbers.get(i + 1);
                continue;
            }
            if (operators.get(i).equals("/")) {
                result /= numbers.get(i + 1);
            }
        }
        return result;
    }

    @Test
    void calculate() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String userInput = "2 + 3 * 4 / 2";

        // when
        int result = stringCalculator.calculate(userInput);

        // then
        assertThat(result).isEqualTo(10);
    }
}
