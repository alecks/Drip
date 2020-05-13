package gg.owo.drip

import com.fasterxml.jackson.annotation.JsonCreator

// Outgoing
data class DripId(private val requested: NewDripId) {

    var ids: Array<String> = arrayOf()

    init {
        for (origin in requested.origins) {
            var identifier = ""

            for ((index, character) in origin.withIndex()) {
                if (index > 2) break

                var charCode = character.toInt().toString()
                if (charCode.length < 3) charCode += (1..9).random()
                else if (charCode.length > 3) charCode = charCode.substring(charCode.lastIndex - 2)
                identifier += charCode
            }

            while (identifier.length < 9) identifier += (100..999).random()

            ids = ids.plus(identifier + System.nanoTime())
        }
    }

}

// Incoming
data class NewDripId @JsonCreator constructor(
        val origins: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NewDripId

        if (!origins.contentEquals(other.origins)) return false

        return true
    }

    override fun hashCode(): Int {
        return origins.contentHashCode()
    }
}
