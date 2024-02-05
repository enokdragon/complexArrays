import kotlin.system.exitProcess

fun main() {
    var tireShopArray = arrayOf("snow tires", "summer tires", "tire chains", "oil", "fuel filter")
    var amountArray = arrayOf("100", "80", "75", "750", "1200")
    var inventoryArray = arrayOf<Array<String>>()

    inventoryArray += tireShopArray
    inventoryArray += amountArray
    var index = 1

    var row = inventoryArray[0].size -1
    for(i in 0..row){
        var product = inventoryArray[0][i]
        println("$index:$product")
        index++
    }

    println("Enter the number of the product you would like to view details on")
    var search = readln().toInt()
    search = search - 1

    for(i in 0..row){
        var product = inventoryArray[0][i]
        var amount = inventoryArray[1][i]

        if(inventoryArray[0][i] == inventoryArray[0][search]){
            println("There are $amount units of $product left")
            println("Would you like to modify the amount? yes or no")
            var change = readln().toString()
            change.equals(change, ignoreCase = true)

            if(change == "yes") {
                println("would you like to add or subtract")
                var function = readln().toString()
                function.equals(function, ignoreCase = true)

                if (function == "add") {
                    println("How much would you like to add")
                    var amtChange = readln().toInt()

                    println("The product manipulated was $product")
                    println("The initial inventory amount was $amount")
                    println("You added a total of $amtChange to the inventory ")
                    var intAmt = amount.toInt()
                    intAmt += amtChange
                    inventoryArray[0][i] = intAmt.toString()
                    var newAmt = inventoryArray[0][i]
                    println("The new inventory amount is $newAmt")
                }
                else if(function == "subtract") {
                    println("How much would you like to subtract")
                    var amtChange = readln().toInt()

                    if(amtChange > amount.toInt()){
                        println("You have requested more stock than we have, the current stock is $amount but you can have the rest")
                        println("The product manipulated was $product")
                        println("The initial inventory amount was $amount")
                        println("You subtracted a total of $amtChange to the inventory, but we could only supply $amount")
                        inventoryArray[0][i] = "0"
                        var newAmt = inventoryArray[0][i]
                        println("The new inventory amount is $newAmt")
                    }
                    else{
                        println("The product manipulated was $product")
                        println("The initial inventory amount was $amount")
                        println("You subtracted a total of $amtChange to the inventory")
                        var intAmt = amount.toInt()
                        intAmt -= amtChange
                        inventoryArray[0][i] = intAmt.toString()
                        var newAmt = inventoryArray[0][i]
                        println("The new inventory amount is $newAmt")
                    }
                }
                else{
                    println("Sorry we don't understand")
                    exitProcess(0)
                }
            }
            else{
                exitProcess(0)
            }
        }
    }
}
