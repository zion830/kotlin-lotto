package lotto.domain.lotto

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @DisplayName("로또 번호로 1~45 사이의 정수를 사용한다.")
    @ParameterizedTest
    @ValueSource(ints = [-1, 46])
    fun lottoNumberNotInRange(number: Int) {
        assertThatIllegalArgumentException().isThrownBy { LottoNumber.of(number) }
    }
}
