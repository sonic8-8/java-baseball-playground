package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        // given
        String actual = "1,2";

        // when
        String[] splits = actual.split(",");

        // then
        assertThat(splits).contains("1");
        assertThat(splits).contains("2");
    }

    @Test
    void split2() {
        // given
        String actual = "1";

        // when
        String[] splits = actual.split(",");

        // then
        assertThat(splits).contains("1");
    }

    @Test
    void substring() {
        // given
        String actual = "(1,2)";

        // when
        String substring = actual.substring(1, actual.length() - 1);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("charAt()으로 문자열의 특정 위치 문자를 가져올 수 있다.")
    @Test
    void charAt() {
        // given
        String actual = "abc";

        // when
        char zeroIndexChar = actual.charAt(0);

        // then
        assertThat(zeroIndexChar).isEqualTo('a');
        assertThatThrownBy(() -> actual.charAt(100))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 100");

    }
}
