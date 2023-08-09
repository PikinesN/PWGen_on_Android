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

        val provero4nieMasiv = arrayListOf<Boolean>()
        var a = true

        println(const.masiv.size)
        for (lettersInMasiv in const.masiv) {
            outerLoop@ for (simvol in lettersInMasiv) {
                //Тут проверяется символ объектов
                for (it in string) {
                    if (it == simvol) {
                        provero4nieMasiv.add(true)
                        break@outerLoop
                    }
                }
            }
        }
        if (provero4nieMasiv.size != const.masiv.size) {
            a = false
        }
        return a
    }

    fun AddAndProvPassword(quantity:Int, longPassword: Int) {

        while (a < quantity) {
              while (b < longPassword) {
                  val rand = const.simvols.random()
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
        else if (chk1.isChecked && chk2.isChecked && chk3.isChecked) {
            const.masiv.add(const.letter)
            const.masiv.add(const.letterPlus)
            const.masiv.add(const.numbers)
            const.simvols += const.letter + const.letterPlus + const.numbers
            AddAndProvPassword(5,longPassword)
        }
        else if (chk1.isChecked && chk2.isChecked && chk4.isChecked) {
            const.masiv.add(const.letter)
            const.masiv.add(const.letterPlus)
            const.masiv.add(const.specSIMVOL)
            const.simvols += const.letter + const.letterPlus + const.specSIMVOL
            AddAndProvPassword(5,longPassword)
        }
        else if (chk1.isChecked && chk3.isChecked && chk4.isChecked) {
            const.masiv.add(const.letter)
            const.masiv.add(const.numbers)
            const.masiv.add(const.specSIMVOL)
            const.simvols += const.letter  + const.numbers + const.specSIMVOL
            AddAndProvPassword(5,longPassword)
        }
        else if (chk2.isChecked && chk3.isChecked && chk4.isChecked) {
            const.masiv.add(const.letterPlus)
            const.masiv.add(const.numbers)
            const.masiv.add(const.specSIMVOL)
            const.simvols += const.letterPlus + const.numbers + const.specSIMVOL
            AddAndProvPassword(5,longPassword)
        }
        else if (chk1.isChecked && chk2.isChecked) {
            const.masiv.add(const.letter)
            const.masiv.add(const.letterPlus)
            const.simvols += const.letter + const.letterPlus
            AddAndProvPassword(5,longPassword)
        }
        else if (chk3.isChecked && chk4.isChecked) {
            const.masiv.add(const.numbers)
            const.masiv.add(const.specSIMVOL)
            const.simvols += const.numbers + const.specSIMVOL
            AddAndProvPassword(5,longPassword)
        }
        else if (chk2.isChecked && chk4.isChecked) {
            const.masiv.add(const.letterPlus)
            const.masiv.add(const.numbers)
            const.simvols += const.letterPlus + const.specSIMVOL
            AddAndProvPassword(5,longPassword)
        }
        else if (chk1.isChecked && chk4.isChecked) {
            const.masiv.add(const.letter)
            const.masiv.add(const.specSIMVOL)
            const.simvols += const.letter + const.specSIMVOL
            AddAndProvPassword(5,longPassword)
        }
        else if (chk1.isChecked && chk3.isChecked) {
            const.masiv.add(const.letter)
            const.masiv.add(const.numbers)
            const.simvols += const.letter + const.numbers
            AddAndProvPassword(5,longPassword)
        }
        else if (chk2.isChecked && chk3.isChecked) {
            const.masiv.add(const.letterPlus)
            const.masiv.add(const.numbers)
            const.simvols += const.letterPlus + const.numbers
            AddAndProvPassword(5,longPassword)
        }
        else if (chk2.isChecked) {
            const.masiv.add(const.letterPlus)
            const.simvols += const.letterPlus
            AddAndProvPassword(5, longPassword)
        }
        else if (chk3.isChecked) {
            const.masiv.add(const.numbers)
            const.simvols += const.numbers
            AddAndProvPassword(5, longPassword)
        }
        else if (chk4.isChecked) {
            const.masiv.add(const.specSIMVOL)
            const.simvols += const.specSIMVOL
            AddAndProvPassword(5, longPassword)
        }
        else if (chk1.isChecked) {
            const.masiv.add(const.letter)
            const.simvols += const.letter
            AddAndProvPassword(5,longPassword)
        }
    }
}