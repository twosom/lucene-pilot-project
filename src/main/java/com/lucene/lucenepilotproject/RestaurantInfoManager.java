package com.lucene.lucenepilotproject;

import com.lucene.lucenepilotproject.helper.RestaurantInfoCsvLoader;
import com.lucene.lucenepilotproject.model.RestaurantInfoModel;
import com.lucene.lucenepilotproject.service.RestaurantInfoIndexService;
import com.lucene.lucenepilotproject.service.RestaurantInfoSearchService;

import java.io.IOException;
import java.util.List;

public class RestaurantInfoManager {

    public static void main(String[] args) throws IOException {
        RestaurantInfoCsvLoader loader = new RestaurantInfoCsvLoader();
        List<RestaurantInfoModel> restaurantInfoModels = loader.loadRestaurantInfo();

        RestaurantInfoIndexService indexService = new RestaurantInfoIndexService();
        indexService.indexRestaurantInfo(restaurantInfoModels);

        RestaurantInfoSearchService searchService = new RestaurantInfoSearchService();
        searchService.search("선릉");

    }

}
