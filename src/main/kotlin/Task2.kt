import java.util.*

const val moneyCoefficient = 100

const val maxFreeRangeMastercardOrMaestro = 75_000 * moneyCoefficient

const val commissionMastercardOrMaestroPercentCoefficient = 0.006
const val commissionMastercardOrMaestroValue = 20 * moneyCoefficient
const val commissionVisaOrMirPercentCoefficient = 0.0075
const val commissionVisaOrMirPercentValue= 35 * moneyCoefficient

fun main(){

    val scanner = Scanner(System.`in`)

    val typeCard = defineTypeCard(scanner)
    val amountPreviousTransfers = defineAmountPreviousTransfers(scanner) * moneyCoefficient
    val totalCurrentTransfers = defineTotalCurrentTransfers(scanner) * moneyCoefficient

    printCommission(typeCard,amountPreviousTransfers, totalCurrentTransfers, scanner)
    scanner.close()
}

fun printCommission(typeCard: TypeCard = TypeCard.VkPay,amountPreviousTransfers: Int = 0, totalCurrentTransfers: Int, scanner: Scanner){

    val totalCurrentTransfersRub = totalCurrentTransfers / moneyCoefficient

    when(typeCard){
        TypeCard.MastercardOrMaestro -> {

            val total = amountPreviousTransfers + totalCurrentTransfers

            when{
                total > maxFreeRangeMastercardOrMaestro -> {
                    if (amountPreviousTransfers - maxFreeRangeMastercardOrMaestro < 0){
                        println("При переводе $totalCurrentTransfersRub руб. коммисия соствит ${((totalCurrentTransfers.toDouble()
                                + amountPreviousTransfers - maxFreeRangeMastercardOrMaestro) * commissionMastercardOrMaestroPercentCoefficient
                                + commissionMastercardOrMaestroValue) / moneyCoefficient} руб")
                    } else{
                        println("При переводе $totalCurrentTransfersRub руб. коммисия соствит ${(totalCurrentTransfers.toDouble() * commissionMastercardOrMaestroPercentCoefficient
                                + commissionMastercardOrMaestroValue) / moneyCoefficient} руб")
                    }
                }
                else -> {
                    println("При переводе $totalCurrentTransfersRub руб. коммисия соствит 0 руб")
                }
            }
        }
        TypeCard.VisaOrMir -> {
            println("При переводе $totalCurrentTransfersRub руб. коммисия соствит ${(totalCurrentTransfers.toDouble() * commissionVisaOrMirPercentCoefficient
                    + commissionVisaOrMirPercentValue) / moneyCoefficient} руб")
        }
        else -> {
            println("При переводе $totalCurrentTransfersRub руб. коммисия соствит 0 руб")
        }
    }
}

fun defineTypeCard(scanner: Scanner): TypeCard{
    println("""Выберите Тип карты/счёта
        |1. Mastercard или Maestro;
        |2. Visa или Мир;
        |3. Vk Pay.
    """.trimMargin())

    val userInput = scanner.nextInt()
    return when(userInput){
        1 -> TypeCard.MastercardOrMaestro
        2 -> TypeCard.VisaOrMir
        else -> TypeCard.VkPay
    }
}

fun defineAmountPreviousTransfers(scanner: Scanner): Int{
    println("Введите сумму предыдущих переводов в этом месяце.")
    val userInput = scanner.nextInt()
    return userInput
}

fun defineTotalCurrentTransfers(scanner: Scanner): Int{
    println("Введите сумму совершаемого перевода")
    val userInput = scanner.nextInt()
    return userInput
}

enum class TypeCard{
    MastercardOrMaestro,
    VisaOrMir,
    VkPay
}
