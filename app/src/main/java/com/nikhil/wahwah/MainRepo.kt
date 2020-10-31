package com.nikhil.wahwah

class MainRepo {

    val dataList : List<Data> = listOf(
        Data(1, "Colosseum", "Rome", "https://lonelyplanetwpnews.imgix.net/2018/02/shutterstockRF_433413835-e1519389484386.jpg"),
        Data(2, "Pyramids Of Giza", "Egypt", "https://lonelyplanetimages.imgix.net/a/g/hi/t/82e213048af4e026b6ba31e8f24cc923-pyramids-of-giza.jpg"),
        Data(3, "Taj Mahal", "Agra", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Taj_Mahal_N-UP-A28-a.jpg/1200px-Taj_Mahal_N-UP-A28-a.jpg"),
        Data(4, "Monument Valley", "USA", "https://southwestdesertlover.files.wordpress.com/2014/11/monument-valley-sunset.jpg"),
        Data(5, "Tower Of Pisa", "Italy", "https://images2.minutemediacdn.com/image/upload/c_crop,h_2661,w_4738,x_0,y_101/f_auto,q_auto,w_1100/v1554926096/shape/mentalfloss/istock-856266768.jpg"),
        Data(6, "Pandora", "Avatar", "https://www.hdwallpapers.in/download/pandora_avatar_5k-wide.jpg")
    )

    fun getFilteredList(query: String): List<Data> {
        return dataList.filter { data ->
            data.name.contains(query, true) || data.location.contains(query, true)
        }
    }

}