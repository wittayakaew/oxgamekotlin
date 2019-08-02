var oxtable = arrayOf(
    arrayOf("-","-","-"),
    arrayOf("-","-","-"),
    arrayOf("-","-","-")
)
var turn = "X"
var rowind = 0
var colind = 0
fun input() {
    while (true){
        try {
            println("Enter Input Number Row Col : ")
            var num = readLine()
            var numlist = num?.split(" ")
            if(numlist?.size==2){
                rowind = numlist?.get(0).toInt()
                colind = numlist?.get(1).toInt()
                if(rowind>3||rowind<1){
                    println("Error input fail")
                    continue
                }
                else if(colind>3||colind<1){
                    println("Error input fail")
                    continue
                }else{
                    println("Row ${numlist?.get(0)} Col ${numlist?.get(1)}")
                }


                break
            }else{
                println("Error Please input 2 number")
                continue
            }



        }catch (e:Throwable){
    println("Error ${e.message} ,Must be number")
        }

    }


}

fun setTable(){
    if(oxtable[rowind-1][colind-1]=="-"){
        oxtable[rowind-1][colind-1] = turn
    }else{
        println("Error can't put $turn")
    }

}
fun swit(){
    if(turn=="X"){
        turn = "O"
    }else{
        turn= "X"
    }
    println("Turn $turn")
}

fun showtable(){
    for(row in oxtable){
        for (j in row ){
            print("$j ")
        }
        println()
    }
}
fun checkWin():Int {

    for (row in oxtable.indices) {
        if (oxtable[row][0].plus(oxtable[row][1]).plus(oxtable[row][2]).equals("OOO")) {
            println("O win")
            return 1
        } else if (oxtable[row][0].plus(oxtable[row][1]).plus(oxtable[row][2]).equals("XXX")) {
            println("X win")
            return 1
        }
    }
    for (col in oxtable.indices) {
        if (oxtable[0][col].plus(oxtable[1][col]).plus(oxtable[2][col]).equals("OOO")) {
            println("O win")
            return 1
        } else if (oxtable[0][col].plus(oxtable[1][col]).plus(oxtable[2][col]).equals("XXX")) {
            println("X win")
            return 1
        }
    }
    return 0
}

fun main() {
    println("Welcome to OX Game")
    showtable()
    while (true){
        input()
        setTable()
        showtable()
        println()
        swit()
        if(checkWin()!=0){
            break
        }
    }
}