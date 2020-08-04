package calculator.domain

data class Expression(private val expression: String) {
    private val parsedExpression = parse()

    fun extractTokens(): List<String> = if (hasCustomDelimiter()) {
        parsedExpression[2].split(parsedExpression[1])
    } else {
        expression.split(*DELIMITERS)
    }.map { it.trim() }

    fun isValid() = extractTokens().all {
        val number = it.toIntOrNull()
        number != null && number >= 0
    }

    private fun hasCustomDelimiter() = parsedExpression.size == CUSTOM_DELIMITER_TOKEN_SIZE

    private fun parse() = PATTERN.find(expression)?.groupValues ?: emptyList()

    companion object {
        private const val CUSTOM_DELIMITER_TOKEN_SIZE = 3
        private val DELIMITERS = arrayOf(",", ":")
        private val PATTERN = "//(.)\n(.*)".toRegex()
    }
}
