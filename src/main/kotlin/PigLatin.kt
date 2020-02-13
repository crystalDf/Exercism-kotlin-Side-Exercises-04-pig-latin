object PigLatin {

    fun translate(phrase: String): String {

        return phrase.split(" ").joinToString(" ") {
            translateWord(it)
        }
    }

    private fun translateWord(word: String): String {

        val vowels = listOf("xr", "yt").plus("aeiou".toList().map { it.toString() })
        val consonants = listOf("thr", "sch", "ch", "qu", "th")
                .plus(('a'..'z').filter { it !in "aeiou" }.map { listOf(it.plus("qu"), it.toString()) }.flatten())

        if ((word.length > 2) && word[2] == 'y'
                && (word[0].toString() in consonants) && (word[1].toString() in consonants)) {
            return "${word.substring(2 until word.length)}${word.substring(0 until 2)}ay"
        }

        vowels.forEach {
            if (word.startsWith(it)) {
                return "${word}ay"
            }
        }

        consonants.forEach {
            if (word.startsWith(it)) {
                return "${word.substring(it.length until word.length)}${it}ay"
            }
        }

        return "Unreachable code"
    }
}
