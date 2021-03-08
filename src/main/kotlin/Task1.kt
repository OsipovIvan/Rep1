
fun main(){

    val coefficientMinutes = 60
    val coefficientHours = 60 * 60
    val coefficientDays = 24 * 60 * 60

    val now = 0 until coefficientMinutes
    val minutes = coefficientMinutes until coefficientHours
    val hours = coefficientHours until coefficientDays
    val today = coefficientDays until coefficientDays * 2
    val yesterday = coefficientDays * 2 until coefficientDays * 3
    val longAgo = coefficientDays * 3 until Int.MAX_VALUE

    val absentTime = 21 * coefficientMinutes

    when(absentTime){
        in now -> {
            println("был(а) только что")
        }
        in minutes -> {
            println("был(а) в сети ${absentTime / coefficientMinutes} ${handlingMinutes(absentTime / coefficientMinutes)} назад")
        }
        in hours -> {
            println("был(а) в сети ${absentTime / coefficientHours} ${handlingHours(absentTime / coefficientHours)} назад")
        }
        in today -> {
            println("был(а) в сети сегодня")
        }
        in yesterday -> {
            println("был(а) в сети вчера")
        }
        in longAgo -> {
            println("был(а) в сети давно")
        }
    }
}

fun handlingMinutes(minutes: Int): String =
    when{
        minutes % 10 == 1 && minutes % 100 != 11 -> {
            "минуту"
        }
        (minutes % 10 == 2 || minutes % 10 == 3 || minutes % 10 == 4) &&
                (minutes % 100 != 12 || minutes % 100 != 13 || minutes % 100 != 14) -> {
                    "минуты"
                }
        else -> {
            "минут"
        }
    }

fun handlingHours(hours: Int): String =
    when{
        hours % 10 == 1 && hours % 100 != 11 -> {
            "час"
        }
        (hours % 10 == 2 || hours % 10 == 3 || hours % 10 == 4) &&
                (hours % 100 != 12 || hours % 100 != 13 || hours % 100 != 14) -> {
            "часа"
        }
        else -> {
            "часов"
        }
    }


