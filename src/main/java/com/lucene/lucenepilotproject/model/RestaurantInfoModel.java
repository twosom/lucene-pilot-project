package com.lucene.lucenepilotproject.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantInfoModel {

    /**
     * 음식점 명
     */
    @CsvBindByPosition(position = 0)
    private String restaurantName;
    /**
     * 카테고리 1
     */
    @CsvBindByPosition(position = 1)
    private String category1;
    /**
     * 카테고리 2
     */
    @CsvBindByPosition(position = 2)
    private String category2;
    /**
     * 카테고리 3
     */
    @CsvBindByPosition(position = 3)
    private String category3;
    /**
     * 지역명
     */
    @CsvBindByPosition(position = 4)
    private String region;
    /**
     * 시군구명
     */
    @CsvBindByPosition(position = 5)
    private String city;
    /**
     * 개요
     */
    @CsvBindByPosition(position = 6)
    private String description;

}
