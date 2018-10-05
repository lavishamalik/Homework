package com.codingblocks.weather

data class finalclass(val list:ArrayList<result>,
                      val city:cityclass)
data class result(val main:reusableclass,
                  val weather:ArrayList<weatherdes>,
                  val wind:windclass,
                  val dt_txt:String
)

data class reusableclass(val temp:Float,
                         val temp_min:Float,
                         val temp_max:Float,
                         val pressure:Float,
                         val sea_level:Float,
                         val grnd_level:Float,
                         val humidity:Int
)
data class weatherdes(val description:String,
                      val icon:String)
data class windclass(val speed:Float)
data class cityclass(val name:String,
                     val country:String,
                     val coord:coordclass)
data class coordclass(val lat:Int,
                      val lon:Int
)