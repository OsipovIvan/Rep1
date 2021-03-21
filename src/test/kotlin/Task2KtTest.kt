import junit.framework.Assert.assertEquals
import org.junit.Test

class Task2KtTest {

    @Test
    fun calculateComissionVisaAndMirTest(){

        val totalCurrentTransfers = 1000 * moneyCoefficient

        val result = calculateComissionVisaAndMir(totalCurrentTransfers)
        assertEquals(42.5, result, 0.0000)
    }

    @Test
    fun calculateComissionMastercardAndMaestroTestFreeLimitEnded(){

        val amountPreviousTransfers = 100_000 * moneyCoefficient
        val totalCurrentTransfers = 1000 * moneyCoefficient

        val result = calculateComissionMastercardAndMaestro(amountPreviousTransfers, totalCurrentTransfers)
        assertEquals(26.0, result, 0.0000)
    }

    @Test
    fun calculateComissionMastercardAndMaestroTestFreeLimitNotEnded(){

        val amountPreviousTransfers = 0
        val totalCurrentTransfers = 1000 * moneyCoefficient

        val result = calculateComissionMastercardAndMaestro(amountPreviousTransfers, totalCurrentTransfers)
        assertEquals(0.0, result, 0.0000)
    }

    @Test
    fun calculateComissionMastercardAndMaestroTestFreeLimitPartEnded(){

        val amountPreviousTransfers = 74_500 * moneyCoefficient
        val totalCurrentTransfers = 1000 * moneyCoefficient

        val result = calculateComissionMastercardAndMaestro(amountPreviousTransfers, totalCurrentTransfers)
        assertEquals(23.0, result, 0.0000)
    }

    @Test
    fun printComissionTestMastercardOrMaestro(){

        val typeCard = TypeCard.MastercardOrMaestro
        val amountPreviousTransfers = 10_000_000
        val totalCurrentTransfers = 100_000

        val result = printComission(typeCard, amountPreviousTransfers, totalCurrentTransfers)
    }

    @Test
    fun printComissionTestVisaOrMir(){

        val typeCard = TypeCard.VisaOrMir
        val amountPreviousTransfers = 10_000_000
        val totalCurrentTransfers = 100_000

        val result = printComission(typeCard, amountPreviousTransfers, totalCurrentTransfers)
    }

    @Test
    fun printComissionTestVkPay(){

        val typeCard = TypeCard.VkPay
        val amountPreviousTransfers = 10_000_000
        val totalCurrentTransfers = 100_000

        val result = printComission(typeCard, amountPreviousTransfers, totalCurrentTransfers)
    }

    @Test
    fun mainTest(){
        main()
    }
}