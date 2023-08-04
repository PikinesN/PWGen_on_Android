package com.example.pwgen

import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import kotlin.coroutines.coroutineContext

class Generate {

    var a = 0
    var b = 0
    var string = ""


    fun prov(string:String):Boolean {
        var a = false

        for (ElementsMasiva in const.masiv) {
            for (lettersInMasiv in ElementsMasiva) {
                for (simvol in string) {
                    if (lettersInMasiv == simvol) {
                        a = true
                        //Как проверить все строки?
                    }
                }
            }
        }

        return a
    }


    // по идеи правильная функция
    fun AddAndProvPassword(quantity:Int, longPassword: Int) {

        while (a < quantity) {
              while (b < longPassword) {
                  val rand = const.simvols.random().toChar()
                  string += rand
                  b++
              }
            if (!prov(string)) {
                string = ""
                b = 0
            }
            else {
                a++
                const.passwords.add(string)
                b = 0
                string = ""
            }
    }
        a = 0
        b = 0
        string = ""
        const.simvols = ""
        const.masiv.clear()

//        while (a < quantity) {
//                while (b < longPassword) {
//                    val rand = const.simvols.random().toChar()
//                    string += rand
//                    b++
//                }
//
//            if (!prov(const.simvols,string)) {
//                if (a == 0) {
//                    a = 0
//                    string = ""
//                    b = 0
//                }
//                else {
//                    a--
//                    string = ""
//                    b = 0
//                }
//
//            }
//            else {
//                const.passwords.add(string)
//                b = 0
//                string = ""
//                a++
//            }
//        }
//        a = 0
//        b = 0
//        string = ""
//        const.simvols = ""
    }


    fun gen(longPassword: Int, chk1:CheckBox, chk2:CheckBox, chk3:CheckBox, chk4:CheckBox) {




        if (chk1.isChecked && chk2.isChecked && chk3.isChecked && chk4.isChecked) {
            const.masiv.add(const.letter)
            const.masiv.add(const.letterPlus)
            const.masiv.add(const.numbers)
            const.masiv.add(const.specSIMVOL)
            const.simvols += const.letter + const.letterPlus + const.numbers + const.specSIMVOL
            AddAndProvPassword(5,longPassword)


        }
        else if (chk1.isChecked) {
            while (a < 5) {
                while (b < longPassword) {
                    val rand = const.letter.random()
                    string += rand
                    b++
                }
                const.passwords.add(string)
                b = 0
                string = ""
                a++
            }
            a = 0
            b = 0
            string = ""
        }




//        if (chk1.isChecked && chk2.isChecked) {
//            masiv.add(const.letter)
//            masiv.add(const.letterPlus)
//
//            while (a < 5) {
//                while (b < longPassword) {
//                    val rand = masiv.random()
//                    string += rand
//                    b++
//                }
//                a++
//            }
//
//
//        }

    }
}