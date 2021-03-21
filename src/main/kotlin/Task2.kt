const val moneyCoefficient = 100
const val maxFreeRangeMastercardOrMaestro = 75_000 * moneyCoefficient
const val commissionMastercardOrMaestroPercentCoefficient = 0.006
const val commissionMastercardOrMaestroValue = 20 * moneyCoefficient
const val commissionVisaOrMirPercentCoefficient = 0.0075
const val commissionVisaOrMirPercentValue = 35 * moneyCoefficient

fun main() {

    val typeCard = TypeCard.MastercardOrMaestro
    val amountPreviousTransfers = 10_000_000
    val totalCurrentTransfers = 100_000

    printComission(typeCard, amountPreviousTransfers, totalCurrentTransfers)
}

fun printComission(typeCard: TypeCard, amountPreviousTransfers: Int, totalCurrentTransfers: Int) {
    val commission: Double

    when (typeCard) {
        TypeCard.MastercardOrMaestro -> {
            commission = calculateComissionMastercardAndMaestro(
                amountPreviousTransfers,
                totalCurrentTransfers,
            )
        }
        TypeCard.VisaOrMir -> {
            commission = calculateComissionVisaAndMir(totalCurrentTransfers)
        }
        else -> {
            commission = 0.0
        }
    }
    println("При переводе ${totalCurrentTransfers / moneyCoefficient} руб. коммисия соствит $commission руб")
}

fun calculateComissionVisaAndMir(totalCurrentTransfers: Int): Double {

    return (totalCurrentTransfers.toDouble() * commissionVisaOrMirPercentCoefficient
            + commissionVisaOrMirPercentValue) / moneyCoefficient
}


fun calculateComissionMastercardAndMaestro(
    amountPreviousTransfers: Int,
    totalCurrentTransfers: Int,
): Double {
    val total = amountPreviousTransfers + totalCurrentTransfers
    val commission: Double

    when {
        total > maxFreeRangeMastercardOrMaestro -> {
            if (amountPreviousTransfers - maxFreeRangeMastercardOrMaestro < 0) {
                commission = ((totalCurrentTransfers.toDouble()
                        + amountPreviousTransfers - maxFreeRangeMastercardOrMaestro) * commissionMastercardOrMaestroPercentCoefficient
                        + commissionMastercardOrMaestroValue) / moneyCoefficient
            } else {
                commission = (totalCurrentTransfers.toDouble() * commissionMastercardOrMaestroPercentCoefficient
                        + commissionMastercardOrMaestroValue) / moneyCoefficient
            }
        }
        else -> {
            commission = 0.0
        }
    }
    return commission
}

enum class TypeCard {
    MastercardOrMaestro,
    VisaOrMir,
    VkPay
}
