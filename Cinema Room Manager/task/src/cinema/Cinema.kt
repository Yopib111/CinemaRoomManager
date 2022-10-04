package cinema

fun main() {
    var total = 0
    var totalIncome = 0
    println("Enter the number of rows:")
    val row = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    val cinema = mutableListOf<MutableList<Char>>()
    var ticketsCOUNT = 0
    var percentage = 0.0
    var check = 0



    for (i in 1 .. row) {
        val rows = mutableListOf<Char>()
        for (j in 1..seats) {
            rows += 'S'
        }
        cinema += rows

    }
//считаем totalIncome
    if (row * seats <= 60) totalIncome = row * seats * 10
    else {
        if (row % 2 == 0) {
            totalIncome = (row / 2 * 10) * seats + (row / 2 * 8) * seats
        } else totalIncome = (row / 2 * 10) * seats + ((row - (row / 2)) * 8) * seats
    }




    fun printCinema() {
    println()
    println("Cinema:")
    print("  ")
    for (columns in 1..seats) {
        print("$columns ")
    }
    println()
    for (i in 0..row - 1) {
        println(cinema[i].joinToString(separator = " ", prefix = "${i + 1} "))
    }
    println()
}

    printCinema()

   var menu = 0

    do {

        println(
            """
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
        """.trimIndent()
        )
        menu = readln().toInt()
        when (menu) {
            1 -> printCinema()
            2 -> {
                do {
                    var price = 0
                    println("Enter a row number:")
                    val rowNumber = readln().toInt()
                    println("Enter a seat number in that row:")
                    val seatNumber = readln().toInt()

                    if (rowNumber !in 1..row || seatNumber !in 1..seats) {
                        println("Wrong input!")
                        println()
                        continue
                    } else if (cinema[rowNumber - 1][seatNumber - 1] == 'S') {
                        cinema[rowNumber - 1][seatNumber - 1] = 'B'
                        check = 1
                        if (row * seats <= 60) {
                            total += 10
                            ticketsCOUNT++
                            price = 10
                        } else {
                            if (row / 2 - rowNumber >= 0) {
                                total += 10
                                price = 10
                            } else {
                                total += 8
                                price = 8
                            }
                            ticketsCOUNT++
                        }
                        println("Ticket price: $$price")
                        println()
                    } else {
                        println("That ticket has already been purchased!")
                        check = 0
                    }
                } while (check != 1)
            }
            3 -> {
                percentage = ticketsCOUNT.toDouble() * 100 / (row * seats)
                val formatPercentage = "%.2f".format(percentage)
                println("""
                    Number of purchased tickets: $ticketsCOUNT
                    Percentage: $formatPercentage%
                    Current income: $$total
                    Total income: $$totalIncome
                """.trimIndent())

            }
        }
    } while (menu != 0)



//
//        if (row % 2 == 0) {
//            total = (row / 2 * 10) * seats + (row / 2 * 8) * seats
//        } else total = (row / 2 * 10) * seats + ((row - (row / 2)) * 8) * seats
//    }
//    println("Total income:")
//    println("$$total")

}