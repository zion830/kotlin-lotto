package lotto.domain.generator

import lotto.domain.lotto.LottoNumber
import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoType

object ManualLottoGenerator {
    private const val NUMBER_DELIMITER = ","

    fun execute(input: String) = LottoTicket(LottoType.MANUAL, parseNumbers(input).toSortedSet())

    private fun parseNumbers(numbers: String) =
        numbers.split(NUMBER_DELIMITER)
            .filter { it.isNotBlank() }
            .map { LottoNumber.of(it.trim().toInt()) }
}
